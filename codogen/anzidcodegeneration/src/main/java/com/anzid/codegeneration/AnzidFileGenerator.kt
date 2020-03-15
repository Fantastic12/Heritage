package com.anzid.codegeneration

import com.anzid.annotation.ComponentInjector
import com.anzid.annotation.DynamicInjector
import com.anzid.annotation.PublicLiveData
import com.anzid.codegeneration.componentinjector.ComponentInjectorGenerator
import com.anzid.codegeneration.componentinjector.ComponentInjectorObjectBuilder
import com.anzid.codegeneration.publiclivedata.PublicLiveDataGenerator
import com.google.auto.service.AutoService
import java.io.File
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.Element
import javax.lang.model.element.TypeElement
import javax.lang.model.type.MirroredTypesException
import javax.lang.model.type.TypeMirror

@AutoService(Processor::class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedOptions(AnzidFileGenerator.KAPT_KOTLIN_GENERATED_OPTION_NAME)
class AnzidFileGenerator : AbstractProcessor() {
    companion object {
        const val KAPT_KOTLIN_GENERATED_OPTION_NAME = "kapt.kotlin.generated"
        const val SUFFIX_CLASS_NAME = "Injector"
        const val PREFIX_FOR_GENERATED_CLASS = "Dynamic"
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> = mutableSetOf(
        ComponentInjector::class.java.name,
        PublicLiveData::class.java.name
    )

    override fun getSupportedSourceVersion(): SourceVersion = SourceVersion.latest()

    override fun process(set: MutableSet<out TypeElement>?, roundEnvironment: RoundEnvironment?): Boolean {
        roundEnvironment?.apply {
            getElementsAnnotatedWith(ComponentInjector::class.java)
                ?.forEach { ComponentInjectorGenerator(processingEnv).prepareClassInitialization(it) }

            getElementsAnnotatedWith(PublicLiveData::class.java)
                ?.forEach { PublicLiveDataGenerator(processingEnv).prepareClassInitialization(it) }
        }
        return true
    }

    private fun prepareDynamicInjectorClassInitialization(element: Element) {
        val className = element.simpleName.toString()
        val pack = processingEnv.elementUtils.getPackageOf(element).toString()
        val ann = element.getAnnotation(DynamicInjector::class.java)
        var typeMirror: TypeMirror? = null

        try {
            ann.dynamicFeatureImpl
        } catch (ex: MirroredTypesException) {
            typeMirror = ex.typeMirrors[0]
        }

        typeMirror?.let { generateClass(className, pack, typeMirror) }
    }

    private fun generateClass(className: String, pack: String, dfi: TypeMirror) {
        val suffixForFun = className.removeSuffix(SUFFIX_CLASS_NAME)
        val fileName = PREFIX_FOR_GENERATED_CLASS + className
        val fileContent = ComponentInjectorObjectBuilder(
            fileName,
            pack,
            suffixForFun,
            dfi
        ).getContent()

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
        val file = File(kaptKotlinGeneratedDir, "$fileName.kt")

        file.writeText(fileContent)
    }
}
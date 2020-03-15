package com.anzid.codegeneration.publiclivedata

import com.anzid.codegeneration.AnzidFileGenerator.Companion.KAPT_KOTLIN_GENERATED_OPTION_NAME
import com.anzid.codegeneration.Generator
import java.io.File
import javax.annotation.processing.ProcessingEnvironment
import javax.lang.model.element.Element

class PublicLiveDataGenerator(private val processingEnv: ProcessingEnvironment) : Generator {
    companion object {
        const val FILE_NAME = "PublicLvContainer"
    }

    override fun prepareClassInitialization(element: Element) {
        val fieldName = element.simpleName.toString()
        val pack = processingEnv.elementUtils.getPackageOf(element).toString()
        val typeLiveData = element.asType().toString()
        val enclosingElement = element.enclosingElement.simpleName.toString()

        val parameterizedType = typeLiveData.split('<').takeLast(1)[0].removeSuffix(">")

        val simpleParameterizableType = when {
            parameterizedType.contains(DataType.Integer.name) -> DataType.Integer.kotlinType
            parameterizedType.contains(DataType.String.name) -> DataType.Integer.kotlinType
            else -> parameterizedType
        }

        generateClass(fieldName, pack, enclosingElement, simpleParameterizableType)
    }

    private fun generateClass(fieldName: String, pack: String, className: String, typeParameterizedType: String) {
        val fileContent = PublicLiveDataObjectBuilder(
            fieldName,
            pack,
            className,
            typeParameterizedType
        ).getContent()

        val kaptKotlinGeneratedDir = processingEnv.options[KAPT_KOTLIN_GENERATED_OPTION_NAME]
        val file = File(kaptKotlinGeneratedDir, "$FILE_NAME.kt")

        file.writeText(fileContent)
    }


    enum class DataType(val kotlinType: kotlin.String) {
        Integer("Int"), String("String");
    }

}
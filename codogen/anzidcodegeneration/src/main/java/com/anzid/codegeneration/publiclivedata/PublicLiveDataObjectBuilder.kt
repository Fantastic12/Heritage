package com.anzid.codegeneration.publiclivedata

class PublicLiveDataObjectBuilder(
    nameMember: String,
    packageName: String,
    className: String,
    type: String
) {

    private val publicLiveDataName = nameMember.removePrefix("_")
    private val contentTemplate = """
        package $packageName
        
        import androidx.lifecycle.LiveData

        @Suppress("UNCHECKED_CAST")
        val ${className}.${publicLiveDataName} : LiveData<${type}>
            get() {
                 val lvPrivate = javaClass.getDeclaredField("$nameMember") 
                 lvPrivate.isAccessible = true 
                 val lv = lvPrivate.get(this) 
                 
                 return lv as LiveData<${type}>
            }
        
    """.trimIndent()

    fun getContent() = contentTemplate
}
package com.anzid.codegeneration

import javax.lang.model.element.Element

interface Generator {
    fun prepareClassInitialization(element: Element)
}
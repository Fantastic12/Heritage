package com.anzid.core

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class HeritageGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled() = false
}

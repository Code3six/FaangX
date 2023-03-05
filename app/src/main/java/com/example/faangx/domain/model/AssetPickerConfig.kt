package com.example.faangx.domain.model

import com.huhx.picker.constant.RequestType

data class AssetPickerConfig(
    val maxAssets: Int = 1,
    val gridCount: Int = 3,
    val requestType: RequestType = RequestType.COMMON
)

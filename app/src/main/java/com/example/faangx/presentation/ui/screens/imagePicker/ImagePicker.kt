package com.example.faangx.presentation.ui.screens.imagePicker

import android.Manifest
import androidx.compose.runtime.Composable
import com.huhx.picker.constant.AssetPickerConfig
import com.huhx.picker.data.AssetInfo
import com.huhx.picker.data.PickerPermissions
import com.huhx.picker.view.AssetPicker

@Composable
fun ImagePicker(
    onPicked: (List<AssetInfo>) -> Unit,
    onClose: (List<AssetInfo>) -> Unit,
){
    PickerPermissions(permissions = listOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)) {
        AssetPicker(
            assetPickerConfig = AssetPickerConfig(gridCount = 3, maxAssets = 1),
            onPicked = onPicked,
            onClose = onClose
        )
    }
}
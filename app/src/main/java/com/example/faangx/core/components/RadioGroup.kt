package com.example.faangx.core.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.faangx.presentation.ui.theme.Purple500
import com.example.faangx.presentation.ui.theme.bgColor2
import com.example.faangx.presentation.ui.theme.century1

@Composable
fun RadioGroup(
    items: List<String>,
    selected: String,
    setSelected: (selected: String) -> Unit
){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Center
        ) {
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item,
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.century1
                    )
                    RadioButton(
                        selected = selected == item,
                        onClick = {
                            setSelected(item)
                        },
                        enabled = true,
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colors.bgColor2
                        )
                    )

                }
            }
        }
    }
}
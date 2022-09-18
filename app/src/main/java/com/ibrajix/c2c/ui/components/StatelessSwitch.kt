package com.ibrajix.c2c.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import com.ibrajix.c2c.storage.StorageViewModel
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun StatelessSwitch(switchState: MutableState<Boolean>, storageViewModel: StorageViewModel = hiltViewModel() ) {

    val currentTheme = storageViewModel.selectedTheme.observeAsState()

    currentTheme.value?.let { it ->
        Switch(
            checked = it,
            onCheckedChange = {
                switchState.value = it
                storageViewModel.changeSelectedTheme(it)
            },

            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colors.onPrimary,
                uncheckedThumbColor = MaterialTheme.colors.onPrimary,
                checkedTrackColor = MaterialTheme.colors.secondary,
                uncheckedTrackColor = MaterialTheme.colors.secondary,
                checkedTrackAlpha = 1.0f,
                uncheckedTrackAlpha = 1.0f,
            ),
        )
    }

}

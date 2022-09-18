package com.ibrajix.c2c.storage

import kotlinx.coroutines.flow.Flow

interface LocalStorage {
    fun getSelectedTheme() : Flow<Boolean>
    suspend fun setSelectedTheme(theme: Boolean)
}
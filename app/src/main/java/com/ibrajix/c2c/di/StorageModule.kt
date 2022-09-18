package com.ibrajix.c2c.di

import com.ibrajix.c2c.storage.LocalStorage
import com.ibrajix.c2c.storage.Storage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindDataStorage(storage: Storage): LocalStorage

}
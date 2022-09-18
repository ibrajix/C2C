package com.ibrajix.c2c.data.repo

import com.ibrajix.c2c.network.ExhibitsLoader
import com.ibrajix.c2c.network.BaseDataSource
import javax.inject.Inject

class MainRepo @Inject constructor(private val exhibitsLoader: ExhibitsLoader) : BaseDataSource() {

    suspend fun getData() = safeApiCall{
        exhibitsLoader.getExhibitList()
    }

}
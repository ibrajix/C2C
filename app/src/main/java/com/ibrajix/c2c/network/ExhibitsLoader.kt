package com.ibrajix.c2c.network

import com.ibrajix.c2c.data.model.ExhibitResponse
import com.ibrajix.c2c.utils.EndPoints
import retrofit2.Response
import retrofit2.http.GET

interface ExhibitsLoader {

    @GET(EndPoints.LIST_URL)
    suspend fun  getExhibitList() : Response<ExhibitResponse>

}
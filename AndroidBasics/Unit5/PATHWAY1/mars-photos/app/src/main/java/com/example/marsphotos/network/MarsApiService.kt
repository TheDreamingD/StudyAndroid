package com.example.marsphotos.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType())) // 응답을 string으로 변환해주는 변환기 추가
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos") // retrofit에 이 함수가 get 요청임을 알림, photos는 웹 서비스 메서드의 엔드포인드(url 뒤에 붙는 주소)
    suspend fun getPhotos(): List<MarsPhoto> // 정지함수로 만든다.
}

object MarsApi {
    val retrofitService : MarsApiService by lazy { // lazy를 사용하면 처음 사용할 때 생성된다.,
        retrofit.create(MarsApiService::class.java) // create를 retrofit 객체 내에서 하면 비용이 많이 든다.
    }
}
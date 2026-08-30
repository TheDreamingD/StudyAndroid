package com.example.marsphotos.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class MarsPhoto(
    val id: String, // 변수 이름은 json 데이터의 키와 일치시켜줌
    @SerialName(value = "img_src") // json의 키와 다른 변수 이름을 사용하려면 이렇게 사용한다.
    val imgSrc: String
)
package com.mostafa.marvelapp.utilies

object Constants {
    val timeStamp = System.currentTimeMillis().toString()
    val hash = "$timeStamp${"97167552f487d49db5690666d472aa04e885bf9c"}${"0f7f148dacd5e3490419385c0e676117"}".toMD5()

    const val BASE_URL = "https://gateway.marvel.com:443/v1/public"
    const val PUBLIC_KEY = "0f7f148dacd5e3490419385c0e676117"
    const val PRIVATE_KEY = "97167552f487d49db5690666d472aa04e885bf9c"


    const val DATA_IS_NULL_ERROR_MESSAGE = "Something went wrong while trying to retrieve data!"
}
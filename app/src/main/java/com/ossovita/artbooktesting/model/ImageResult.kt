package com.ossovita.artbooktesting.model

import com.google.gson.annotations.SerializedName

data class ImageResult (
    val comments : Int,
    val downloads: Int,
    val favorites: Int,
    val id: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    @SerializedName("user_id")//burada oluşturulan değişkenle aynı isimde yazıyorsak seralizedname  yapmamıza gerek yok.Farklı isimle yazıyorsak yazmamız gerek
    val userId: Int,
    val imageUrl: String,
    val views: Int,
    val webFormatHeight: Int,
    val webFormatURL: String,
    val webFormatWidth: Int

    )

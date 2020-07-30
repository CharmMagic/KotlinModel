package com.example.kotlinmodel.bean

data class WordsBean(
    val showapi_res_body: ShowapiResBody,
    val showapi_res_code: Int,
    val showapi_res_error: String
)

data class ShowapiResBody(
    val allNum: Int,
    val allPages: Int,
    val contentlist: List<Contentlist>,
    val currentPage: Int,
    val maxResult: Int
)

data class Contentlist(
    val ct: String,
    val img: String,
    val title: String,
    val type: Int
)
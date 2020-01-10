package com.example.kotlinmodel.bean

/**
 *
 *@Date 2020-01-02 19:04
 *
 *@Auther weiwenxiao
 */
data class LoginBean(
    val desc_img: String,
    val gender: Int,
    val group_type: String,
    val role: String,
    val service_id: Int,
    val service_img: String,
    val service_name: String,
    val token: String,
    val user_id: Int,
    val user_position: String,
    val username: String
)
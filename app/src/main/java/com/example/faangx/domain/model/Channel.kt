package com.example.faangx.domain.model

data class Channel(
    val id: String,
    val type: ChannelType,
    val name: String,
    val description: String?,
    val members: List<String>,
    val messages: List<String>
)
package com.example.faangx.domain.model

import com.google.firebase.Timestamp

data class Message(
    val time: Timestamp,
    val sender: String,
    val message: String,
    val mediaUrl: String?
)

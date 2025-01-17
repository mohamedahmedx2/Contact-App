package com.example.contacts

import android.widget.ImageView

data class ItemContact(
    val name: String,
    val emailName: String,
    val imageRemove: ImageView? = null,
    val phoneNumber: String
)

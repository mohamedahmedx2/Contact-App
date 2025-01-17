package com.example.contacts

import android.util.Patterns

object Validate {
    fun validateName(name: String): String? {
        if (name.isBlank()) {
            return "Required"
        }

        return null
    }

    fun validateEmail(email: String): String? {
        if (email.isBlank()) {
            return "Required"
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return "Invalid email format"
        }

        return null
    }

    fun validatePhone(phone: String): String? {
        if (phone.isBlank()) {
            return "Required"
        }
        if (!phone.matches("^[0-9]{7,15}$".toRegex())) {
            return "Invalid phone format"
        }
        return null
    }
}
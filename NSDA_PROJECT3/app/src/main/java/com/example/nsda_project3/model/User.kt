package com.example.nsda_project3.model

import com.google.firebase.database.PropertyName // Correct import

data class User(
    val userId: String,
    @get:PropertyName("displayName")
    @set:PropertyName("displayName")
    var displayName: String = "",

    @get:PropertyName("email")
    @set:PropertyName("email")
    var email: String = "",

    @get:PropertyName("location")
    @set:PropertyName("location")
    var location: String = ""
) {
    // No-argument constructor
    constructor() : this("", "", "")
}

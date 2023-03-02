package com.mgomezm.gamecompose.domain.model

data class User(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = ""
)
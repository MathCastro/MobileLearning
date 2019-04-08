package com.example.exercicio.model

class UserBO {

    var id: Int? = 0
    var email: String? = null
    var password: String? = null

    constructor(id: Int, email: String, password: String) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    constructor(email: String, password: String) {
        this.email = email;
        this.password = password;
    }

}
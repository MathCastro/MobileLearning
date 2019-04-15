package com.example.exercicio.model

class TextBO {
    var id: Int? = 0
    var text: String? = null
    var id_user: Int? = null

    constructor(id: Int, text: String, id_user: Int) {
        this.id = id
        this.text = text
        this.id_user = id_user
    }

    constructor(text: String, id_user: Int) {
        this.text = text
        this.id_user = id_user
    }
}
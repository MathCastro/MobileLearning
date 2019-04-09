package com.example.exercicio.model

class CalendarBO {
    var id: Int? = 0
    var calendar: String? = null
    var id_user: Int? = null

    constructor(id: Int, calendar: String, id_user: Int) {
        this.id = id
        this.calendar = calendar
        this.id_user = id_user
    }

    constructor(id: Int, calendar: String) {
        this.id = id
        this.calendar = calendar
    }

    constructor(calendar: String, id_user: Int) {
        this.calendar = calendar
        this.id_user = id_user
    }
}
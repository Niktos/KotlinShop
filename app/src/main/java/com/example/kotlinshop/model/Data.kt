package com.example.kotlinshop.model

class Data {
    var title: String? = null
    var description: String? = null
    var img: String? = null
    var price: String? = null

    constructor() {}
    constructor(

        title: String?,
        description: String?,
        img: String?,
        price: String?
    ) {

        this.title = title
        this.description = description
        this.img = img
        this.price = price
    }


}
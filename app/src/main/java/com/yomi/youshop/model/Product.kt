package com.yomi.youshop.model

import java.math.BigDecimal

class Product(
    val code: Int,
    val name: String,
    val description: String,
    val price: BigDecimal,
    val previousPrice: BigDecimal?,
    val image: String){

    fun isOnSale(): Boolean {
        return previousPrice != null
    }

    fun displayPrice(): String{
        return formatToCurrency(price)
    }

    fun displayPreviousPrice(): String {
        previousPrice?.run{return formatToCurrency(this)}
        return ""
    }

    private fun formatToCurrency(price: BigDecimal): String{
        return "$${java.text.NumberFormat.getIntegerInstance().format(price)}"
    }
}
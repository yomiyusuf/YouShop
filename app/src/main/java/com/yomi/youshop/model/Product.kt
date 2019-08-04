package com.yomi.youshop.model

import com.yomi.youshop.util.Utils
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
        return "$${Utils.toCurrencyFormat(price)}"
    }

    fun displayPreviousPrice(): String {
        previousPrice?.run{return "$${Utils.toCurrencyFormat(this)}"}
        return ""
    }
}
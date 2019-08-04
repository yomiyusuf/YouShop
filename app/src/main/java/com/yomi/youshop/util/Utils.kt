package com.yomi.youshop.util

import java.math.BigDecimal

class Utils {
    companion object INSTANCE{
        fun toCurrencyFormat(price: BigDecimal): String{
            return "${java.text.NumberFormat.getIntegerInstance().format(price)}"
        }
    }
}
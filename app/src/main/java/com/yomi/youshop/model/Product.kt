package com.yomi.youshop.model

import java.math.BigDecimal

class Product(val code: Int, val name: String, val description: String, val price: BigDecimal, val previousPrice: BigDecimal?, val image: String) {
}
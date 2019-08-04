package com.yomi.youshop.model

import java.math.BigDecimal

class CartItem(
    val productCode: Int,
    val currentPrice: BigDecimal, //The price when the product was added to cart. Used to check if there is a future discount
    var quantity: Int = 1) {
}
package com.yomi.youshop.repo

import com.yomi.youshop.model.CartItem
import com.yomi.youshop.model.Product

class CartRepo {
    private val cart = mutableListOf<CartItem>()

    fun addToCart(product: Product){
        if (!isInCart(product)){
            cart.add(createCartItem(product))
        }else{
            incrementCount(product)
        }
    }

    fun isInCart(product: Product): Boolean{
        val item = cart.find { c -> c.productCode == product.code }
        return item != null
    }

    fun getCart(): MutableList<CartItem> {
        return cart
    }

    private fun createCartItem(product: Product): CartItem {
        return CartItem(productCode = product.code, currentPrice = product.price)
    }

    fun incrementCount(product: Product){
        (cart.find { c -> c.productCode == product.code })!!.quantity += 1
    }

    fun decrementCount(product: Product){
        (cart.find { c -> c.productCode == product.code })!!.quantity -= 1
    }

    fun removeFromCart(product: Product){
        val item = cart.find { c -> c.productCode == product.code }
        item?.run{
            cart.remove(item)
        }
    }
}
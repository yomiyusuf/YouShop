package com.yomi.youshop.viewModel

import androidx.lifecycle.ViewModel
import com.yomi.youshop.model.CartDetails
import com.yomi.youshop.model.CartItem
import com.yomi.youshop.model.Product
import com.yomi.youshop.repo.CartRepo
import com.yomi.youshop.repo.ProductsRepo
import java.math.BigDecimal

class ViewModelProducts : ViewModel() {

    private val repo: ProductsRepo
    private val cartRepo: CartRepo
    private var products: List<Product>? = null

    private var selectedProduct: Product? = null

    init {
        repo = ProductsRepo()
        cartRepo = CartRepo()
    }

    fun getProducts(): List<Product>? {
        if (products == null){
            products = repo.getProducts().sortedBy { it.name }
        }
        return products
    }

    fun setSelectedProduct(product: Product) {
        selectedProduct = product
    }

    fun setSelectedProduct(code: Int) {
        selectedProduct = getProducts()!!.find { it.code == code }
    }

    fun getSelectedProduct(): Product? {
        return selectedProduct
    }

    fun addToCart(product: Product) {
        cartRepo.addToCart(product)
    }

    fun removeFromCart(cartItem: CartItem) {
        cartRepo.removeFromCart(cartItem)
    }

    fun getCart(): MutableList<CartItem> {
        return cartRepo.getCart()
    }

    fun getCartTotal(): BigDecimal {
        val cartItems = getCart()
        val products = getProducts()

        var total = BigDecimal.ZERO
        cartItems.forEach {
            val p = products!!.find { p -> p.code == it.productCode}
            total += p!!.price.multiply(BigDecimal(it.quantity))
        }

        return total
    }

}
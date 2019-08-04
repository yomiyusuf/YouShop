package com.yomi.youshop.viewModel

import androidx.lifecycle.ViewModel
import com.yomi.youshop.model.CartItem
import com.yomi.youshop.model.Product
import com.yomi.youshop.repo.CartRepo
import com.yomi.youshop.repo.ProductsRepo

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
            products = repo.getProducts()
        }
        return products
    }

    fun setSelectedProduct(product: Product) {
        selectedProduct = product
    }

    fun getSelectedProduct(): Product? {
        return selectedProduct
    }

    fun addToCart(product: Product) {
        cartRepo.addToCart(product)
    }

    fun getCart(): MutableList<CartItem> {
        return cartRepo.getCart()
    }

}
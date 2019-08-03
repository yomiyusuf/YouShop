package com.yomi.youshop.ui

import androidx.lifecycle.ViewModel
import com.yomi.youshop.model.Product
import com.yomi.youshop.repo.ProductsRepo

class ViewModelProducts : ViewModel() {

    private val repo: ProductsRepo
    private var products: List<Product>? = null

    init {
        repo = ProductsRepo()
    }

    fun getProducts(): List<Product>? {
        if (products == null){
            products = repo.getProducts()
        }
        return products
    }
}
package com.yomi.youshop.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yomi.youshop.model.Product
import com.yomi.youshop.ui.view.ProductView


class ProductListAdapter(private val context: Context, val listener: PLPProductClickListner):
        RecyclerView.Adapter<ProductListAdapter.ViewHolder>(), ProductView.ProductClickHandler {

    private var products = mutableListOf<Product>()

    interface PLPProductClickListner{
        fun onProductClicked(product: Product, position: Int?)
        fun onQuickLookClicked(product: Product, position: Int?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ProductView(context)
        view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun setData(listProducts: List<Product>?){
        listProducts?.run{products = this.toMutableList()}
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productView.setView(products[position], this)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productView:ProductView

        init {
            productView = view as ProductView
        }
    }

    override fun onProductClick(product: Product) {
        val position = products?.indexOf(product)
        listener.onProductClicked(product, position)
    }
}
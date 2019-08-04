package com.yomi.youshop.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yomi.youshop.model.CartItem
import com.yomi.youshop.model.Product
import com.yomi.youshop.ui.view.CartItemView


class AdapterCart(private val context: Context, val listener: CartItemClickListner):
        RecyclerView.Adapter<AdapterCart.ViewHolder>(), CartItemView.CartItemClickHandler {

    private var cartItems = mutableListOf<CartItem>()
    private var products = listOf<Product>()

    interface CartItemClickListner{
        fun onItemClicked(productCode: Int)
        fun onDeleteClicked(item: CartItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CartItemView(context)
        view.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun setData(items: List<CartItem>, productList: List<Product>){
        cartItems = items.toMutableList()
        products = productList
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = cartItems[position]
        val product = products.find { p -> p.code == item.productCode }
        holder.cartItemView.setView(cartItems[position], product!!, this)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cartItemView: CartItemView

        init {
            cartItemView = view as CartItemView
        }
    }

    override fun onItemClick(cartItem: CartItem) {
        listener.onItemClicked(cartItem.productCode)
    }

    override fun onDeleteClicked(cartItem: CartItem){
        listener.onDeleteClicked(cartItem)
    }
}
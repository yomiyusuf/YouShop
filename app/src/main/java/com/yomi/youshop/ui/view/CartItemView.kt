package com.yomi.youshop.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import com.yomi.youshop.R
import com.yomi.youshop.model.CartItem
import com.yomi.youshop.model.Product
import kotlinx.android.synthetic.main.card_cart_item.view.*

class CartItemView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet)

    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.card_cart_item, this, true)
    }

    interface CartItemClickHandler {
        fun onItemClick(cartItem: CartItem)
        fun onDeleteClicked(cartItem: CartItem)
    }

    fun setView(cartItem: CartItem, product: Product, listener: CartItemClickHandler) {
        this.setOnClickListener { listener.onItemClick(cartItem) }
        button_remove_cart_item.setOnClickListener { listener.onDeleteClicked(cartItem)}
        txt_name_cart_item.text = product.name
        txt_qty_cart_item.text = cartItem.quantity.toString()
        txt_price_cart_item.text = product.displayPrice()

        if(product.price < cartItem.currentPrice){
            txt_reduced_label_cart_item.visibility = View.VISIBLE
            txt_old_price_cart_item.text = "${context.getString(R.string.was)} ${cartItem.currentPrice}"
        }

        Picasso.get()
            .load(product.image)
            .placeholder(R.drawable.image_placeholder)
            .into(image_cart_item)
    }
}

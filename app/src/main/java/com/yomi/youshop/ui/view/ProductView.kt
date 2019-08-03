package com.yomi.youshop.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.squareup.picasso.Picasso
import com.yomi.youshop.R
import com.yomi.youshop.model.Product
import kotlinx.android.synthetic.main.card_product.view.*

class ProductView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrSet: AttributeSet) : super(context, attrSet)

    constructor(context: Context, attrSet: AttributeSet, defStyleAttr: Int) : super(context, attrSet, defStyleAttr)

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.card_product, this, true)
    }

    interface ProductClickHandler {
        fun onProductClick(product: Product)
    }

    fun setView(product: Product, listener: ProductClickHandler?) {
        this.setOnClickListener { listener?.onProductClick(product) }
        txt_title_product.text = product.name
        txt_price_product.text = "$${java.text.NumberFormat.getIntegerInstance().format(product.price)}"
        if (product.isOnSale()) {
            txt_previous_price_product.text = "${context.getString(R.string.was)} $${java.text.NumberFormat.getIntegerInstance().format(product.previousPrice)}"
            txt_price_product.setTextColor(context.resources.getColor(R.color.red))
        } else {
            txt_price_product.setTextColor(context.resources.getColor(R.color.black))
        }

        Picasso.get()
            .load(product.image)
            .placeholder(R.drawable.image_placeholder)
            .into(image_product)
    }
}

package com.yomi.youshop.ui


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

import com.yomi.youshop.R
import com.yomi.youshop.model.Product
import com.yomi.youshop.viewModel.ViewModelProducts
import kotlinx.android.synthetic.main.fragment_detail.*

class FragmentDetail : Fragment() {

    private lateinit var viewmodel: ViewModelProducts

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProviders.of(activity!!).get(ViewModelProducts::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getSelectedProduct()?.run{
            displayProductDetails(this)
        }
    }

    private fun displayProductDetails(product: Product) {
        txt_title_product_detail.text = product.name
        txt_price_product_detail.text = product.displayPrice()
        if(product.isOnSale()){
            txt_price_product_detail.setTextColor(context!!.resources.getColor(R.color.red))
        }
        txt_previous_price_product_detail.text = product.displayPreviousPrice()
        txt_description_detail.text = product.description
        txt_description_detail.movementMethod = ScrollingMovementMethod()
        Picasso.get()
            .load(product!!.image)
            .placeholder(R.drawable.image_placeholder)
            .into(image_detail)

        btn_add_to_cart.setOnClickListener{
            viewmodel.addToCart(product)
            Toast.makeText(context!!, resources.getString(R.string.added_to_cart_msg), Toast.LENGTH_SHORT).show()
        }
    }
}

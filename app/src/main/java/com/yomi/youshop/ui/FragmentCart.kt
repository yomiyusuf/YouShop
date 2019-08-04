package com.yomi.youshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.yomi.youshop.R
import com.yomi.youshop.model.CartItem
import com.yomi.youshop.ui.adapter.AdapterCart
import com.yomi.youshop.ui.view.ProductGridItemDecoration
import com.yomi.youshop.util.Utils
import com.yomi.youshop.viewModel.ViewModelProducts
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_shop.*

class FragmentCart : Fragment(), AdapterCart.CartItemClickListner {

    private lateinit var viewmodel: ViewModelProducts
    private lateinit var adapter: AdapterCart

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProviders.of(activity!!).get(ViewModelProducts::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterCart(context!!, this)
        setupRecyclerView()
        setViews()
    }

    private fun setupRecyclerView(){
        rv_cart_items.layoutManager = LinearLayoutManager(context!!)
        rv_cart_items.adapter = adapter
        rv_cart_items.addItemDecoration(ProductGridItemDecoration(16, 16))
    }

    private fun setViews(){
        val cart = viewmodel.getCart()
        txt_number_items_cart.text = cart.map {it.quantity}.sum().toString()
        txt_total_cart.text = "$${Utils.toCurrencyFormat(viewmodel.getCartTotal())}"
        adapter.setData(cart, viewmodel.getProducts()!!)
    }

    override fun onItemClicked(productCode: Int) {
        viewmodel.setSelectedProduct(productCode)
        (activity as ActivityMain).loadDetailFragment()
    }

    override fun onDeleteClicked(item: CartItem) {
        viewmodel.removeFromCart(item)
        Toast.makeText(context!!, resources.getString(R.string.deleted_from_cart_msg), Toast.LENGTH_SHORT).show()
        setViews()
    }

}

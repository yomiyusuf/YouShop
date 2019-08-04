package com.yomi.youshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.yomi.youshop.R
import com.yomi.youshop.model.Product
import com.yomi.youshop.ui.view.ProductGridItemDecoration
import com.yomi.youshop.viewModel.ViewModelProducts
import kotlinx.android.synthetic.main.fragment_shop.*

class FragmentShop : Fragment(), AdapterProductList.PLPProductClickListner {

    private lateinit var viewmodel: ViewModelProducts
    private lateinit var adapter: AdapterProductList

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProviders.of(activity!!).get(ViewModelProducts::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AdapterProductList(context!!, this)
        setupRecyclerView()
        getData()
    }

    private fun setupRecyclerView(){
        val lm = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        rv_products.layoutManager = lm
        rv_products.adapter = adapter
        rv_products.addItemDecoration(ProductGridItemDecoration(16, 16))
    }

    private fun getData(){
        adapter.setData(viewmodel.getProducts())
    }

    override fun onProductClicked(product: Product) {
        viewmodel.setSelectedProduct(product)
        (activity as ActivityMain).loadDetailFragment()
    }
}

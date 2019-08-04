package com.yomi.youshop.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders

import com.yomi.youshop.R
import com.yomi.youshop.viewModel.ViewModelProducts
import kotlinx.android.synthetic.main.fragment_cart.*

class FragmentCart : Fragment() {

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
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cart_count.text = viewmodel.getCart().size.toString()
    }

}

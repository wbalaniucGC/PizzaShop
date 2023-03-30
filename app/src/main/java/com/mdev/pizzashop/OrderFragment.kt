package com.mdev.pizzashop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class OrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        // In a fragment. Need a reference to the main activity to set the Action Bar we want to use.
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        return view
    }
}
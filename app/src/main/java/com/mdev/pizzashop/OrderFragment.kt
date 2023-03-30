package com.mdev.pizzashop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class OrderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        // In a fragment. Need a reference to the main activity to set the Action Bar we want to use.
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        // Respond to Floating Action Bar
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val pizzaGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            val pizzaType = pizzaGroup.checkedRadioButtonId
            if(pizzaType == -1)
            {
                val text = "You need to choose a pizza type"
                Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
            } else {
                var text = (when (pizzaType) {
                    R.id.radio_diavolo -> "Diavolo Pizza"
                    else -> "Pepperoni Pizza"
                })
                // Check both chips to see if they are selected
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                text += if(parmesan.isChecked) ", extra parmesan" else ""

                val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                text += if(chiliOil.isChecked) ", extra chili oil" else ""

                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show()
            }
        }

        return view
    }
}
package com.example.dz.conductorpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler

class HomeController : Controller(), ConeController.ConeListener {
    override fun conesLeft(count: Int) {
        Toast.makeText(this.applicationContext, "cones " + count, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        var view = inflater.inflate(R.layout.controller_home, container, false)
        view.findViewById<TextView>(R.id.tv_hello).setText("hello " + this)
        view.setOnClickListener({ view ->
            router.pushController(RouterTransaction.with(ConeController(43, this))
                    .popChangeHandler(FadeChangeHandler())
                    .pushChangeHandler(FadeChangeHandler())
            )
        })
        return view
    }
}
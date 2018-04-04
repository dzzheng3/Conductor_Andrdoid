package com.example.dz.conductorpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import javax.annotation.Nullable

class ConeController : Controller {
    private var cones: Int? = null

    constructor(cones: Int, listener: HomeController) {
        this.cones = cones
        args.putInt("conesCount", cones)
        targetController = listener
    }

    constructor(@Nullable bundle: Bundle) : super(bundle) {
        cones = bundle.getInt("conesCount")
    }

    var tv_cone: TextView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        var view = inflater.inflate(R.layout.controller_cone, container, false)
        tv_cone = view.findViewById<TextView>(R.id.tv_cone)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        tv_cone?.setText("cones " + cones)
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        tv_cone = null
    }

    interface ConeListener {
        fun conesLeft(count: Int)
    }

    override fun handleBack(): Boolean {
        var coneListener: ConeListener = targetController as ConeListener
        coneListener.conesLeft(cones!!)
        return super.handleBack()
    }
}
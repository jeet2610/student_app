package com.example.student_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController


class register_page : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view : View = inflater.inflate(R.layout.fragment_register_page, container, false)

        var register_btn : Button = view.findViewById(R.id.verification)

        register_btn.setOnClickListener {

            it.findNavController().navigate(R.id.login_page)

        }

        return view
    }

}
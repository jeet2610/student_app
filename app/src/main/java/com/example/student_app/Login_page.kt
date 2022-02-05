package com.example.student_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

 lateinit var home_btn : Button


class Login_page : Fragment() {
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

        val view : View = inflater.inflate(R.layout.fragment_login_page, container, false)


        home_btn = view.findViewById(R.id.Next_to_verification)

        val regiserpage_btn : TextView = view.findViewById(R.id.register_page_btn)

        home_btn.setOnClickListener {

            it.findNavController().navigate(R.id.home_page)

        }

        regiserpage_btn.setOnClickListener {

            it.findNavController().navigate(R.id.register_page)

        }


        return view
    }

}
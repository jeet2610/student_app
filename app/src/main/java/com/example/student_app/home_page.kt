package com.example.student_app

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView

import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class home_page : Fragment() {
    lateinit var UsernameTextView : TextView
    lateinit var UserPhoneTextView : TextView
    lateinit var ChatImageView : ImageView
    lateinit var UserEmailTextView : TextView

    lateinit var name: String
    lateinit var email: String
    lateinit var phonenumber : String
    lateinit var Eventcard : CardView
    lateinit var ResultCard : CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_home_page, container, false)
        // Inflate the layout for this fragment
        UsernameTextView = view.findViewById(R.id.UsernameTextview)
        UserPhoneTextView = view.findViewById(R.id.UserPhoneNumberTextView)
        UserEmailTextView = view.findViewById(R.id.UserEmailTextView)
        ChatImageView = view.findViewById(R.id.ChatImageButton)
        ResultCard = view.findViewById(R.id.ResultCardView)
        ResultCard.setOnClickListener{
            view.findNavController().navigate(R.id.resultFragment)
        }




        val db = FirebaseFirestore.getInstance()
        val user = Firebase.auth.currentUser
        if (user != null)
        {
            // User is signed in
            val userid = user.uid
            val data = db.collection("Students").document(userid)
            data.get().addOnSuccessListener {
                 name = it["Name"].toString()
                 email = it["Email"].toString()
                 phonenumber = it["MobileNumber"].toString()

                UsernameTextView.setText(name)
                UserEmailTextView.setText(email)
                UserPhoneTextView.setText(phonenumber)


            }

        }
        else
        {
            // No user is signed in
        }



        Eventcard = view.findViewById(R.id.EventCard)
        Eventcard.setOnClickListener {
            view.findNavController().navigate(R.id.eventFragment)


        }

        ChatImageView.setOnClickListener{
            view.findNavController().navigate(R.id.chat_Fragment)
        }

        return view
    }

}
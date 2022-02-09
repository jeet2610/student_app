package com.example.student_app

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class Login_page : Fragment() {

    lateinit var EmailEditext : EditText
    lateinit var PasswordEditText : EditText
    lateinit var SubmitButton : Button
    lateinit var auth : FirebaseAuth


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

        EmailEditext = view.findViewById(R.id.EmailEditext)
        PasswordEditText = view.findViewById(R.id.PasswordEditext)
        SubmitButton = view.findViewById(R.id.SubmitButton)
        auth = FirebaseAuth.getInstance()
        SubmitButton.setOnClickListener {
            LoginUser()
        }






        return view
    }

    private fun LoginUser() {
        val email : String = EmailEditext.text.toString();
        val password : String = PasswordEditText.text.toString();

        if (email.isEmpty()) {
            EmailEditext.error = "Cannot Be Empty"
            EmailEditext.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            EmailEditext.error = "Enter Correct Email"
            EmailEditext.requestFocus()
        }
        if (password.isEmpty() || password.length < 6) {
            PasswordEditText.error = "Password cannot be neither Empty nor less than 6 characters!"
            PasswordEditText.requestFocus()
        }
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity(),
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        val LoginUser: FirebaseUser? = auth.getCurrentUser()
                        view?.findNavController()?.navigate(R.id.home_page)
                    } else {

                    }
                })
    }

    }


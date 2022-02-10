package com.example.student_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.samsao.messageui.views.MessagesWindow


class chat_Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_chat_, container, false)
        // Inflate the layout for this fragment


        if (! Python.isStarted()) {
            Python.start( AndroidPlatform(requireContext()));

        }

        var messageWidnow : MessagesWindow = view.findViewById(R.id.customized_messages_window)

        var message : EditText = messageWidnow.writingMessageView.findViewById(R.id.message_box_text_field)

        message.setHint("type here...")
        messageWidnow.setBackgroundResource(R.color.design_default_color_primary_dark)
        messageWidnow.setOnClickListener {

            messageWidnow.sendMessage(message.text.toString())


            val py : Python = Python.getInstance()
            val pyobj : PyObject = py.getModule("myscript")
            val obj : PyObject = pyobj.callAttr("main",message.text.toString())

            messageWidnow.receiveMessage(obj.toString())
            message.setText("")

        }

        return view
    }

}
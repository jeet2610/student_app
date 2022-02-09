package com.example.student_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class EventFragment : Fragment() {

    private lateinit var adapter: adminBookPackageAdpater
    lateinit var booked_recycleview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_event, container, false)

        booked_recycleview = view.findViewById<RecyclerView>(R.id.EventRecyclerview)
        setupRecyclerView()



        return view
    }

    private fun setupRecyclerView() {
        val query: Query = FirebaseFirestore.getInstance().collection("Events")//.orderBy("product_name", Query.Direction.ASCENDING);
        val options = FirestoreRecyclerOptions.Builder<EventModel>()
            .setQuery(query, EventModel::class.java)
            .build();

        adapter = adminBookPackageAdpater(options)
        booked_recycleview.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL,false)
        booked_recycleview.adapter = adapter;

    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }




}
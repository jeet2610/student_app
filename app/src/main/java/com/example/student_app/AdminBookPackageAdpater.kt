package com.example.student_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.student_app.EventModel
import com.example.student_app.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class adminBookPackageAdpater (options: FirestoreRecyclerOptions<EventModel>):
FirestoreRecyclerAdapter<EventModel,adminBookPackageAdpater.ViewHolder>(options)
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var EventName = itemView.findViewById<TextView>(R.id.EventNameTextView)
        var EventDate = itemView.findViewById<TextView>(R.id.EventDateTextView)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.eventitem, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: EventModel) {

        holder.EventName.text = model.Event_name
        holder.EventDate.text  = model.Event_date

    }

}

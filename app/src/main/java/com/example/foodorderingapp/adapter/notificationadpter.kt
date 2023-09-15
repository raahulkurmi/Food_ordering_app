package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.FragmentNotificationbottomfragmentBinding
import com.example.foodorderingapp.databinding.NotificationbottomsheetBinding

class notificationadpter(private var notifaction:ArrayList<String>,private var notifactionimage:ArrayList<Int>): RecyclerView.Adapter<notificationadpter.notificationviewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notificationviewholder {
        return notificationviewholder(NotificationbottomsheetBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }




    override fun onBindViewHolder(holder: notificationviewholder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int =notifaction.size
    inner class notificationviewholder (private  val binding:NotificationbottomsheetBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
//            val image=notifactionimage[position]
            binding.apply {
                val image=notifactionimage[position]
                notifactiontext.text=notifaction[position]
                notificationimage2.setImageResource(image)


            }



        }


    }
}
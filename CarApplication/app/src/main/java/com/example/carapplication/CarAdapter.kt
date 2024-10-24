package com.example.carapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.carapplication.databinding.CarItemBinding



class CarAdapter(private val carList:ArrayList<car>):RecyclerView.Adapter<CarAdapter.MyViewHolder>() {

    var onClick : ((car)->Unit) ?= null

    class MyViewHolder(val binding: CarItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = CarItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.apply {
            carName.text = carList[position].carName
            carPrice.text = "Price: $" + carList[position].carPrice.toString()
            carImg.setImageResource(carList[position].carImg)
        }

        holder.itemView.setOnClickListener {
            onClick?.invoke(carList[position])
        }

        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Delete Fruit Item")
                .setMessage("Are you sure you want to delete this item?")
                .setPositiveButton("Yes") { _, _ ->
                    carList.removeAt(position)
                    notifyItemRemoved(position)
                }
                .setNegativeButton("No", null)
                .show()
            true
        }


    }


}
package org.d3if3030.anggrek.listorchid

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3030.anggrek.R
import org.d3if3030.anggrek.databinding.ListItemBinding
import org.d3if3030.anggrek.model.Orchid
import org.d3if3030.anggrek.network.OrchidApi

class ListOrchidAdapter : RecyclerView.Adapter<ListOrchidAdapter.ViewHolder>() {
    private val data = mutableListOf<Orchid>()

    fun updateData(newData: List<Orchid>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(orchid: Orchid) = with(binding) {
            namaTextView.text = orchid.namaanggrek
            latinTextView.text = orchid.informasi
            Glide.with(imageView.context)
                .load(OrchidApi.getOrchidUrl(orchid.gambar))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)
            root.setOnClickListener {

                val message = root.context.getString(R.string.message, orchid.namaanggrek)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}
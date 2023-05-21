package org.d3if3030.anggrek.ui.histori

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if3030.anggrek.data.OrchidEntity
import org.d3if3030.anggrek.databinding.ListHistoriBinding
import org.d3if3030.anggrek.model.cariAnggrek
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter : ListAdapter<OrchidEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<OrchidEntity>() {
                override fun areItemsTheSame(
                    oldData: OrchidEntity, newData: OrchidEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: OrchidEntity, newData: OrchidEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ListHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: OrchidEntity) = with(binding) {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

            val hasilAnggrek = item.cariAnggrek()
            kategoriTextView.text = hasilAnggrek.namaAnggrek.substring(0, 1)
//            val circleBg = kategoriTextView.background as GradientDrawable
//            circleBg.setColor(color)
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            universeTextView.text = hasilAnggrek.namaAnggrek
        }
    }
}
package org.d3if3030.anggrek.model

import org.d3if3030.anggrek.R
import org.d3if3030.anggrek.data.OrchidEntity

fun OrchidEntity.cariAnggrek(): HasilAnggrek {
    val orchid = namaAnggrek
    val informasiAnggrek = if (orchid.equals("Anggrek Bulan", ignoreCase = true)) {
        R.string.info_anggrekbulan
    } else if (orchid.equals("Anggrek Hitam", ignoreCase = true)) {
        R.string.info_anggrekhitam
    } else if (orchid.equals("Anggrek Bulan Bintang", ignoreCase = true)) {
        R.string.info_anggrekbulanbintang
    } else if (orchid.equals("Anggrek Merpati", ignoreCase = true)) {
        R.string.info_anggrekmerpati
    } else if (orchid.equals("Anggrek Bulan Ungu", ignoreCase = true)) {
        R.string.info_anggrekphalaenopsis
    } else if (orchid.equals("Anggrek Sendok", ignoreCase = true)) {
        R.string.info_anggreksendok
    }
    else {
        R.string.tidak_diketahui
    }
    val imgAnggrek = if (orchid.equals("Anggrek Bulan", ignoreCase = true)) {
        R.drawable.bulan
    } else if (orchid.equals("Anggrek Hitam", ignoreCase = true)) {
        R.drawable.hitam
    } else if (orchid.equals("Anggrek Bulan Bintang", ignoreCase = true)) {
        R.drawable.bulanbintang
    } else if (orchid.equals("Anggrek Merpati", ignoreCase = true)) {
        R.drawable.merpati
    } else if (orchid.equals("Anggrek Bulan Ungu", ignoreCase = true)) {
        R.drawable.bulanungu
    } else if (orchid.equals("Anggrek Sendok", ignoreCase = true)) {
        R.drawable.sendok
    }else {
        R.drawable.hati
    }
    return HasilAnggrek(orchid, informasiAnggrek, imgAnggrek)
}
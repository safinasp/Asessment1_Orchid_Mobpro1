package org.d3if3030.anggrek.model

import org.d3if3030.anggrek.R
import org.d3if3030.anggrek.data.OrchidEntity

fun OrchidEntity.cariAnggrek(): HasilAnggrek {
    val orchid = namaAnggrek
    val informasiAnggrek = if (orchid.equals("Anggrek Bulan", ignoreCase = true)) {
        R.string.info_anggrekbulan
    } else if (orchid.equals("Anggrek Hitam", ignoreCase = true)) {
        R.string.info_anggrekhitam
    } else {
        R.string.tidak_diketahui
    }
    val imgAnggrek = if (orchid.equals("Anggrek Bulan", ignoreCase = true)) {
        R.drawable.anggrekbulan
    } else if (orchid.equals("Anggrek Hitam", ignoreCase = true)) {
        R.drawable.anggrekhitam
    }return HasilAnggrek(orchid, informasiAnggrek, imgAnggrek)
}
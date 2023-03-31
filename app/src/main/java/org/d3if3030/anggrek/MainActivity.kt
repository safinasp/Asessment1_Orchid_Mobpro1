package org.d3if3030.anggrek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import org.d3if3030.anggrek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCari.setOnClickListener { cariAnggrek() }
        binding.btnHapus.setOnClickListener{hapusAnggrek() }
    }

    private fun cariAnggrek() {
        // inisialiasi variabel dengan memamggil inputan dari inpAnggrek
        val anggrek = binding.inpAnggrek.text.toString()

        // melakuakan pengecekan inputan kalau kosong (sanity check)
        if (TextUtils.isEmpty(anggrek)) {
            Toast.makeText(this, R.string.input_kosong, Toast.LENGTH_LONG).show()
        }

        // melakukan pengecekan kalau inputan tidak berupa angka (sanity check)
        if (TextUtils.isDigitsOnly(anggrek)) {
            Toast.makeText(this, R.string.input_angka, Toast.LENGTH_LONG).show()
        }

        // pengecekan ketika mencari Anggrek
        if (anggrek.equals("Anggrek Bulan", ignoreCase = true)) { //Anggrek Bulan

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_bulan)
            binding.informasiAnggrek.text = "a. Berwarna putih dengan corak kuning atau merah\n" +
                    "b. Memiliki ciri kelopak bunga yang lebar dan berwarna putih\n" +
                    "c. Anggrek bulan senang dengan sedikit cahaya matahari\n" +
                    "d. Anggrek bulan termasuk dalam tanaman anggrek monopodial "
            binding.imgAnggrek.setImageResource(R.drawable.anggrekbulan)

        } else if (anggrek.equals("Anggrek Merpati", ignoreCase = true)) { // Anggrek Merpati

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_merpati)
            binding.informasiAnggrek.text = "a. Memiliki warna putih dengan sedikit kekuningan\n" +
                    "b. Bunganya biasanya hanya bertahan sehari\n" +
                    "c. Kelopak bunga berbentuk segitiga sempit dan lancip\n" +
            binding.imgAnggrek.setImageResource(R.drawable.anggrekmerpati)

        } else if (anggrek.equals("Anggrek Phalaenopsis", ignoreCase = true)) { // Anggrek

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_phalaenopsis)
            binding.informasiAnggrek.text = "a.  Berwarna putih dengan corak kuning atau merah\n" +
                    "b. Memiliki ciri kelopak bunga yang lebar dan berwarna putih\n" +
                    "c. Anggrek bulan senang dengan sedikit cahaya matahari\n" +
                    "d. Anggrek bulan termasuk dalam tanaman anggrek monopodial "
            binding.imgAnggrek.setImageResource(R.drawable.anggrekphalaenopsis)

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

           } else {
            Toast.makeText(this, R.string.tidak_diketahui, Toast.LENGTH_LONG).show()
        }
    }
    private fun hapusAnggrek(){
        binding.inpAnggrek.text!!.clear()
        binding.namaAnggrek.setText(" ")
        binding.imgAnggrek.isVisible = false
        binding.informasiAnggrek.setText(" ")
    }



    // membuat dialog exit
    override fun onBackPressed() {
        // inisialisasi alert dialog
        val builder = AlertDialog.Builder(this)

        // mengeset judul dialog
        builder.setTitle(R.string.app_name)

        // mengeset pesan dialog
        builder.setMessage(R.string.exit_dialog)

        // jika ya
        builder.setPositiveButton("Ya") { _, _ ->
            this.finish()
        }

        // jika tidak
        builder.setNegativeButton("Tidak") { _, _ -> }

        // dialog tidak bisa kembali / cancel
        builder.setCancelable(false)

        // menampilkan dialog
        builder.show()
    }
}
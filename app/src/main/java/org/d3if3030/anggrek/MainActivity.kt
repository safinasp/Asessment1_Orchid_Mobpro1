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
        //Anggrek Bulan
        if (anggrek.equals("Anggrek Bulan", ignoreCase = true)) {

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

            // Anggrek Merpati
        } else if (anggrek.equals("Anggrek Merpati", ignoreCase = true)) {

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

            // Anggrek phlaenopsis
        } else if (anggrek.equals("Anggrek Phalaenopsis", ignoreCase = true)) {

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_phalaenopsis)
            binding.informasiAnggrek.text = "a.  Memiliki bentuk bunga bulat\n" +
                    "b. Warna bunga anggrek memiliki kombinasi warna bunga diantaranya adalah putih, cokelat, dan merah\n" +
                    "c. Pada bagian ujung bunga berbentuk tumpul\n"
            binding.imgAnggrek.setImageResource(R.drawable.anggrekphalaenopsis)

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

        //anggrek bulan bintang
        } else if (anggrek.equals("Anggrek Bulan Bintang", ignoreCase = true)) {

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_bulanbintang)
            binding.informasiAnggrek.text = "a. Anggrek ini punya lima buah kelopak yang berbentuk menyerupai bintang dan pada bagian tengahnya seperti bulan\n" +
                    "b. Pada bagian daunnya berbentuk bulat telur seperti anggrek bulan\n" +
                    "c. mempunyai warna kuning dan juga coklat\n" +
                    "d. Anggrek bulan bintang ini berasal dari Kalimantan yang mana biasa tumbuh di pinggir sungaI"
            binding.imgAnggrek.setImageResource(R.drawable.anggrekbulanbintang)

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            //Anggrek Sendok
        } else if (anggrek.equals("Anggrek Sendok", ignoreCase = true)) {

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_sendok)
            binding.informasiAnggrek.text = "a. Anggrek ini memiliki bentuk yang menyerupai sendok makan\n" +
                    "b. Bunga sendok ini didominasi oleh warna kuning muda pada bagian kelopak dengan beberapa sentuhan warna putih\n" +
                    "c. mempunyai warna kuning dan juga coklat\n"
            binding.imgAnggrek.setImageResource(R.drawable.anggreksendok)

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            //Anggrek Hitam
        } else if (anggrek.equals("Anggrek Hitam", ignoreCase = true)) {

            // membuat layout dapat dilihat (sebelumnya diset tidak terlihat dilayout)
            binding.namaAnggrek.isVisible = true
            binding.informasiAnggrek.isVisible = true
            binding.imgAnggrek.isVisible = true

            // mengeset data
            binding.namaAnggrek.text = getString(R.string.anggrek_hitam)
            binding.informasiAnggrek.text = "a. Bunga anggrek hitam berbentuk tangkai dengan jumlah kuntum bunga antara 5-10 kuntum per tangkai\n" +
                    "b. Warna bun- ganya didominasi oleh warna hijau kekuningan pada bagian kelopak dan mahkotanya dan bagian bibir bunga berwarna hitam yang bagian dalamnya terdapat bintik-bintik warna hitam dengan kombinasi garis- garis hitam.\n" +
                    "c. Anggrek hitam dijadikan sebagai maskot flora di propinsi Kalimantan Timur karena keindahan dan keunikannya\n"
            binding.imgAnggrek.setImageResource(R.drawable.anggrekhitam)

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
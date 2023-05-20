package org.d3if3030.anggrek.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.d3if3030.anggrek.R
import org.d3if3030.anggrek.data.OrchidDb
import org.d3if3030.anggrek.databinding.FragmentMainBinding
import org.d3if3030.anggrek.model.HasilAnggrek

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        val db = OrchidDb.getInstance(requireContext())
        val factory = MainViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnCari.setOnClickListener{ cariAnggrek() }
        viewModel.getHasilOrchid().observe(requireActivity()) { showResult(it) }
        binding.btnHapus.setOnClickListener{hapusAnggrek() }
        viewModel.getHasilOrchid().observe(requireActivity()) { showResult(it) }
    }


    private fun hapusAnggrek(){
        binding.inpAnggrek.text!!.clear()
        binding.namaAnggrek.setText(" ")
        binding.imgAnggrek.isVisible = false
        binding.informasiAnggrek.setText(" ")
    }
    }

    private fun isInputEmpty(input: String): Boolean {
        return input.isNullOrBlank()
    }
    private fun isInputNumber(input: String): Boolean {
        return input.toIntOrNull() != null
    }

    fun isInputValid(input: String): Boolean {
        val regex = Regex("^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$")
        return regex.matches(input)
    }


    private fun cariAnggrek() {
        // inisialiasi variabel dengan memamggil inputan dari inpAnggrek

        val anggrek = binding.inpAnggrek.text.toString()

        // melakuakan pengecekan inputan kalau angka (sanity check)
        if (isInputNumber(anggrek)) {
            Toast.makeText(context, R.string.input_angka, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau kosong (sanity check)
        } else if (isInputEmpty(anggrek)) {
            Toast.makeText(context, R.string.input_kosong, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau angka kombinasi dengan teks (sanity check)
        } else if (isInputValid(anggrek)) {
            Toast.makeText(context, R.string.input_combine, Toast.LENGTH_SHORT).show()
            return
            // melakuakan pengecekan inputan kalau karakter (sanity check)
        }  else if (anggrek.contains("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]".toRegex())) {
            Toast.makeText(context, R.string.input_karakter, Toast.LENGTH_LONG).show()
        } else {
            viewModel.cariUniverse(planet)
        }
    }

    private fun showResult(result: HasilAnggrek?) {
        if (result == null) return
        binding.namaAnggrek.isVisible = true
        binding.informasiAnggrek.isVisible = true
        binding.imgAnggrek.isVisible = true

        binding.namaAnggrek.text = result.namaAnggrek
        binding.informasiAnggrek.text = getString(result.informasiAnggrek)
        binding.imgPlanet.setImageResource(result.imgAnggrek)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.my_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_histori -> {
                findNavController().navigate(R.id.action_mainFragment_to_historiFragment)
                return true
            }
            R.id.menu_about -> {
                findNavController().navigate(R.id.action_mainFragment_to_fragmentAbout)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
package org.d3if3030.anggrek.listorchid

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import org.d3if3030.anggrek.MainActivity
import org.d3if3030.anggrek.R
import org.d3if3030.anggrek.data.SettingDataStore
import org.d3if3030.anggrek.data.dataStore
import org.d3if3030.anggrek.databinding.FragmentListOrchidBinding
import org.d3if3030.anggrek.network.ApiStatus

class ListOrchidFragment : Fragment() {

    private val layoutDataStore : SettingDataStore by lazy {
        SettingDataStore(requireContext().dataStore)
    }

    private val viewModel: ListOrchidViewModel by  lazy {
        ViewModelProvider(this)[ListOrchidViewModel::class.java]
    }

    private lateinit var myAdapter: ListOrchidAdapter
    private lateinit var binding: FragmentListOrchidBinding
    private var isLineraLayout = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOrchidBinding.inflate(layoutInflater, container,false)
        myAdapter = ListOrchidAdapter()
        with(binding.recyclerView){
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutDataStore.preferenceFlow.asLiveData().observe(viewLifecycleOwner) {
            isLineraLayout = it
            setLayout()
            activity?.invalidateOptionsMenu()
        }

        viewModel.getData().observe(viewLifecycleOwner){
            myAdapter.updateData(it)
        }

        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }

        viewModel.scheduleUpdater(requireActivity().application)
    }

    private fun updateProgress(status: ApiStatus){
        when(status) {
            ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    requestNotificationPermission()
                }
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    private fun setLayout(){
        binding.recyclerView.layoutManager = if (isLineraLayout)
            LinearLayoutManager(context)
        else
            GridLayoutManager(context, 2)
    }

    private fun setIcon(menuItem: MenuItem) {
        val iconId = if (isLineraLayout)
            R.drawable.baseline_grid_on_24
        else
            R.drawable.baseline_list_24
        menuItem.icon = ContextCompat.getDrawable(requireContext(), iconId)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_orchid, menu)
        val menuItem = menu.findItem(R.id.action_switch_layout)
        setIcon(menuItem)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_switch_layout) {
            lifecycleScope.launch {
                layoutDataStore.saveLayout(!isLineraLayout, requireContext())
            }
            return true
        }
        return super.onContextItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun requestNotificationPermission() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                MainActivity.PERMISSION_REQUEST_CODE
            )
        }
    }
}
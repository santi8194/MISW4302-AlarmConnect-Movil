package com.example.alarmconnect.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarmconnect.AlarmsListItem
import com.example.alarmconnect.AlarmsListAdapter
import com.example.alarmconnect.R
import com.example.alarmconnect.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("CirculoFragment", "✅ onCreateView() de HOME FRAGMENT SE ESTÁ EJECUTANDO")
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Sample data
        val items = listOf(
            AlarmsListItem("Hoy", "", "section"),
            AlarmsListItem("Sacar perro", "Diario 9:00 pm", "item"),
            AlarmsListItem("Próximos", "", "section"),
            AlarmsListItem("Entregar tarea", "Mar 9 3:00 pm", "item"),
            AlarmsListItem("Limpiar casa", "L, M, J 3:00 pm", "item"),
                    AlarmsListItem("Tomar medicamentos", "Mar 9 3:00 pm", "item")
        )

        // Set up RecyclerView
        val recyclerView = binding.homeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AlarmsListAdapter(items)


        // navigate to create new alarm
        binding.crearNuevaAlarmaButton.setOnClickListener {
            // Navigate to CreateNewAlarmFragment
            findNavController().navigate(R.id.action_navigation_alarms_to_tipoAlarmaFragment)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
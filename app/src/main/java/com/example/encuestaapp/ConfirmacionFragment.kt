package com.example.encuestaapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.encuestaapp.databinding.FragmentConfirmacionBinding

class ConfirmacionFragment : Fragment() {

    private var _binding: FragmentConfirmacionBinding? = null
    private val binding get() = _binding!!
    private val encuestaViewModel : EncuestaViewModel by activityViewModels()
    private lateinit var alimentoEncuestaAdapter: AlimentoEncuestaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_confirmacion, container, false)

        initUI()

        val root = binding.root

        binding.encuesta = encuestaViewModel
        // Specify the fragment as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = this
        binding.btnAlgo.setOnClickListener{
            encuestaViewModel.insert((activity?.application as EncuestaApplication).repository,(activity?.application as EncuestaApplication).encuestaRepository)
            Toast.makeText(
                this.context,
                "Encuesta cargada con exito",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_confirmacionFragment2_to_homeFragment)
        }
        return root
    }

    private fun initUI() {
        alimentoEncuestaAdapter = AlimentoEncuestaAdapter(encuestaViewModel.getAlimentos())
        binding.rvAlimentoEncuesta.layoutManager = LinearLayoutManager(this.context)
        binding.rvAlimentoEncuesta.adapter = alimentoEncuestaAdapter
    }
}
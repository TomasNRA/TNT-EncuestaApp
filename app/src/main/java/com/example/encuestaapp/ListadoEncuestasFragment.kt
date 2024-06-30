package com.example.encuestaapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.encuestaapp.databinding.FragmentListadoEncuestasBinding
import com.example.encuestaapp.db.entitis.Encuesta
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class ListadoEncuestasFragment : Fragment() {
    private var _binding: FragmentListadoEncuestasBinding? = null
    private val binding get() = _binding!!
    private lateinit var adaptador: EncuestaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListadoEncuestasBinding.inflate(layoutInflater, container, false)
        initListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adaptador = EncuestaAdapter()
        binding.rvEncuestas.layoutManager = LinearLayoutManager(this.context)
        binding.rvEncuestas.adapter = adaptador
        lifecycleScope.launch {
            (requireActivity().application as EncuestaApplication).encuestaRepository.allEncuestas.collect{ nuevaLista ->
                adaptador.actualizarDatos(nuevaLista)
        }
    }
    }


    private fun initListeners() {
        val algo = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.btnNuevaEncuesta.setOnClickListener {
            algo.navController.navigate(R.id.action_homeFragment_to_encuestaLecheEnPolvoFragment)
//            findNavController().navigate(R.id.action_homeFragment_to_encuestaLecheEnPolvoFragment)
        }
    }

}
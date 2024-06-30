package com.example.encuestaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.encuestaapp.databinding.FragmentEncuestaMantecaBinding
import com.example.encuestaapp.db.entitis.AlimentoEncuesta
import java.text.DecimalFormat


class EncuestaMantecaFragment : Fragment() {
    private var _binding: FragmentEncuestaMantecaBinding? = null
    private val binding get() = _binding!!

    private val encuestaViewModel : EncuestaViewModel by activityViewModels()

    private var alimento:String = "Manteca"
    private lateinit var porcion:String
    private lateinit var frecuencia:String
    private var cantidad:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEncuestaMantecaBinding.inflate(layoutInflater, container, false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.rgPorcion.setOnCheckedChangeListener { _, checkedButtonId ->
            porcion = when (checkedButtonId) {
                binding.rbPorcionOpcion1.id -> "${binding.rbPorcionOpcion1.text}"
                binding.rbPorcionOpcion2.id -> "${binding.rbPorcionOpcion2.text}"
                binding.rbPorcionOpcion3.id -> "${binding.rbPorcionOpcion3.text}"
                binding.rbPorcionOpcion4.id -> "${binding.rbPorcionOpcion4.text}"
                else -> "no consume"
            }
            Toast.makeText(
                this.context,
                "Porcion $porcion is selected",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rgFrecuencia.setOnCheckedChangeListener { _, checkedButtonId ->
            frecuencia = when (checkedButtonId) {
                binding.rbFrecuenciaOpcion1.id -> "${binding.rbFrecuenciaOpcion1.text}"
                binding.rbFrecuenciaOpcion2.id -> "${binding.rbFrecuenciaOpcion2.text}"
                binding.rbFrecuenciaOpcion3.id -> "${binding.rbFrecuenciaOpcion3.text}"
                binding.rbFrecuenciaOpcion4.id -> "${binding.rbFrecuenciaOpcion4.text}"
                else -> "no consume"
            }
            Toast.makeText(
                this.context,
                "Frecuencia $frecuencia is selected",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.rsCantidad.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            var currenValue = df.format(value).toInt()
            binding.tvCantidad.text = "$currenValue"
            cantidad = currenValue

        }
        binding.btnContinuar.setOnClickListener {
            if(::porcion.isInitialized && ::frecuencia.isInitialized && cantidad != 0){
                val alimento: AlimentoEncuesta = AlimentoEncuesta(alimento = alimento, porcion = porcion, cantidad = cantidad, frecuencia = frecuencia)
                encuestaViewModel.setManteca(alimento)
                //encuestaViewModel.insert()
                findNavController().navigate(R.id.action_encuestaMantecaFragment_to_encuestaHuevoDeGallinaCrudoHervidoPocheFragment)
            }else {
                Toast.makeText(
                    this.context,
                    "Complete todos los campos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.btnCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_encuestaMantecaFragment_to_homeFragment)
        }
    }

}
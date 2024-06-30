package com.example.encuestaapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.encuestaapp.db.AlimentoEncuestaRepository
import com.example.encuestaapp.db.EncuestaRepository
import com.example.encuestaapp.db.entitis.AlimentoEncuesta
import com.example.encuestaapp.db.entitis.Encuesta
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class EncuestaViewModel() : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    //val allSurveys: LiveData<List<AlimentoEncuesta>> = repository.allAlimentos.asLiveData()

    private val _lecheEnPolvo = MutableLiveData<AlimentoEncuesta>()
    val lecheEnPolvo : LiveData<AlimentoEncuesta>
        get() = _lecheEnPolvo

    fun setLecheEnPolvo(comida:AlimentoEncuesta){
        _lecheEnPolvo.value = comida
        Log.d("view","${lecheEnPolvo.value!!.id}")
    }

    private val _lecheFluida = MutableLiveData<AlimentoEncuesta>()
    val lecheFluida : LiveData<AlimentoEncuesta>
        get() = _lecheFluida

    fun setLecheFluida(comida:AlimentoEncuesta){
        _lecheFluida.value = comida
    }

    private val _quesoPastaDura = MutableLiveData<AlimentoEncuesta>()
    val quesoPastaDura : LiveData<AlimentoEncuesta>
        get() = _quesoPastaDura

    fun setQuesoPastaDura(comida:AlimentoEncuesta){
        _quesoPastaDura.value = comida
    }

    private val _quesoPastaSemidura = MutableLiveData<AlimentoEncuesta>()
    val quesoPastaSemidura : LiveData<AlimentoEncuesta>
        get() = _quesoPastaSemidura

    fun setQuesoPastaSemidura(comida:AlimentoEncuesta){
        _quesoPastaSemidura.value = comida
    }

    private val _manteca = MutableLiveData<AlimentoEncuesta>()
    val manteca : LiveData<AlimentoEncuesta>
        get() = _manteca

    fun setManteca(comida:AlimentoEncuesta){
        _manteca.value = comida
    }

    private val _huevoDeGallinaCrudoHervidoPoche = MutableLiveData<AlimentoEncuesta>()
    val huevoDeGallinaCrudoHervidoPoche : LiveData<AlimentoEncuesta>
        get() = _huevoDeGallinaCrudoHervidoPoche

    fun setHuevoDeGallinaCrudoHervidoPoche(comida:AlimentoEncuesta){
        _huevoDeGallinaCrudoHervidoPoche.value = comida
    }

    private val _huevoDeGallinaFrito = MutableLiveData<AlimentoEncuesta>()
    val huevoDeGallinaFrito : LiveData<AlimentoEncuesta>
        get() = _huevoDeGallinaFrito

    fun setHuevoDeGallinaFrito(comida:AlimentoEncuesta){
        _huevoDeGallinaFrito.value = comida
    }

    private val _carneVacunaMagra = MutableLiveData<AlimentoEncuesta>()
    val carneVacunaMagra : LiveData<AlimentoEncuesta>
        get() = _carneVacunaMagra

    fun setCarneVacunaMagra(comida:AlimentoEncuesta){
        _carneVacunaMagra.value = comida
    }

    private val _carneVacunaCortesGrasos = MutableLiveData<AlimentoEncuesta>()
    val carneVacunaCortesGrasos : LiveData<AlimentoEncuesta>
        get() = _carneVacunaCortesGrasos

    fun setCarneVacunaCortesGrasos(comida:AlimentoEncuesta){
        _carneVacunaCortesGrasos.value = comida
    }

    private val _carnePicada = MutableLiveData<AlimentoEncuesta>()
    val carnePicada : LiveData<AlimentoEncuesta>
        get() = _carnePicada

    fun setCarnePicada(comida:AlimentoEncuesta){
        _carnePicada.value = comida
    }

    private val _salchicha = MutableLiveData<AlimentoEncuesta>()
    val salchicha : LiveData<AlimentoEncuesta>
        get() = _salchicha

    fun setSalchicha(comida:AlimentoEncuesta){
        _salchicha.value = comida
    }

    private val _salameSalaminChorizosecoLonganiza = MutableLiveData<AlimentoEncuesta>()
    val salameSalaminChorizosecoLonganiza : LiveData<AlimentoEncuesta>
        get() = _salameSalaminChorizosecoLonganiza

    fun setSalameSalaminChorizosecoLonganiza(comida:AlimentoEncuesta){
        _salameSalaminChorizosecoLonganiza.value = comida
    }

    private val _mortadela = MutableLiveData<AlimentoEncuesta>()
    val mortadela : LiveData<AlimentoEncuesta>
        get() = _mortadela

    fun setMortadela(comida:AlimentoEncuesta){
        _mortadela.value = comida
    }

    private val _papaFrita = MutableLiveData<AlimentoEncuesta>()
    val papaFrita : LiveData<AlimentoEncuesta>
        get() = _papaFrita

    fun setPapafrita(comida:AlimentoEncuesta){
        _papaFrita.value = comida
    }

    private val _pizza = MutableLiveData<AlimentoEncuesta>()
    val pizza : LiveData<AlimentoEncuesta>
        get() = _pizza

    fun setPizza(comida:AlimentoEncuesta){
        _pizza.value = comida
    }

    private val _empanadaDeCarneFrita = MutableLiveData<AlimentoEncuesta>()
    val empanadaDeCarneFrita : LiveData<AlimentoEncuesta>
        get() = _empanadaDeCarneFrita

    fun setEmpanadaDeCarneFrita(comida:AlimentoEncuesta){
        _empanadaDeCarneFrita.value = comida
    }

    private val _empanadaDeCarne = MutableLiveData<AlimentoEncuesta>()
    val empanadaDeCarne : LiveData<AlimentoEncuesta>
        get() = _empanadaDeCarne

    fun setEmpanadaDeCarne(comida:AlimentoEncuesta){
        _empanadaDeCarne.value = comida
    }

    private val _pastelDePapa = MutableLiveData<AlimentoEncuesta>()
    val pastelDePapa : LiveData<AlimentoEncuesta>
        get() = _pastelDePapa

    fun setPastelDePapa(comida:AlimentoEncuesta){
        _pastelDePapa.value = comida
    }

    private val _puchero = MutableLiveData<AlimentoEncuesta>()
    val puchero : LiveData<AlimentoEncuesta>
        get() = _puchero

    fun setPuchero(comida:AlimentoEncuesta){
        _puchero.value = comida
    }

    private val _banana = MutableLiveData<AlimentoEncuesta>()
    val banana : LiveData<AlimentoEncuesta>
        get() = _banana

    fun setBanana(comida:AlimentoEncuesta){
        _banana.value = comida
    }

    private val _durazno = MutableLiveData<AlimentoEncuesta>()
    val durazno : LiveData<AlimentoEncuesta>
        get() = _durazno

    fun setDurazno(comida:AlimentoEncuesta){
        _durazno.value = comida
    }

    private val _manzana = MutableLiveData<AlimentoEncuesta>()
    val manzana : LiveData<AlimentoEncuesta>
        get() = _manzana

    fun setManzana(comida:AlimentoEncuesta){
        _manzana.value = comida
    }

    private val _aguaSaborizada = MutableLiveData<AlimentoEncuesta>()
    val aguaSaborizada : LiveData<AlimentoEncuesta>
        get() = _aguaSaborizada

    fun setAguaSaborizada(comida:AlimentoEncuesta){
        _aguaSaborizada.value = comida
    }

    private val _bebidaDeportivaOEnergizante = MutableLiveData<AlimentoEncuesta>()
    val bebidaDeportivaOEnergizante : LiveData<AlimentoEncuesta>
        get() = _bebidaDeportivaOEnergizante

    fun setBebidaDeportivaOEnergizante(comida:AlimentoEncuesta){
        _bebidaDeportivaOEnergizante.value = comida
    }

    private val _gaseosaClasica = MutableLiveData<AlimentoEncuesta>()
    val gaseosaClasica : LiveData<AlimentoEncuesta>
        get() = _gaseosaClasica

    fun setGaseosaClasica(comida:AlimentoEncuesta){
        _gaseosaClasica.value = comida
    }

    private val _vino = MutableLiveData<AlimentoEncuesta>()
    val vino : LiveData<AlimentoEncuesta>
        get() = _vino

    fun setVino(comida:AlimentoEncuesta){
        _vino.value = comida
    }

    private val _cervezaOAperitivo = MutableLiveData<AlimentoEncuesta>()
    val cervezaOAperitivo : LiveData<AlimentoEncuesta>
        get() = _cervezaOAperitivo

    fun setCervezaOAperitivo(comida:AlimentoEncuesta){
        _cervezaOAperitivo.value = comida
    }

    private val _licor = MutableLiveData<AlimentoEncuesta>()
    val licor : LiveData<AlimentoEncuesta>
        get() = _licor

    fun setLicor(comida:AlimentoEncuesta){
        _licor.value = comida
    }

    private val _bebidaBlanca = MutableLiveData<AlimentoEncuesta>()
    val bebidaBlanca : LiveData<AlimentoEncuesta>
        get() = _bebidaBlanca

    fun setBebidaBlanca(comida:AlimentoEncuesta){
        _bebidaBlanca.value = comida
    }

    fun getAlimentos():List<AlimentoEncuesta?>{
        return listOf(lecheEnPolvo.value,lecheFluida.value,quesoPastaDura.value,quesoPastaSemidura.value,manteca.value,huevoDeGallinaCrudoHervidoPoche.value,
            huevoDeGallinaFrito.value,carneVacunaMagra.value,carneVacunaCortesGrasos.value, carnePicada.value,salchicha.value, salameSalaminChorizosecoLonganiza.value,
            mortadela.value,papaFrita.value,pizza.value,empanadaDeCarneFrita.value,empanadaDeCarne.value,pastelDePapa.value,puchero.value,banana.value,durazno.value,manzana.value,
            aguaSaborizada.value,bebidaDeportivaOEnergizante.value,gaseosaClasica.value,vino.value,cervezaOAperitivo.value,licor.value,bebidaBlanca.value)
    }

    fun insert(repository: AlimentoEncuestaRepository,encuestaRepository: EncuestaRepository) = viewModelScope.launch {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val formattedDate = currentDate.format(formatter)
        val idEncuesta = encuestaRepository.insert(Encuesta(fecha = formattedDate))
        val alimentos = listOf(lecheEnPolvo,lecheFluida,quesoPastaDura,quesoPastaSemidura,manteca,huevoDeGallinaCrudoHervidoPoche,
            huevoDeGallinaFrito,carneVacunaMagra,carneVacunaCortesGrasos, carnePicada,salchicha, salameSalaminChorizosecoLonganiza,
            mortadela,papaFrita,pizza,empanadaDeCarneFrita,empanadaDeCarne,pastelDePapa,puchero,banana,durazno,manzana,
            aguaSaborizada,bebidaDeportivaOEnergizante,gaseosaClasica,vino,cervezaOAperitivo,licor,bebidaBlanca)
        alimentos.forEach {
            it.value!!.idEncuesta = idEncuesta.toInt()
            repository.insert(it.value!!)
        }
        Log.d("jojo", "$idEncuesta")
//        repository.apply {
//            insert(lecheEnPolvo.value!!)
//            insert(lecheFluida.value!!)
//            insert(quesoPastaDura.value!!)
//            insert(quesoPastaSemidura.value!!)
//            insert(manteca.value!!)
//            insert(huevoDeGallinaCrudoHervidoPoche.value!!)
//            insert(huevoDeGallinaFrito.value!!)
//            insert(carneVacunaMagra.value!!)
//            insert(carneVacunaCortesGrasos.value!!)
//            insert(carnePicada.value!!)
//            insert(salchicha.value!!)
//            insert(salameSalaminChorizosecoLonganiza.value!!)
//            insert(mortadela.value!!)
//            insert(papaFrita.value!!)
//            insert(pizza.value!!)
//            insert(empanadaDeCarneFrita.value!!)
//            insert(empanadaDeCarne.value!!)
//            insert(pastelDePapa.value!!)
//            insert(puchero.value!!)
//            insert(banana.value!!)
//            insert(durazno.value!!)
//            insert(manzana.value!!)
//            insert(aguaSaborizada.value!!)
//            insert(bebidaDeportivaOEnergizante.value!!)
//            insert(gaseosaClasica.value!!)
//            insert(vino.value!!)
//            insert(cervezaOAperitivo.value!!)
//            insert(licor.value!!)
//            insert(bebidaBlanca.value!!)
//        }
    }
}
//class EncuestaViewModelFactory(private val repository: AlimentoEncuestaRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(EncuestaViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return EncuestaViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
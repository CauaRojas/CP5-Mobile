package br.com.opengroup.cp5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import br.com.opengroup.cp5.database.DatabaseHelper
import com.google.android.material.textfield.TextInputEditText


class CadastroFragment : Fragment() {
    val estados = arrayOf("AC","AL","AM","AP","BA","CE","DF","ES","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SP","SE","TO")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cadastro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val spinner = view.findViewById<Spinner>(R.id.estadosSpinner)
        Log.i("spinner", spinner.toString())
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
        val btnSalvar = view.findViewById<Button>(R.id.btnSalvar)
        val txtNome = view.findViewById<TextInputEditText>(R.id.txtNome)
        val txtSobrenome = view.findViewById<TextInputEditText>(R.id.txtSobrenome)
        val txtTelefone = view.findViewById<TextInputEditText>(R.id.txtTelefone)
        val txtPeso = view.findViewById<TextInputEditText>(R.id.txtPeso)
        btnSalvar.setOnClickListener {
            val nome = txtNome.text.toString()
            val sobrenome = txtSobrenome.text.toString()
            val telefone = txtTelefone.text.toString()
            val peso = txtPeso.text.toString().toDouble()
            val estado = spinner.selectedItem.toString()
            DatabaseHelper(requireContext()).insertUsuario(nome, telefone, sobrenome, estado, peso)
            txtNome.text?.clear()
            txtSobrenome.text?.clear()
            txtTelefone.text?.clear()
            txtPeso.text?.clear()
            spinner.setSelection(0)
            Log.i("database2", DatabaseHelper(requireContext()).selectUsuarios().toString())
        }

        super.onViewCreated(view, savedInstanceState)

    }

}
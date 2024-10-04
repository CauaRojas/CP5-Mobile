package br.com.opengroup.cp5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import br.com.opengroup.cp5.database.DatabaseHelper


class CadastroFragment(val id: Int?, val nome: String?, val sobrenome: String?, val telefone: String?, val peso: Double?, val estado: String?, ) : Fragment() {
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

        val txtNome = view.findViewById<EditText>(R.id.txtNome)
        val txtSobrenome = view.findViewById<EditText>(R.id.txtSobrenome)
        val txtTelefone = view.findViewById<EditText>(R.id.txtTelefone)
        val txtPeso = view.findViewById<EditText>(R.id.txtPeso)
        val btnSalvar = view.findViewById<View>(R.id.btnSalvar)

        txtNome.setText(nome)
        txtSobrenome.setText(sobrenome)
        txtTelefone.setText(telefone)
        peso?.let { txtPeso.setText(it.toString()) }
        estado?.let { spinner.setSelection(estados.indexOf(it)) }


        btnSalvar.setOnClickListener {
            val nome = txtNome.text.toString()
            val sobrenome = txtSobrenome.text.toString()
            val telefone = txtTelefone.text.toString()
            val peso = txtPeso.text.toString().toDouble()
            val estado = spinner.selectedItem.toString()
            if (id != null) {
                DatabaseHelper(requireContext()).updateUsuario(
                    id,
                    nome,
                    telefone,
                    sobrenome,
                    estado,
                    peso
                )
                txtNome.text?.clear()
                txtSobrenome.text?.clear()
                txtTelefone.text?.clear()
                txtPeso.text?.clear()
                spinner.setSelection(0)
                Log.i("database2", DatabaseHelper(requireContext()).selectUsuario(id).toString())
            } else {
                DatabaseHelper(requireContext()).insertUsuario(
                    nome,
                    telefone,
                    sobrenome,
                    estado,
                    peso
                )
                txtNome.text?.clear()
                txtSobrenome.text?.clear()
                txtTelefone.text?.clear()
                txtPeso.text?.clear()
                spinner.setSelection(0)
                Log.i("database2", DatabaseHelper(requireContext()).selectUsuarios().toString())
            }
            val fragment = ListarFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment).commit()
        }


        super.onViewCreated(view, savedInstanceState)

    }

}
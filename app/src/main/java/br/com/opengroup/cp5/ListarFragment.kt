package br.com.opengroup.cp5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.ListView
import br.com.opengroup.cp5.database.DatabaseHelper
import br.com.opengroup.cp5.entities.Usuario

class ListarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listView: ListView = view.findViewById(R.id.listView)
        val usuarios = DatabaseHelper(requireContext()).selectUsuarios()
        listView.adapter = ArrayAdapter<Usuario>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            usuarios
        )
    }

}
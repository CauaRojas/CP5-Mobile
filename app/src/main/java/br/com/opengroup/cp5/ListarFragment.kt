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
import br.com.opengroup.cp5.entities.Usuario

class ListarFragment : Fragment() {
    val usuarios: List<Usuario> = listOf(
        Usuario(1, "João", "1999999", "Da silva", "SP", 92.0),
        Usuario(2, "Maria", "1999999", "da silva", "SP", 92.0),
        Usuario(3, "Pedro", "1999999", "da silva", "SP", 92.0),
        Usuario(4, "José", "1999999", "da silva", "SP", 92.0),
        Usuario(5, "Carlos", "1999999", "da silva", "SP", 92.0),
        Usuario(6, "João", "1999999", "da silva", "SP", 92.0),
        Usuario(7, "Maria", "1999999", "da silva", "SP", 92.0),
        Usuario(8, "Pedro", "1999999", "da silva", "SP", 92.0),
        Usuario(9, "José", "1999999", "da silva", "SP", 92.0),
        Usuario(10, "Carlos", "1999999", "da silva", "SP", 92.0),
        Usuario(11, "João", "1999999", "da silva", "SP", 92.0),
        Usuario(12, "Maria", "1999999", "da silva", "SP", 92.0),        Usuario(13, "Pedro", "1999999", "da silva", "SP", 92.0),
        Usuario(14, "José", "1999999", "da silva", "SP", 92.0),
        Usuario(15, "Carlos", "1999999", "da silva", "SP", 92.0),
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listView: ListView = view.findViewById(R.id.listView)
        listView.adapter = ArrayAdapter<Usuario>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            usuarios
        )
    }

}
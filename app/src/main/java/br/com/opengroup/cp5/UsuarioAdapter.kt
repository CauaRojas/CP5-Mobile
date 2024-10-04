package br.com.opengroup.cp5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.opengroup.cp5.database.DatabaseHelper
import br.com.opengroup.cp5.entities.Usuario
import com.google.android.material.button.MaterialButton

class UsuarioAdapter(var usuarios: MutableList<Usuario>, private val dbContext: Context) : RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            val sobrenome = itemView.findViewById<TextView>(R.id.sobrenome)
            val telefone = itemView.findViewById<TextView>(R.id.telefone)
            val estado = itemView.findViewById<TextView>(R.id.estado)
            val peso = itemView.findViewById<TextView>(R.id.peso)
            val btnEditar = itemView.findViewById<MaterialButton>(R.id.btnEditar)
            val btnDeletar= itemView.findViewById<MaterialButton>(R.id.btnDeletar)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

        override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
            holder.nome.text = usuarios[position].nome
            holder.sobrenome.text = usuarios[position].sobrenome
            holder.telefone.text = usuarios[position].telefone
            holder.estado.text = usuarios[position].estado
            holder.peso.text = usuarios[position].peso.toString()

            holder.btnDeletar.setOnClickListener {
                DatabaseHelper(dbContext).deleteUsuario(usuarios[position].id)
                usuarios.remove(usuarios[position])

                notifyItemRemoved(position)
                notifyItemRangeChanged(position, usuarios.size)
            }

            holder.btnEditar.setOnClickListener {
                val usuario = usuarios[position]
                val fragment = CadastroFragment(
                    usuario.id,
                    usuario.nome,
                    usuario.sobrenome,
                    usuario.telefone,
                    usuario.peso,
                    usuario.estado
                )
                (dbContext as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment).commit()
            }
        }

        override fun getItemCount(): Int {
            return usuarios.size
        }

}
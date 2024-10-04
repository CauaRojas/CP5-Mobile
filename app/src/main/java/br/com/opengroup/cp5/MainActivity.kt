package br.com.opengroup.cp5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastro = findViewById<View>(R.id.btnCadastro)
        val btnLista = findViewById<View>(R.id.btnLista)

        btnCadastro.setOnClickListener {
            val fragment = CadastroFragment(null, null, null, null, null, null)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
        }

        btnLista.setOnClickListener {
            val fragment = ListarFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
        }

        btnLista.setOnClickListener {
            val fragment = ListarFragment()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()
        }

    }
}
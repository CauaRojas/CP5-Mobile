package br.com.opengroup.cp5.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import br.com.opengroup.cp5.entities.Usuario
import java.lang.Exception

class DatabaseHelper(context:Context) : SQLiteOpenHelper(context, "Database", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE IF NOT EXISTS T_USUARIO(" +
                "id_usuario INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "nome VARCHAR(100)," +
                "telefone VARCHAR(15)," +
                "sobrenome VARCHAR(100)," +
                "estado VARCHAR(2)," +
                "peso DOUBLE" +
                ");"

        try{
            db?.execSQL(sql)
            Log.i("db_info","Tabela criada com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Error ao criar tabela")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertUsuario(nome:String, telefone:String, sobrenome:String, estado:String, peso:Double){
        val db = writableDatabase
        val sql = "INSERT INTO T_USUARIO(nome, telefone, sobrenome, estado, peso) VALUES('$nome', '$telefone', '$sobrenome', '$estado', $peso);"
        try{
            db.execSQL(sql)
            Log.i("db_info","Usuario inserido com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Error ao inserir usuario")
        }
    }

    fun selectUsuarios():ArrayList<Usuario>{
        val db = readableDatabase
        val sql = "SELECT * FROM T_USUARIO;"
        val cursor = db.rawQuery(sql, null)
        val usuarios = ArrayList<Usuario>()

        val indiceId = cursor.getColumnIndex("id_usuario")
        val indiceNome = cursor.getColumnIndex("nome")
        val indiceTelefone = cursor.getColumnIndex("telefone")
        val indiceSobrenome = cursor.getColumnIndex("sobrenome")
        val indiceEstado = cursor.getColumnIndex("estado")
        val indicePeso = cursor.getColumnIndex("peso")


        while(cursor.moveToNext()){
            val id = cursor.getInt(indiceId)
            val nome = cursor.getString(indiceNome)
            val telefone = cursor.getString(indiceTelefone)
            val sobrenome = cursor.getString(indiceSobrenome)
            val estado = cursor.getString(indiceEstado)
            val peso = cursor.getDouble(indicePeso)
            usuarios.add(Usuario(id, nome, telefone, sobrenome, estado, peso))
        }
        return usuarios
    }

    fun selectUsuario(id:Int):Usuario?{
        val db = readableDatabase
        val sql = "SELECT * FROM T_USUARIO WHERE id_usuario = $id;"
        val cursor = db.rawQuery(sql, null)
        var usuario:Usuario? = null

        val indiceId = cursor.getColumnIndex("id_usuario")
        val indiceNome = cursor.getColumnIndex("nome")
        val indiceTelefone = cursor.getColumnIndex("telefone")
        val indiceSobrenome = cursor.getColumnIndex("sobrenome")
        val indiceEstado = cursor.getColumnIndex("estado")
        val indicePeso = cursor.getColumnIndex("peso")

        if(cursor.moveToNext()){
            val id = cursor.getInt(indiceId)
            val nome = cursor.getString(indiceNome)
            val telefone = cursor.getString(indiceTelefone)
            val sobrenome = cursor.getString(indiceSobrenome)
            val estado = cursor.getString(indiceEstado)
            val peso = cursor.getDouble(indicePeso)
            usuario = Usuario(id, nome, telefone, sobrenome, estado, peso)
        }
        return usuario
    }

    fun updateUsuario(id:Int, nome:String, telefone:String, sobrenome:String, estado:String, peso:Double){
        val db = writableDatabase
        val sql = "UPDATE T_USUARIO SET nome = '$nome', telefone = '$telefone', sobrenome = '$sobrenome', estado = '$estado', peso = $peso WHERE id_usuario = $id;"
        try{
            db.execSQL(sql)
            Log.i("db_info","Usuario atualizado com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Error ao atualizar usuario")
        }
    }

    fun deleteUsuario(id:Int){
        val db = writableDatabase
        val sql = "DELETE FROM T_USUARIO WHERE id_usuario = $id;"
        try{
            db.execSQL(sql)
            Log.i("db_info","Usuario deletado com sucesso")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i("db_info","Error ao deletar usuario")
        }
    }


}
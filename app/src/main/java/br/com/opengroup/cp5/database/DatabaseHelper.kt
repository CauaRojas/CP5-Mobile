package br.com.opengroup.cp5.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
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
}
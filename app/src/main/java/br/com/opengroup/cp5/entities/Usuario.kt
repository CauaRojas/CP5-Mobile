package br.com.opengroup.cp5.entities


class Usuario{
    val id: Int;
    val nome: String;
    val telefone: String;
    val sobrenome: String;
    val estado: String;
    val peso: Double;

    constructor(id: Int, nome: String, telefone: String, sobrenome: String, estado: String, peso: Double) {
        this.id = id
        this.nome = nome
        this.telefone = telefone
        this.sobrenome = sobrenome
        this.estado = estado
        this.peso = peso
    }

}
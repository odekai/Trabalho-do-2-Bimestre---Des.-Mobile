package com.example.trabalho2b;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Produto implements Parcelable {
    private String nome;         // Nome do produto
    private Categoria categoria; // Relacionamento 1:1 com Categoria

    public Produto() {
    }

    public Produto(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " | Categoria: " + (categoria != null ? categoria.getNome() : "Nenhuma");
    }

    // Implementação Parcelable para passar via Intent
    protected Produto(Parcel in) {
        nome = in.readString();
        categoria = (Categoria) in.readSerializable(); // Categoria deve implementar Serializable
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeSerializable((Serializable) categoria); // Serializando a Categoria
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };
}

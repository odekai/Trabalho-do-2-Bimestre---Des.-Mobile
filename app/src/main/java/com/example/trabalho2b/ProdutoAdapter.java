package com.example.trabalho2b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder> {

    private List<Produto> listaProdutos;

    public ProdutoAdapter(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @NonNull
    @Override
    public ProdutoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Infla o layout para cada item da lista
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ProdutoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProdutoViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);

        // Nome do produto
        holder.textViewNome.setText(produto.getNome());

        // Categoria do produto
        if (produto.getCategoria() != null) {
            holder.textViewCategoria.setText(produto.getCategoria().getNome());
        } else {
            holder.textViewCategoria.setText("Sem categoria");
        }
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    // Classe interna ProdutoViewHolder
    public static class ProdutoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNome;
        TextView textViewCategoria;

        public ProdutoViewHolder(View itemView) {
            super(itemView);
            textViewNome = itemView.findViewById(android.R.id.text1);  // Nome do produto
            textViewCategoria = itemView.findViewById(android.R.id.text2);  // Categoria do produto
        }
    }
}

package com.example.trabalho2b;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProdutoCadastradoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProdutos;
    private ProdutoAdapter produtoAdapter;
    private ArrayList<Produto> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_cadastrado);

        // Inicializando o RecyclerView
        recyclerViewProdutos = findViewById(R.id.listViewProdutos);

        // Recebendo a lista de produtos da Intent
        listaProdutos = getIntent().getParcelableArrayListExtra("listaProdutos");

        if (listaProdutos != null && !listaProdutos.isEmpty()) {
            // Definindo o LayoutManager
            recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));

            // Criando o Adapter e configurando no RecyclerView
            produtoAdapter = new ProdutoAdapter(listaProdutos);
            recyclerViewProdutos.setAdapter(produtoAdapter);
        } else {
            // Caso a lista esteja vazia
            Toast.makeText(this, "Nenhum produto cadastrado.", Toast.LENGTH_SHORT).show();
        }
    }
}

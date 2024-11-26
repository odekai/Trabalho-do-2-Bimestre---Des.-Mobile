package com.example.trabalho2b;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProdutoCadastradoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_cadastrado);

        // obtendo os dados enviados
        String nomeProduto = getIntent().getStringExtra("nomeProduto");
        String categoria = getIntent().getStringExtra("categoria");

        //atualizando o layout
        TextView txtDetalhes = findViewById(R.id.txtDetalhesProduto);
        txtDetalhes.setText("Produto: "+nomeProduto+ "\nCategorias: "+ categoria);
    }
}

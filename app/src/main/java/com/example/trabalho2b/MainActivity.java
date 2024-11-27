package com.example.trabalho2b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;
    private EditText edtNomeProduto;
    private Button buttoncadastrar;
    static ArrayList<Produto> listaProdutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_cadastro);


        // Inicializando a lista de produtos
        listaProdutos = new ArrayList<>();


        //inicialização dos componentes da UI
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        edtNomeProduto = findViewById(R.id.edNomeProduto);
        buttoncadastrar = findViewById(R.id.buttoncadastrar);

        // Lista de categorias como Categoria
        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("1", "Eletrônicos"));
        categorias.add(new Categoria("2", "Roupas"));
        categorias.add(new Categoria("3", "Alimentos"));
        categorias.add(new Categoria("4", "Móveis"));
        categorias.add(new Categoria("5", "Beleza"));

        // Configurando o Spinner com um ArrayAdapter
        ArrayAdapter<Categoria> categoriaAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, categorias
        );
        categoriaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(categoriaAdapter);



        //ação do botao para salvar
        buttoncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarProduto();
            }
        });
    }

    public void salvarProduto() {
        //obtendo o nome do produto
        String nomeProduto = edtNomeProduto.getText().toString().trim();
        //obtendo a categoria selecionada
        Categoria categoriaSelecionada = (Categoria) spinnerCategorias.getSelectedItem();


        //verificando se o nome do pruduto foi inserido e uma categoria foi selecionada
        if (!nomeProduto.isEmpty() && categoriaSelecionada != null) {
            // Criando um novo produto e adicionando à lista
            Produto produto = new Produto(nomeProduto, categoriaSelecionada);

            if (listaProdutos == null) { // Inicializar a lista se estiver null
                listaProdutos = new ArrayList<>();
            }
            listaProdutos.add(produto);


            //exibir mensagem de sucesso
            Toast.makeText(MainActivity.this,
                    "Produto: " + nomeProduto + "/nCategoria: " + categoriaSelecionada + "salvo com sucesso!",
                    Toast.LENGTH_SHORT).show();

            //Limpando os campos aós o salvamento
            edtNomeProduto.setText("");
            spinnerCategorias.setSelection(0);

            // Abrir a próxima tela com a lista de produtos
            Intent intent = new Intent(MainActivity.this, ProdutoCadastradoActivity.class);
            intent.putParcelableArrayListExtra("listaProdutos", listaProdutos); // Enviar a lista de produtos
            startActivity(intent);

        } else {
            //Exibir mensagem de erro se os campos não estiverem preenchidos corretamente
            Toast.makeText(MainActivity.this,
                    "Por favor,prenche o nome do produto e selecione uma categoria.",
                    Toast.LENGTH_SHORT).show();


        }
    }
}









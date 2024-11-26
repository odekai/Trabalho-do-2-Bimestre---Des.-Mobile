package com.example.trabalho2b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerCategorias;
    private EditText edtNomeProduto;
    private Button buttoncadastrar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_cadastro);


        //inicialização dos componentes da UI
        spinnerCategorias = findViewById(R.id.spinnerCategorias);
        edtNomeProduto = findViewById(R.id.edNomeProduto);
        buttoncadastrar = findViewById(R.id.buttoncadastrar);

        //definindo as opções para o Spinner(categorias)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categoria_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorias.setAdapter(adapter);

        //ação do botao para salvar
        buttoncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarProduto();
            }

            private void salvarProduto() {
                //obtendo o nome do produto
                String nomeProduto = edtNomeProduto.getText().toString().trim();
                //obtendo a categoria selecionada
                String categoriaSelecionada = spinnerCategorias.getSelectedItem().toString();
                //verificando se o nome do pruduto foi inserido e uma categoria foi selecionada
                if (!nomeProduto.isEmpty() && !categoriaSelecionada.equals("Selecione a categoria")) {

                    //exibir mensagem de sucesso
                    Toast.makeText(MainActivity.this,
                            "Produto: " + nomeProduto + "/nCategoria: " + categoriaSelecionada + "salvo com sucesso!",
                            Toast.LENGTH_SHORT).show();

                    //Limpando os campos aós o salvamento
                    edtNomeProduto.setText("");//Limpando o spinner para o item inicial
                    spinnerCategorias.setSelection(0);//Resetando o spinner para o item inicial

                    //iniciar activity
                    Intent intent = new Intent(MainActivity.this, ProdutoCadastradoActivity.class);
                    //passando o nome do produto
                    intent.putExtra("nomeProduto",nomeProduto);
                    //passando categoria
                    intent.putExtra("categoria",categoriaSelecionada);
                    startActivity(intent);
                } else {
                    //Exibir mensagem de erro se os campos não estiverem preenchidos corretamente
                    Toast.makeText(MainActivity.this,
                            "Por favor,prenche o nome do produto e selecione uma categoria.",
                            Toast.LENGTH_SHORT).show();
                }


            }

        });






        }
}

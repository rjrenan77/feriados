package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import devrbs.com.br.feriados.adapter.FeriadoAdapter;
import devrbs.com.br.feriados.dao.BDSQLiteHelper;

public class ListaFeriadosActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;
    ArrayList<Feriado> listaFeriados;
    FeriadoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //associa a activity ao layout
        setContentView(R.layout.activity_lista_feriados);


        //instancia banco de dados
        bd = new BDSQLiteHelper(this);


        //pegando referencia dos botoes
        Button btnInicio = findViewById(R.id.btn_lista_feriados_inicio);


        //tratando evento de click no botao
        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        //ativando botao voltar na actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //mostra o botao voltar
        getSupportActionBar().setHomeButtonEnabled(true); //ativa o botao

    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView lista = (ListView) findViewById(R.id.lista_feriados);

        //recebe os valores da intents da MainActivity e MesActivity
        Intent mainIntent = getIntent();
        String estado = mainIntent.getExtras().getString("estado");
        String mes = mainIntent.getExtras().getString("mes");

        Log.i("estado---------------->", estado);
        Log.i("mes--------------->", mes);

        //retornando feriados do estado de acordo com o mes escolhido
        listaFeriados = bd.retornaFeriadosDoEstadoPeloMes(estado, mes);
        //listaFeriados = bd.retornaTodosFeriadosRJ();
        Log.i("-------->>", "onStart: " + listaFeriados);


        //verificando se a lista vem populada do banco de dados
        //se vier vazia, eu desativo a visibilidade da lista
        if (listaFeriados.isEmpty()) {
            lista.setVisibility(View.GONE);
        //se não vier vazia, eu desativo a visibilidade do text view que traz a mensagem de que não há feriados
        //após isso eu exibo a lista
        } else {

            TextView mensagemNaoHaDados = findViewById(R.id.msg_nao_ha_dados);
            mensagemNaoHaDados.setVisibility(View.GONE);

            adapter = new FeriadoAdapter(this, listaFeriados);
            lista.setAdapter(adapter);

            /***********DEFININDO UM CLIQUE CURTO EM UM ITEM DA LISTA***************/
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ListaFeriadosActivity.this,"Posição: " + position, Toast.LENGTH_SHORT).show();
                }
            });

            /***********DEFININDO UM CLIQUE LONGO NO ITEM DA LISTA**********************************************/
            lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ListaFeriadosActivity.this,"Posição: " + position, Toast.LENGTH_SHORT).show();
                    //true consome o evento sozinho
                    return true;
                }
            });


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //só assim não esquece a referencia do estado!! kkk
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

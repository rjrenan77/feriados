package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import devrbs.com.br.feriados.adapter.FeriadoAdapter;
import devrbs.com.br.feriados.dao.BDSQLiteHelper;

public class ListaFeriadosActivity extends AppCompatActivity{

    private BDSQLiteHelper bd;
    ArrayList<Feriado> listaFeriados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //associa a activity ao layout
        setContentView(R.layout.activity_lista_feriados);
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
        listaFeriados = bd.retornaTodosFeriadosRJ();
        Log.i("-------->>", "onStart: " + listaFeriados);


        FeriadoAdapter adapter = new FeriadoAdapter(this, listaFeriados);
        if(lista != null)
            lista.setAdapter(adapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                startActivity(new Intent(this, MesActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }
}

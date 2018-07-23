package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        bd = new BDSQLiteHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView lista = (ListView) findViewById(R.id.lista_feriados);
        listaFeriados = bd.retornaTodosFeriadosRJ();
        Log.i("-------->>", "onStart: " + listaFeriados.get(0).toString());
        FeriadoAdapter adapter = new FeriadoAdapter(this, listaFeriados);
        lista.setAdapter(adapter);


    }
}

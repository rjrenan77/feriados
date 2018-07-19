package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListaFeriadosActivity extends AppCompatActivity{

    private SimpleAdapter simpleAdapter;
    //cada entrada no ArrayList é um hashmap, o hashMap liga o dado a cada linha da lista pela Key.
    ArrayList<HashMap<String,String>> listaFeriados = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lista_feriados);

    //O array de string é rodado através do hashmap criado para cada par. As chaves linha 1 e linha 2 são usadas. Cada hashmap é adicionado ao
    //arraylist
    HashMap<String,String> item;
    for(int i = 0; i<FeriadosArrayList.length;i++){

        item = new HashMap<String, String>();
        item.put("linha 1", FeriadosArrayList[i][0]);
        item.put("linha 2", FeriadosArrayList[i][1]);
        listaFeriados.add(item);

    }

    //depois que a lista é carregada, configuro o simple adapter para mostrar no listview
    simpleAdapter = new SimpleAdapter(this, listaFeriados, R.layout.duaslinhas, new String[]{"linha 1", "linha 2"}, new int[]{R.id.linha_1_lista_feriados,R.id.linha_2_lista_feriados});
    //seto o adapter para carregar a lista
    ((ListView)findViewById(R.id.lista_feriados)).setAdapter(simpleAdapter);


    //referenciando botoes
    Button voltar = findViewById(R.id.btn_lista_feriados_voltar);
    Button inicio = findViewById(R.id.btn_lista_feriados_inicio);

    //setando botao voltar
    voltar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListaFeriadosActivity.this,MesActivity.class);
            startActivity(intent);

        }
    });

    //setando botao inicio
    inicio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListaFeriadosActivity.this, MainActivity.class);
            startActivity(intent);
        }
    });

    }


    //dados a serem apresentados na ListView
    private String[][] FeriadosArrayList = {

            {"dia das crianças","12/10/2018"},
            {"Natal","25/12/2018"}
    };
}

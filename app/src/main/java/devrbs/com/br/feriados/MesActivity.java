package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MesActivity extends AppCompatActivity {

     RadioGroup rdg_mes;
     RadioButton janeiro;
     RadioButton fevereiro;
     RadioButton marco;
     RadioButton abril;
     RadioButton maio ;
     RadioButton junho ;
     RadioButton julho;
     RadioButton agosto;
     RadioButton setembro;
     RadioButton outubro;
     RadioButton novembro;
     RadioButton dezembro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);

        //referenciando botoes dos meses para os objetos
         rdg_mes = findViewById(R.id.rdg_mes);
         janeiro = findViewById(R.id.rdb_mes_jan);
         fevereiro = findViewById(R.id.rdb_mes_fev);
         marco = findViewById(R.id.rdb_mes_mar);
         abril = findViewById(R.id.rdb_mes_abr);
         maio = findViewById(R.id.rdb_mes_mai);
         junho = findViewById(R.id.rdb_mes_jun);
         julho = findViewById(R.id.rdb_mes_jul);
         agosto = findViewById(R.id.rdb_mes_ago);
         setembro = findViewById(R.id.rdb_mes_set);
         outubro = findViewById(R.id.rdb_mes_out);
         novembro = findViewById(R.id.rdb_mes_nov);
         dezembro = findViewById(R.id.rdb_mes_dez);
        //botoes avancar e voltar
        //final Button btnMesAvancar = findViewById(R.id.btn_mes_avancar);
       // Button btnMesVoltar = findViewById(R.id.btn_mes_voltar);

        //verificando se o botão avancar foi clicado
       // btnMesAvancar.setOnClickListener(new View.OnClickListener() {
        //    @Override
            //public void onClick(View v) {
                //verifica se o radiobutton está clicado

           // }
       // });

        /*//intent do botao voltar
        btnMesVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });*/



        //ativando botao voltar na actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //mostra o botao voltar
        getSupportActionBar().setHomeButtonEnabled(true); //ativa o botao




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finishAffinity();
                break;

            case R.id.icone_avancar:
                if (rdg_mes.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(getApplicationContext(), "Por favor escolha uma opção", Toast.LENGTH_SHORT).show();

                } else {
                    String mes = "";
                    if (janeiro.isChecked()) {
                        mes = "Janeiro";

                    }
                    if (fevereiro.isChecked()) {
                        mes = "Fevereiro";
                    }
                    if (marco.isChecked()) {
                        mes = "Março";
                    }
                    if (abril.isChecked()) {
                        mes = "Abril";
                    }

                    if (maio.isChecked()) {
                        mes = "Maio";
                    }

                    if (junho.isChecked()) {
                        mes = "Junho";
                    }

                    if (julho.isChecked()) {
                        mes = "Julho";
                    }

                    if (agosto.isChecked()) {
                        mes = "Agosto";
                    }

                    if (setembro.isChecked()) {
                        mes = "Setembro";
                    }

                    if (outubro.isChecked()) {
                        mes = "Outubro";
                    }

                    if (novembro.isChecked()) {
                        mes = "Novembro";
                    }

                    if (dezembro.isChecked()) {
                        mes = "Dezembro";
                    }

                    //recebendo valor do radio button do MainActivity
                    Intent valorEstadoRadioButtonMainActivity = getIntent();
                    String estado = valorEstadoRadioButtonMainActivity.getExtras().getString("estado");
                    Log.i("ESTADO-------->", estado);

                    Toast.makeText(getApplicationContext(), "Mes: " + mes, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MesActivity.this, ListaFeriadosActivity.class);

                    //enviado valores mes e estado desta intent para a próxima
                    intent.putExtra("mes",mes);
                    intent.putExtra("estado",estado);


                    startActivity(intent);
                    break;

                }


        }
        return super.onOptionsItemSelected(item);
    }
}

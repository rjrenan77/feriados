package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //radio buttons da main activity
        final RadioGroup rdg_estado = findViewById(R.id.rdg_estados);
        final RadioButton rdb_rj = findViewById(R.id.rdb_RJ);
        final RadioButton rdba_sp = findViewById(R.id.rdb_SP);
        //botao avancar
        Button btn_avancar = findViewById(R.id.btn_avancar);
        btn_avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //verifica se algum radiobutton não está clicado
                if (rdg_estado.getCheckedRadioButtonId() == -1) {

                    Toast.makeText(getApplicationContext(), "Por favor escolha uma opção.", Toast.LENGTH_SHORT).show();

                }
                //verifica qual radio button está ativado
                else {

                    String estado = "";

                    if (rdb_rj.isChecked()) {
                        estado = "Rio de Janeiro";
                    }
                    if (rdba_sp.isChecked()) {
                        estado = "São Paulo";
                    }

                    Toast.makeText(getApplicationContext(), "Estado:" + estado, Toast.LENGTH_SHORT).show();

                    //transicao de tela para a activity mes
                    Intent intent = new Intent(MainActivity.this, MesActivity.class);
                    startActivity(intent);
                    finish();

                }
            }

        });


        }
    }

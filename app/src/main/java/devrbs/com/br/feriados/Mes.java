package devrbs.com.br.feriados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Mes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);

    //referenciando botoes para os objetos
    final RadioGroup rdg_mes = findViewById(R.id.rdg_mes);
    final RadioButton janeiro = findViewById(R.id.rdb_mes_jan);
    final RadioButton fevereiro = findViewById(R.id.rdb_mes_fev);
    final Button btnMesAvancar = findViewById(R.id.btn_mes_avancar);
    Button btnMesVoltar = findViewById(R.id.btn_mes_voltar);

    //verificando se o botão avancar foi clicado
    btnMesAvancar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //verifica se o radiobutton está clicado
            if (rdg_mes.getCheckedRadioButtonId() == -1) {

                Toast.makeText(getApplicationContext(),"Por favor escolha uma opção", Toast.LENGTH_SHORT).show();

            } else {
                String mes = "";
                if (janeiro.isChecked()) {
                    mes = "Janeiro";

                }
                if (fevereiro.isChecked()) {
                    mes = "Fevereiro";
                }
                Toast.makeText(getApplicationContext(), "Mes: " + mes, Toast.LENGTH_SHORT).show();

            }
        }
    });

    //intent do botao voltar

    btnMesVoltar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Mes.this, MainActivity.class);
            startActivity(intent);
        }
    });


    }


}

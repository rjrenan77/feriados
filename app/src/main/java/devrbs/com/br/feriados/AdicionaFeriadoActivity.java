package devrbs.com.br.feriados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devrbs.com.br.feriados.dao.BDSQLiteHelper;

public class AdicionaFeriadoActivity extends AppCompatActivity {

    private BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_feriado);

        //referencia do banco passando esse contexto
        bd = new BDSQLiteHelper(this);

        //trazendo referencias da activity
        final EditText diaEdtText  = (EditText) findViewById(R.id.edt_dia);
        final EditText dataEdtText  = (EditText) findViewById(R.id.edt_data);
        final EditText mesEdtText  = (EditText) findViewById(R.id.edt_mes);
        final EditText anoEdtText  = (EditText) findViewById(R.id.edt_ano);
        final EditText feriadoEdtText  = (EditText) findViewById(R.id.edt_feriado);

        Button ok = (Button) findViewById(R.id.btn_ok_feriado);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feriado feriado = new Feriado();
                feriado.setDia(diaEdtText.getText().toString());
                feriado.setData(Integer.parseInt(dataEdtText.getText().toString()));
                feriado.setMes(mesEdtText.getText().toString());
                feriado.setAno(Integer.parseInt(anoEdtText.getText().toString()));
                feriado.setFeriado(feriadoEdtText.getText().toString());

                bd.adicionaFeriadoRJ(feriado);
                Toast.makeText(getApplicationContext(), "Feriado adicionado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}

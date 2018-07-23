package devrbs.com.br.feriados.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import devrbs.com.br.feriados.Feriado;
import devrbs.com.br.feriados.R;

public class FeriadoAdapter extends ArrayAdapter<Feriado>{

    private final Context context;
    private final ArrayList<Feriado> elementosFeriado;

    public FeriadoAdapter(Context context, ArrayList<Feriado> elementosFeriado) {
        super(context, R.layout.duaslinhas, elementosFeriado);
        this.context = context;
        this.elementosFeriado = elementosFeriado;
    }


    //preenche e apresenta os dados na tela da activity_lista_feriados
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //inflador de dados na activity
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.duaslinhas, parent, false);

        //referencia da activity duas linhas
        TextView data = (TextView) rowView.findViewById(R.id.txt_view_data);
        TextView feriado = (TextView) rowView.findViewById(R.id.txt_view_feriado);

        //setando dados nas variaveis(TODO : montar data/mes/ano)
        data.setText(elementosFeriado.get(position).getData());
        feriado.setText(elementosFeriado.get(position).getFeriado());

        return rowView;

    }

}

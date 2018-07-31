package devrbs.com.br.feriados.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import devrbs.com.br.feriados.Feriado;
import devrbs.com.br.feriados.R;

//extende a classe baseadapter para que eu possa criar o meu adapter. Um adpter adapta itens da lista em um listview

//getCount, getItem, getItemId e getView são 4 métodos abstratos do BaseAdapter que têm de ser implementados obrigatóriamente


public class FeriadoAdapter extends BaseAdapter{

    private final Activity context;
    private final List<Feriado> elementosFeriado;

    //recebo aqui nesse construtor o contexto da activity e a lista a ser manipulada
    public FeriadoAdapter(Activity context, List<Feriado> elementosFeriado) {
        this.context = context;
        this.elementosFeriado = elementosFeriado;
    }


    //conta o numero de itens da lista
    @Override
    public int getCount() {
        return elementosFeriado.size();
    }

    //retorna um item a partir de uma posicao
    @Override
    public Object getItem(int position) {
        return elementosFeriado.get(position);
    }

    //retorna o id do item buscado
    @Override
    public long getItemId(int position) {
        return elementosFeriado.get(position).getId();
    }

    //preenche e apresenta os dados na tela da activity_lista_feriados
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //cria/infla uma view e adiciona isso a uma variavel
        //parent é uma viewGroup layoutPai (igual a um radioGroup) onde adiciono a minha lista
        //parametro false pergunta se quero criar a view nesse exato momento
        View view = context.getLayoutInflater().inflate(R.layout.duaslinhas, parent, false);

        //position é justamente a posiçao que devo pegar o elemento na lista que foi passada
        Feriado feriado = elementosFeriado.get(position);

        //pegando as referencias das views
        TextView txtDataCompleta = view.findViewById(R.id.txt_view_data);
        TextView txtFeriado = view.findViewById(R.id.txt_view_feriado);

        //populando essas referencias
        txtDataCompleta.setText(String.valueOf(feriado.getData()+ "/" + feriado.getMes()) + "/" + feriado.getAno());
        txtFeriado.setText(feriado.getFeriado());


        return view;

      /*  //popula um em cada posicao
        Feriado feriado = elementosFeriado.get(position);

        //inflador de dados na activity
        LayoutInflater inflater = LayoutInflater.from(context);

        View rowView = convertView;

        if(rowView == null) {
            rowView = inflater.inflate(R.layout.duaslinhas, parent, false);
        }

        //referencia da activity duas linhas
        TextView data = (TextView) rowView.findViewById(R.id.txt_view_data);
        TextView txt_feriado = (TextView) rowView.findViewById(R.id.txt_view_feriado);

        //setando dados nas variaveis
        data.setText(String.valueOf(feriado.getData()));
        txt_feriado.setText(feriado.getFeriado());

        return rowView;*/

    }

}
package devrbs.com.br.feriados.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import devrbs.com.br.feriados.Feriado;

public class BDSQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "FeriadosDB";
    private static final String TABELA_RJ = "rj";
    private static final String ID = "id";
    private static final String DIA = "dia";
    private static final String DATA = "data";
    private static final String MES = "mes";
    private static final String ANO = "ano";
    private static final String FERIADO = "feriado";
    private static final String FLAG = "flag";

    private static final String[] COLUNAS = {ID, DIA,DATA,MES,ANO,FERIADO,FLAG};

    private static final String CREATE_TABLE_RJ = "CREATE TABLE rj (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "dia TEXT," +
            "data INTEGER, "+
            "mes TEXT, " +
            "ano INTEGER," +
            "feriado TEXT," +
            "flag INTEGER)";

    private static final String CREATE_TABLE_SP = "CREATE TABLE sp (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "dia TEXT," +
            "data INTEGER," +
            "mes TEXT," +
            "ano INTEGER," +
            "feriado TEXT," +
            "flag INTEGER)";

    //**************RIO DE JANEIRO**************//

    //insert dos feriados de janeiro do RJ
    private static final String INSERT_FERIADOS_JANEIRO_RJ = "INSERT INTO rj (" +
            "dia, data, mes, ano, feriado, flag) " +
            "VALUES ('Segunda-Feira', 01, 'Janeiro', 2018, 'Confraternização Universal (Ano Novo)', 1 )," +
            "('Sábado',20,'Janeiro',2018,'Dia de São Sebastião',1);";

    //insert dos feriados de fevereiro do RJ
    private static final String INSERT_FERIADOS_FEVEREIRO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 13, 'Fevereiro', 2018, 'Carnaval', 1);";

    //insert dos feriados de marco do RJ
    private static final String INSERT_FERIADOS_MARCO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 30, 'Março', 2018, 'Sexta-Feira Santa', 1);";

    //insert dos feriados de abril do RJ
    private static final String INSERT_FERIADOS_ABRIL_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sábado', 21, 'Abril', 2018, 'Dia de Tiradentes', 1)," +
            "('Segunda-Feira', 23 , 'Abril', 2018, 'Dia de São Jorge', 1);";

    //insert dos feriados de maio do RJ
    private static final String INSERT_FERIADOS_MAIO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 01, 'Maio', 2018, 'Dia do Trabalho', 1)," +
            "('Quinta-Feira', 31 , 'Maio', 2018, 'Corpus Christi', 1);";

    //insert dos feriados de setembro do RJ
    private static final String INSERT_FERIADOS_SETEMBRO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 7, 'Setembro', 2018, 'Independência do Brasil', 1);";

    //insert dos feriados de outubro do RJ
    private static final String INSERT_FERIADOS_OUTUBRO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 12, 'Outubro', 2018, 'Nossa Senhora de Aparecida', 1)," +
            "('Segunda-Feira', 15 , 'Outubro', 2018, 'Dia dos Professores', 1)," +
            "('Quarta-feira', 17, 'Outubro',2018,'Dia do Comércio', 1)," +
            "('Domingo',28,'Outubro',2018,'Dia do Servidor Público', 1);";

    //insert dos feriados de novembro do RJ
    private static final String INSERT_FERIADOS_NOVEMBRO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 02, 'Novembro', 2018, 'Dia de Finados', 1)," +
            "('Quinta-Feira', 15 , 'Novembro', 2018, 'Proclamação da República', 1)," +
            "('Terça-Feira', 20 , 'Novembro', 2018, 'Dia da Consciência Negra', 1);";


    //insert dos feriados de setembro do RJ
    private static final String INSERT_FERIADOS_DEZEMBRO_RJ = "INSERT INTO rj ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 25, 'Dezembro', 2018, 'Natal', 1);";





    //************SÃO PAULO *******//
    //insert dos feriados de janeiro do SP
    private static final String INSERT_FERIADOS_JANEIRO_SP = "INSERT INTO sp (" +
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Segunda-Feira', 01, 'Janeiro', 2018, 'Confraternização Universal (Ano Novo)', 1 )," +
            "('Quinta-Feira',25,'Janeiro',2018,'Aniversário da Cidade de São Paulo', 1);";


    //insert dos feriados de fevereiro do SP
    private static final String INSERT_FERIADOS_FEVEREIRO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 13, 'Fevereiro', 2018, 'Carnaval', 1);";


    //insert dos feriados de marco do sp
    private static final String INSERT_FERIADOS_MARCO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 30, 'Março', 2018, 'Sexta-Feira Santa', 1);";

    //insert dos feriados de abril do SP
    private static final String INSERT_FERIADOS_ABRIL_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sábado', 21, 'Abril', 2018, 'Dia de Tiradentes', 1);";

    //insert dos feriados de maio do SP
    private static final String INSERT_FERIADOS_MAIO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 01, 'Maio', 2018, 'Dia do Trabalho', 1)," +
            "('Quinta-Feira', 31 , 'Maio', 2018, 'Corpus Christi', 1);";


    //insert dos feriados de abril do SP
    private static final String INSERT_FERIADOS_JULHO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Segunda-feira', 09, 'Julho', 2018, 'Revolução Constitucionalista', 1);";


    //insert dos feriados de setembro do SP
    private static final String INSERT_FERIADOS_SETEMBRO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 7, 'Setembro', 2018, 'Independência do Brasil', 1);";



    //insert dos feriados de outubro do SP
    private static final String INSERT_FERIADOS_OUTUBRO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 12, 'Outubro', 2018, 'Nossa Senhora de Aparecida', 1)," +
            "('Segunda-Feira', 15 , 'Outubro', 2018, 'Dia dos Professores', 1)," +
            "('Quarta-feira', 17, 'Outubro',2018,'Dia do Comércio', 1)," +
            "('Domingo',28,'Outubro',2018,'Dia do Servidor Público', 1);";


    //insert dos feriados de novembro do SP
    private static final String INSERT_FERIADOS_NOVEMBRO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Sexta-Feira', 02, 'Novembro', 2018, 'Dia de Finados', 1)," +
            "('Quinta-Feira', 15 , 'Novembro', 2018, 'Proclamação da República', 1)," +
            "('Terça-Feira', 20 , 'Novembro', 2018, 'Dia da Consciência Negra', 1);";


    //insert dos feriados de setembro do SP
    private static final String INSERT_FERIADOS_DEZEMBRO_SP = "INSERT INTO sp ("+
            "dia, data, mes, ano, feriado, flag)" +
            "VALUES ('Terça-Feira', 25, 'Dezembro', 2018, 'Natal', 1);";




    //construtor que recebe o contexto, o nome do banco e a versao
    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //o que vou fazer quando crio o banco
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_RJ);
        db.execSQL(CREATE_TABLE_SP);
        db.execSQL(INSERT_FERIADOS_JANEIRO_RJ);
        db.execSQL(INSERT_FERIADOS_FEVEREIRO_RJ);
        db.execSQL(INSERT_FERIADOS_MARCO_RJ);
        db.execSQL(INSERT_FERIADOS_ABRIL_RJ);
        db.execSQL(INSERT_FERIADOS_MAIO_RJ);
        db.execSQL(INSERT_FERIADOS_SETEMBRO_RJ);
        db.execSQL(INSERT_FERIADOS_OUTUBRO_RJ);
        db.execSQL(INSERT_FERIADOS_NOVEMBRO_RJ);
        db.execSQL(INSERT_FERIADOS_DEZEMBRO_RJ);

        db.execSQL(INSERT_FERIADOS_JANEIRO_SP);
        db.execSQL(INSERT_FERIADOS_FEVEREIRO_SP);
        db.execSQL(INSERT_FERIADOS_MARCO_SP);
        db.execSQL(INSERT_FERIADOS_ABRIL_SP);
        db.execSQL(INSERT_FERIADOS_MAIO_SP);
        db.execSQL(INSERT_FERIADOS_JULHO_SP);
        db.execSQL(INSERT_FERIADOS_SETEMBRO_SP);
        db.execSQL(INSERT_FERIADOS_OUTUBRO_SP);
        db.execSQL(INSERT_FERIADOS_NOVEMBRO_SP);
        db.execSQL(INSERT_FERIADOS_DEZEMBRO_SP);
    }


    //o que vou fazer para atualizar o banco
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    /************CRIACAO DOS METODOS DE ACESSO (por enquanto só RJ)****************/
    //add feriado
    public void adicionaFeriadoRJ(Feriado feriado){
        //pega uma referencia de escrita do banco de dados
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = montaConteudoDoFeriado(feriado);


        db.insert(TABELA_RJ, null, values);
        db.close();

    }

    //retorna os valores dos feriados
    @NonNull
    private ContentValues montaConteudoDoFeriado(Feriado feriado) {
        //monta todos os elementos a serem inseridos
        ContentValues values = new ContentValues();
        values.put(DIA,feriado.getDia());
        values.put(DATA,feriado.getData());
        values.put(MES, feriado.getMes());
        values.put(ANO, feriado.getAno());
        values.put(FERIADO, feriado.getFeriado());
        //flag é igua a 1 quando aparece na lista ( sem soft delete)
        values.put(FLAG, 1);
        return values;
    }


    //retornar feriados do banco pelo ID(//TODO : VER ISSO)
    public Feriado retornaFeriadoRJ(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABELA_RJ, //indica a tabela
                COLUNAS, //indica as colunas
       "id = ?", //colunas a comparar
                new String[] {String.valueOf(id)},// parametros
                null,
                null,
                null,
                null);


       if(cursor== null){
           return null;
       }else {
           cursor.moveToFirst();
           Feriado feriado = setaFeriado(cursor);
           return feriado;
       }

    }

    //seta os dados do feriado
    private Feriado setaFeriado(Cursor cursor) {

        Feriado feriado = new Feriado();
        feriado.setId(Integer.parseInt(cursor.getString(0)));
        feriado.setDia(cursor.getString(1));
        feriado.setData(Integer.parseInt(cursor.getString(2)));
        feriado.setMes(cursor.getString(3));
        feriado.setAno(Integer.parseInt(cursor.getString(4)));
        feriado.setFeriado(cursor.getString(5));
        feriado.setFlag(Integer.parseInt(cursor.getString(6)));
        return feriado;

    }


    //retorna todos os feriados
    public ArrayList<Feriado> retornaTodosFeriadosRJ(){

        ArrayList<Feriado> listaFeriados =  new ArrayList<Feriado>();
        String query = "SELECT * FROM " + TABELA_RJ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                Feriado feriado = setaFeriado(cursor);
                listaFeriados.add(feriado);
            }while (cursor.moveToNext());
        }
        return listaFeriados;




    }


    //atualiza feriados
    public int atualizaFeriadosRJ(Feriado feriado){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = montaConteudoDoFeriado(feriado);

        int i = db.update(TABELA_RJ, //tabela
                values, //seus valores
                ID + " = ?", //cláusula
                new String[]{String.valueOf(feriado.getId())});//parametro
        db.close();
        return i; //numero de linhas

    }


    //deleta feriados
    public int deletaFeriadoRJ(Feriado feriado){

        SQLiteDatabase db = this.getWritableDatabase();

        int i = db.delete(TABELA_RJ,
                ID +"=?",
                new String[]{String.valueOf(feriado.getId())});

        db.close();
        return i; //numero de linhas


    }

    public ArrayList<Feriado> retornaFeriadosDoEstadoPeloMes(String tabela, String mes) {

        ArrayList<Feriado> listaFeriados =  new ArrayList<Feriado>();
        String query = "SELECT * FROM " + tabela + " WHERE mes = ?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,new String[] {mes});

        if(cursor.moveToFirst()){
            do {
                Feriado feriado = setaFeriado(cursor);
                listaFeriados.add(feriado);
            }while (cursor.moveToNext());
        }
        return listaFeriados;

    }
}

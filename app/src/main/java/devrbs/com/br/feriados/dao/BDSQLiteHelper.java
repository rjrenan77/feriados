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

    private static final String CREATE_TABLE = "CREATE TABLE rj (" +
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

    //construtor que recebe o contexto, o nome do banco e a versao
    public BDSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //o que vou fazer quando crio o banco
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    //o que vou fazer para atualizar o banco
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2){
            db.execSQL(CREATE_TABLE_SP);
        }
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

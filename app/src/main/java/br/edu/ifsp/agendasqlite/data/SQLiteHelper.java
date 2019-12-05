package br.edu.ifsp.agendasqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "agenda.db";
    static final String TABLE_NAME ="contatos";

    static final String KEY_ID = "id";
    static final String KEY_NOME = "nome";
    static final String KEY_FONE = "fone";
    static final String KEY_FONE_CONTATO = "fone_contato";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    static final String KEY_DATA_NASCIMENTO = "data_nascimento";

    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_V1 = "CREATE TABLE " + TABLE_NAME + " ("
                                               + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                               + KEY_NOME + " TEXT, "
                                               + KEY_FONE + " TEXT, "
                                               + KEY_EMAIL + " TEXT );";

    private static final String CREATE_TABLE_V2 = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NOME + " TEXT, "
            + KEY_FONE + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_FAVORITO + " INTEGER);";

    private static final String CREATE_TABLE_V3 = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NOME + " TEXT, "
            + KEY_FONE + " TEXT, "
            + KEY_EMAIL + " TEXT ,"
            + KEY_FAVORITO + " INTEGER, "
            + KEY_FONE_CONTATO + " TEXT  );" ;

    private static final String CREATE_TABLE_V4 = "CREATE TABLE " + TABLE_NAME + " ("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_NOME + " TEXT, "
            + KEY_FONE + " TEXT, "
            + KEY_EMAIL + " TEXT ,"
            + KEY_FAVORITO + " INTEGER, "
            + KEY_FONE_CONTATO + " TEXT, "
            + KEY_DATA_NASCIMENTO + " TEXT  );" ;


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String createTable = CREATE_TABLE_V1;
            System.out.println("CRIANDO TABELA [ "+ createTable+ " ]" );
            db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        System.out.println("Versao Atual [ "+ oldVersion  + " ]");
        System.out.println("Criando Nova Coluna para Versao [ "+ newVersion  + " ]");

        /*
        if(oldVersion < newVersion) {
            System.out.println("Criando Coluna [ "+KEY_FAVORITO + " ]");
            String sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_FAVORITO + " INTEGER";
            db.execSQL(sql);
        }

        if(oldVersion < newVersion) {
            System.out.println("Criando Coluna [ "+KEY_FONE_CONTATO + " ]");
            String sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_FONE_CONTATO + " TEXT";
            db.execSQL(sql);
        }

        if(oldVersion < newVersion) {
            System.out.println("Criando Coluna [ "+KEY_DATA_NASCIMENTO + " ]");
            String sql = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_DATA_NASCIMENTO + " TEXT";
            db.execSQL(sql);
        }
        */


    }
}

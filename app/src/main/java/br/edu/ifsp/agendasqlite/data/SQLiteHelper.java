package br.edu.ifsp.agendasqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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

    private static final int DATABASE_VERSION = 4;

    private static final String CREATE_TABLE_V1 = "CREATE TABLE " + TABLE_NAME + " ("
                                               + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                               + KEY_NOME + " TEXT, "
                                               + KEY_FONE + " TEXT, "
                                               + KEY_EMAIL + " TEXT );";

    private static final String ALTER_TABLE_V2 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_FAVORITO + " INTEGER";

    private static final String ALTER_TABLE_V3 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_FONE_CONTATO + " TEXT";

    private static final String ALTER_TABLE_V4 = "ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + KEY_DATA_NASCIMENTO + " TEXT";


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(SQLiteHelper.class.getName(),"Start - onCreate");
        Log.d(SQLiteHelper.class.getName(),"CRIANDO TABELA [ "+ CREATE_TABLE_V1+ " ]" );

        db.execSQL(CREATE_TABLE_V1);
        db.execSQL(ALTER_TABLE_V2);
        db.execSQL(ALTER_TABLE_V3);
        db.execSQL(ALTER_TABLE_V4);

        Log.d(SQLiteHelper.class.getName(),"VERSAO BANCO [ "+ db.getVersion()+" ]");
        Log.d(SQLiteHelper.class.getName(),"End - onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(SQLiteHelper.class.getName(),"Start - OnUpgrade");
        Log.d(SQLiteHelper.class.getName(),"Versao Atual [ "+ oldVersion  + " ]");
        Log.d(SQLiteHelper.class.getName(),"Criando Nova Coluna para Versao [ "+ newVersion  + " ]");

        for (int i = oldVersion + 1; i <= newVersion; i++) {
            switch (i) {
                case 2:
                    Log.d(SQLiteHelper.class.getName(),"Criando Coluna [ "+KEY_FAVORITO + " ]");
                    db.execSQL(ALTER_TABLE_V2);
                    break;
                case 3:
                    Log.d(SQLiteHelper.class.getName(),"Criando Coluna [ "+KEY_FONE_CONTATO + " ]");
                    db.execSQL(ALTER_TABLE_V3);
                    break;
                case 4:
                    Log.d(SQLiteHelper.class.getName(),"Criando Coluna [ "+KEY_DATA_NASCIMENTO + " ]");
                    db.execSQL(ALTER_TABLE_V4);
                    break;
            }
        }

        Log.d(SQLiteHelper.class.getName(),"End - OnUpgrade");

    }
}

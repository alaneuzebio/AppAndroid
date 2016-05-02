package br.metodista.nowaitapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;


public class CadastroDB extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Cadastro (" +
                "_id integer primary key autoincrement, " +
                "nome text, " +
                "email text, " +
                "cpf integer, " +
                "senhaCad text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public CadastroDB(Context context) {
        super(context, "Cadastro", null, 1);
    }

    public Cadastro salvarCadastro(Cadastro cadastro) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", cadastro.getNome());
            values.put("email", cadastro.getEmail());
            values.put("cpf", (cadastro.getCpf()));
            values.put("senhaCad", (cadastro.getSenhaCad()));
            if (cadastro.get_id() == null) {
                long id = db.insert("Cadastro", null, values);
                cadastro.set_id(id);

            }else {
                String[] where = new String[]{String.valueOf(cadastro.get_id())};
                db.update("Cadastro", values, "_id = ?", where);
            }
        } finally {
            db.close();
        }
        return cadastro;
    }

    public Cursor consultaCadastro(String login, String senha) throws SQLException {
        Cursor vcursor = null;
        vcursor = this.getReadableDatabase().query("Cadastro", new String[]{"_id", "nome", "email", "cpf", "senhaCad"},
                "email like" + "'"+login+"'" + "and senhaCad like" + "'"+senha+ "'", null, null, null, null);
        return vcursor;
    }
}

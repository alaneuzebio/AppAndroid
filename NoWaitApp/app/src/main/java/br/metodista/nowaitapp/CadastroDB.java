package br.metodista.nowaitapp;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

            } else {
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
                "email like" + "'" + login + "'" + "and senhaCad like" + "'" + senha + "'", null, null, null, null);
        return vcursor;
    }

    public List<Cadastro> consultarUsuario() {
        List<Cadastro> lista = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        try {
            Cursor cursor = db.rawQuery("SELECT _id, nome, email, cpf, senhaCad FROM Cadastro;", null);
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                Cadastro cad = new Cadastro();
                cad.set_id(cursor.getLong(0));
                cad.setNome(cursor.getString(1));
                cad.setEmail(cursor.getString(2));
                cad.setCpf(cursor.getString(3));
                cad.setSenhaCad(cursor.getString(4));
                lista.add(cad);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return lista;
    }
}

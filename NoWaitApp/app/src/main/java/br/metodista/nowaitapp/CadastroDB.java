package br.metodista.nowaitapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CadastroDB extends SQLiteOpenHelper {

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Cadastro (" +
                "_id integer primary key autoincrement, " +
                "nome text, " +
                "email text, " +
                "cpf text, " +
                "cartao text);");
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
            values.put("cartao", (cadastro.getCartao()));
            values.put("senhaCad", (cadastro.getSenhaCad()));
            if (cadastro.get_id() == null) {
                long id = db.insert("Cadastro", null, values);
                cadastro.set_id(id);
            }else {
                String[] where = new String[]{String.valueOf(cadastro.get_id())};
                db.update("Valet", values, "_id = ?", where);
            }
        } finally {
            db.close();
        }
        return cadastro;
    }
}

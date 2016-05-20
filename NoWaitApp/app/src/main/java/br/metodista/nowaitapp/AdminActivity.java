package br.metodista.nowaitapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 19/05/16.
 */
public class AdminActivity extends Activity {

    private ArrayAdapter<String> adapter;
    private List<Cadastro> users = new ArrayList();
    private List<String> usr = new ArrayList();
    private CadastroDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);


        db = new CadastroDB(this);
        users = db.consultarUsuario();
        for (Cadastro c : users) {
            usr.add("ID: " + c.get_id() + "\n" +  "Nome: " + c.getNome() + "\n" + "Email: " + c.getEmail() + "\n" + "CPF: " + c.getCpf() + "\n" + "Senha: " + c.getSenhaCad());
        }
        ListView lista = (ListView) findViewById(R.id.listaAdm);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usr);
        lista.setAdapter(adapter);
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, MainActivity.class));
    }
}

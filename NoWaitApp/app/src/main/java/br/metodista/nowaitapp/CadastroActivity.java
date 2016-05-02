package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by root on 22/03/16.
 */
public class CadastroActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

    }

    public void cadastar(View view) {
        Intent intent = new Intent();
        intent.putExtra("nome", ((EditText) findViewById(R.id.nome)).getText().toString());
        intent.putExtra("email", ((EditText) findViewById(R.id.email)).getText().toString());
        intent.putExtra("cpf", ((EditText) findViewById(R.id.cpf)).getText().toString());
        intent.putExtra("senhaCad", ((EditText) findViewById(R.id.senhaCad)).getText().toString());

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

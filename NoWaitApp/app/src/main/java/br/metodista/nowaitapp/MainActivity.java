package br.metodista.nowaitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {
    private AlertDialog alerta;
    private CadastroDB db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new CadastroDB(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void entrar(View view) {
        EditText login = (EditText) findViewById(R.id.email);
        EditText senha = (EditText) findViewById(R.id.senha);

        try {
            Cursor cursor = db.consultaCadastro
                    (login.getText().toString(), senha.getText().toString());

            if(cursor.getCount() > 0){
                startActivity(new Intent(this, ParceirosActivity.class));
            }else {
                Toast.makeText(this, "Login ou senha inválida!", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /**if ("admin".equals(login.getText().toString()) && "123".equals(senha.getText().toString())) {
            //chamar a tela de tarefas.
            startActivity(new Intent(this, ParceirosActivity.class));
        }else {
            Toast.makeText(this, "Login ou senha inválida!", Toast.LENGTH_SHORT).show();
        }
         **/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Activity.RESULT_OK == resultCode) {
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(data.getStringExtra("nome"));
            cadastro.setEmail(data.getStringExtra("email"));
            cadastro.setCpf(data.getStringExtra("cpf"));
            cadastro.setSenhaCad(data.getStringExtra("senhaCad"));

            db.salvarCadastro(cadastro);
            Toast.makeText(this, "USUARIO CADASTRADO!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cadastroTela(View view) {
        //chamar a tela de restaurantes.
        startActivityForResult(new Intent(this, CadastroActivity.class), 1, null);
    }

    public void esqueci (View view){
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Esqueci Senha");
        //define a mensagem
        builder.setMessage("Senha Enviada para seu E-mail");
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();

    }
}
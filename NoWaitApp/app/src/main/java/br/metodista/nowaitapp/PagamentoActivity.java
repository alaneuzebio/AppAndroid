package br.metodista.nowaitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by root on 04/06/16.
 */
public class PagamentoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagamento);
    }

    public void confirmar_cartao(View view) {
        final Intent home = new Intent(this, RestauranteActivity.class);
        //Toast.makeText(this, "PAGAMENTO CONFIRMADO", Toast.LENGTH_LONG).show();
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("CONFIRMAÇÃO");
        alertDialog.setMessage("PAGAMENTO CONFIRMADO");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // here you can add functions
                dialog.dismiss();
                startActivity(home);
                finish();
            }
        });
        alertDialog.show();
    }
}

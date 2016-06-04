package br.metodista.nowaitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by root on 17/03/16.
 */
public class RestauranteCardapioActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_cardapio);
    }

    public void adicionar1(View view) {
        Toast.makeText(this, "Prato Adicionado", Toast.LENGTH_SHORT).show();
    }

    public void adicionar2(View view) {
        Toast.makeText(this, "Prato Adicionado", Toast.LENGTH_SHORT).show();
    }

    public void adicionar3(View view) {
        Toast.makeText(this, "Prato Adicionado", Toast.LENGTH_SHORT).show();
    }

    public void adicionar4(View view) {
        Toast.makeText(this, "Prato Adicionado", Toast.LENGTH_SHORT).show();
    }

    public void adicionar5(View view) {
        Toast.makeText(this, "Prato Adicionado", Toast.LENGTH_SHORT).show();
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteActivity.class));
    }

    public void finalizar (View view) {
            final Intent maps = new Intent(this, MapsActivity.class);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder.setTitle("CONFIRMAÇÃO PEDIDO");
            builder.setMessage("PEDIDO\n2 Bife Bourguignon R$ 42,40\n2 Salada Campestre R$ 20,00\nTotal    R$62,40");
            //define um botão como positivo
            builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    builder1.setTitle("ADIANTAR PEDIDO");
                    builder1.setMessage("DESEJA ADIANTAR O PEDIDO?");
                    //define um botão como positivo
                    builder1.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CONFIRMADO" , Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            startActivity(maps);
                            finish();
                        }
                    });
                    builder1.setNegativeButton("NAO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CANCELADO" , Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog alerta = builder1.create();
                    alerta.show();

                    //Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CONFIRMADO" , Toast.LENGTH_SHORT).show();
                    //dialog.dismiss();
                    //startActivity(maps);
                    //finish();
                }
            });
            builder.setNegativeButton("VOLTAR", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CANCELADO" , Toast.LENGTH_SHORT).show();
                }
            });
        AlertDialog alerta = builder.create();
        alerta.show();
    }
}

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
            //Cria o gerador do AlertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //define o titulo
            builder.setTitle("CONFIRMAÇÃO PEDIDO");
            //define a mensagem
            builder.setMessage("PEDIDO\n2 Pratos Salada R$ 19,90\n2 Pratos Carne R$ 39,90\nTotal    R$59,80");
            //define um botão como positivo
            builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CONFIRMADO" , Toast.LENGTH_SHORT).show();
                }
            });
            //define um botão como negativo.
            builder.setNegativeButton("VOLTAR", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CANCELADO" , Toast.LENGTH_SHORT).show();
                }
            });
            //cria o AlertDialog
        AlertDialog alerta = builder.create();
            //Exibe
            alerta.show();
    }
}

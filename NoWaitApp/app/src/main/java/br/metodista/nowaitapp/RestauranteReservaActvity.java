package br.metodista.nowaitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by root on 23/03/16.
 */
public class RestauranteReservaActvity extends Activity{

    private List<String> reserva;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_reserva);

        reserva = new ArrayList<String>();

        String [] itens = getResources().getStringArray(R.array.testeteste);
        reserva.addAll(Arrays.asList(itens));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, reserva);

        ListView lista = (ListView) findViewById(R.id.listaReserva);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener((AdapterView.OnItemClickListener) chamaReserva(this));

        final Intent cardapio = new Intent(this, RestauranteCardapioActivity.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder.setTitle("CONFIRMAÇÃO RESERVA");
        builder.setMessage("Você tem uma reserva agendada daqui 1 hora no restaurante Chef. Gostaria de confirmar sua presença?");
        //define um botão como positivo
        builder.setPositiveButton("CONFIRMAR", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                builder1.setTitle("ANTECIPAR PEDIDO");
                builder1.setMessage("Gostaria de antecipar seu pedido?");
                //define um botão como positivo
                builder1.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CONFIRMADO" , Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                        startActivity(cardapio);
                    }
                });
                builder1.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
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
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //Toast.makeText(RestauranteCardapioActivity.this, "PEDIDO CANCELADO", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alerta = builder.create();
        alerta.show();
    }

    public AdapterView.OnItemClickListener chamaReserva(final Context context){
        return (new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        //intent = new Intent(context, RestauranteCardapioActivity.class);
                        //startActivity(intent);
                        break;
                }
            }
        });
    }

}

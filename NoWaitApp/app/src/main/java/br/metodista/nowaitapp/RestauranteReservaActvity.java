package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

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

    }
}

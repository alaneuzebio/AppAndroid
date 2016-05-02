package br.metodista.nowaitapp;

/**
 * Created by root on 14/03/16.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParceirosActivity extends Activity{

    private List<String> tarefas;
    private ArrayAdapter<String> adapter;
    Button btnadiciona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante_selecao);
//        btnadiciona = (Button) findViewById(R.id.adicionar);

        tarefas = new ArrayList<String>();

        String [] itens = getResources().getStringArray(R.array.testes);
        tarefas.addAll(Arrays.asList(itens));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tarefas);


        ListView lista = (ListView) findViewById(R.id.listaTarefas);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener((AdapterView.OnItemClickListener) chamaTarefa(this));

/**        btnadiciona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                adicionarTarefa(lista);
            }
        });**/
    }

    public AdapterView.OnItemClickListener chamaTarefa(final Context context){
            return (new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent;
                    switch (position){
                        case 0:
                            intent = new Intent(context, RestauranteActivity.class);
                            startActivity(intent);
                            break;
                    }
                }
            });
        }

    public void sair (View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}

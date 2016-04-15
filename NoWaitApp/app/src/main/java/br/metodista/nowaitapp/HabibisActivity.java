package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 16/03/16.
 */
public class HabibisActivity extends Activity {

    //Button btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habibis);
    }

    public void cardapio(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, HabibisCardapioActivity.class));
    }

    public void reserva(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, HabibisRevervaActvity.class));
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, ParceirosActivity.class));
    }
}

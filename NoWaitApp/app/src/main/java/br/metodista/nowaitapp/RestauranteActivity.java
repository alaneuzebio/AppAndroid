package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by root on 16/03/16.
 */
public class RestauranteActivity extends Activity {

    //Button btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurante);
    }

    public void sobre(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, SobreChefActvity.class));
    }

    public void cardapio(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteCardapioActivity.class));
    }

    public void reserva(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteRevervaActvity.class));
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, ParceirosActivity.class));
    }
}

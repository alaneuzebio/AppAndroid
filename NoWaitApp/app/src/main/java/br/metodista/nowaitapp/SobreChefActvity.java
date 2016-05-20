package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by root on 02/05/16.
 */
public class SobreChefActvity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre_chef);
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteActivity.class));
    }

    public void cardapio(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteCardapioActivity.class));
    }

    public void contato(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, RestauranteContatoActivity.class));
    }
}

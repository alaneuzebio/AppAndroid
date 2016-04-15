package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by root on 17/03/16.
 */
public class HabibisCardapioActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habibis_cardapio);
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, HabibisActivity.class));
    }
}

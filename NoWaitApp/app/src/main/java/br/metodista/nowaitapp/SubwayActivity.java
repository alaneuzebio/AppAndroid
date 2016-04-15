package br.metodista.nowaitapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by root on 16/03/16.
 */
public class SubwayActivity extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway);
    }

    public void voltar(View view) {
        //chamar a tela de restaurantes.
        startActivity(new Intent(this, ParceirosActivity.class));
    }
}

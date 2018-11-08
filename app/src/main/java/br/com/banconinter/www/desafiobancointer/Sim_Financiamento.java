package br.com.banconinter.www.desafiobancointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sim_Financiamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim__financiamento);
        Intent i = getIntent();
        TextView txt = (TextView)findViewById(R.id.Titulo);

        txt.setText((String)i.getSerializableExtra("nome"));

    }
}

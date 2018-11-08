package br.com.banconinter.www.desafiobancointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Info_Imovel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__imovel_1);

        getSupportActionBar().show();

        Intent i = getIntent();
        final String key = (String) i.getSerializableExtra("cep"); // getSerializableExtra pega as infomações de acordo com o nome

        TextView txt = (TextView)findViewById(R.id.TextoMain);
        txt.setText("CEP:" + key);
    }
    public void Info(String[] msg)
    {

    }
}

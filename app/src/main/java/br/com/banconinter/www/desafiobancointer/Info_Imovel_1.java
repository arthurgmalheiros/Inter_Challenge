package br.com.banconinter.www.desafiobancointer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Info_Imovel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__imovel_1);

<<<<<<< HEAD
        getSupportActionBar().show();

        Intent i = getIntent();
        final String key = (String) i.getSerializableExtra("cep"); // getSerializableExtra pega as infomações de acordo com o nome

        TextView txt = (TextView)findViewById(R.id.TextoMain);
        txt.setText("CEP:" + key);
=======
        final Intent i = getIntent();
        final String key = (String) i.getSerializableExtra("cep"); // getSerializableExtra pega as infomações de acordo com o nome

        TextView txt = (TextView)findViewById(R.id.TextoMain);
        txt.setText(key);

        final Button button = (Button) findViewById(R.id.btn_sim_fin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Sim_Financiamento imv = new Sim_Financiamento();
                Intent itn = new Intent(Info_Imovel_1.this, Sim_Financiamento.class);
                Bundle b = i.getExtras();
                itn.putExtras(b);
                startActivity(itn);
            }
        });

>>>>>>> bf9ce28a9a9d0d45142cfeca0dcb3f3fd206e7d4
    }
    public void Info(String[] msg)
    {

    }
}

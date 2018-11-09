package br.com.banconinter.www.desafiobancointer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Info_Imovel_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info__imovel_1);

        final Intent i = getIntent();

        final String descricao = (String) i.getSerializableExtra("descricao"); // getSerializableExtra pega as infomações de acordo com o nome
        final String nome = (String) i.getSerializableExtra("nome"); // getSerializableExtra pega as infomações de acordo com o nome

        Objects.requireNonNull(getSupportActionBar()).setTitle(nome); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar

        TextView txtDesc = (TextView)findViewById(R.id.Descricao);
        txtDesc.setText(descricao);

        ViewGroup.LayoutParams params = txtDesc.getLayoutParams();
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        txtDesc.setLayoutParams(params);

        final Button button = (Button) findViewById(R.id.btn_sim_fin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Sim_Financiamento imv = new Sim_Financiamento();
                Intent itn = new Intent(Info_Imovel_1.this, Sim_Financiamento.class);
                Bundle b = i.getExtras();
                itn.putExtras(b);
                startActivity(itn);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void Info(String[] msg)
    {

    }
}

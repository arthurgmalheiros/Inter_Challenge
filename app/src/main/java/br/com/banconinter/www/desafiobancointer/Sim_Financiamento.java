package br.com.banconinter.www.desafiobancointer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Objects;

public class Sim_Financiamento extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim__financiamento);
        final Intent i = getIntent();

        final String nome = (String) i.getSerializableExtra("nome");
        final Integer valor = (Integer)i.getSerializableExtra("valor");



        final SeekBar skparc = (SeekBar) findViewById(R.id.sk_Parcelas);
        final Double minCred = valor * 0.3;
        Double maxCred = valor *0.7;
        final SeekBar skmax = (SeekBar) findViewById(R.id.sk_Cred);
        skmax.setMax(maxCred.intValue());



        final TextView jk = (TextView)findViewById(R.id.txt_Cred);
        final Button pf = (Button)findViewById(R.id.txt_ParcFinal);
        final TextView tp = (TextView)findViewById(R.id.txt_Parc);
        jk.setText("R$"+ skmax.getProgress() + "/R$ " +  valor.toString());
        final double ueu = ((valor.intValue() - skmax.getProgress()) /skparc.getProgress()) * 1.0075;
        if (skmax.getProgress() <= minCred)
            skmax.setProgress(minCred.intValue()); jk.setText(skmax.getProgress() + "/" + valor.toString());
        final DecimalFormat format = new DecimalFormat("##.00");
        pf.setText("R$" + format.format(ueu) );
        skparc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= 2)
                    skparc.setProgress(2);
                final double uau = ((valor.intValue() - skmax.getProgress()) /skparc.getProgress()) * 1.0075;;
                tp.setText(Integer.toString(skparc.getProgress()));
                pf.setText("R$" + format.format(uau));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        pf.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent j = new Intent(Intent.ACTION_SEND);
                j.setType("message/rfc822");
                j.putExtra(Intent.EXTRA_EMAIL  , new String[]{"bertod777@gmail.com"});
                j.putExtra(Intent.EXTRA_SUBJECT, "Proposta de Négocios do imovel: " + (String)i.getSerializableExtra("nome"));
                j.putExtra(Intent.EXTRA_TEXT   , "Olá vi seu anuncio com o InterPlace e montei minha proposta de financiamento. Aqui estão os detalhes..." +
                        "Vou pagar " + skmax.getProgress() + " Parcelas de R$" + jk.getText() +
                " Esse valor já é calculado com os juros do Financiamento Banco Inter.");
                try {
                    startActivity(Intent.createChooser(j, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Sim_Financiamento.this  , "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        skmax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //if (progress <= minCred)
                //    skmax.setProgress(minCred.intValue());

                jk.setText("R$"+ skmax.getProgress() + "/R$ " +  valor.toString());
                final double uau =((valor.intValue() - skmax.getProgress()) /skparc.getProgress()) * 1.0075;;


                pf.setText("R$" + format.format(uau) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

}

package br.com.banconinter.www.desafiobancointer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DecimalFormat;
public class Sim_Financiamento extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim__financiamento);
        Intent i = getIntent();

        final Integer valor = (Integer)i.getSerializableExtra("valor");

        final SeekBar skparc = (SeekBar) findViewById(R.id.sk_Parcelas);
        final Double minCred = valor * 0.3;
        Double maxCred = valor *0.7;
        final SeekBar skmax = (SeekBar) findViewById(R.id.sk_Cred);
        skmax.setMax(maxCred.intValue());

        final TextView jk = (TextView)findViewById(R.id.txt_Cred);
        final TextView pf = (TextView)findViewById(R.id.txt_ParcFinal);
        final TextView tp = (TextView)findViewById(R.id.txt_Parc);
        jk.setText(skmax.getProgress() + "/" + valor.toString());
        final double ueu = ((valor.intValue() - skmax.getProgress()) /skparc.getProgress()) * 1.0075;
        final DecimalFormat format = new DecimalFormat("##.00");
        pf.setText("R$" + format.format(ueu) );
        skparc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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

        skmax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress <= minCred)
                    skmax.setProgress(minCred.intValue());
                jk.setText(skmax.getProgress() + "/" + valor.toString());
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



        TextView txt = (TextView)findViewById(R.id.Titulo);
        txt.setText((String)i.getSerializableExtra("nome"));

    }
}

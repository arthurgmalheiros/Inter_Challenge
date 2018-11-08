package br.com.banconinter.www.desafiobancointer;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import javax.xml.datatype.Duration;


public class Second_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second__screen);
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Camera Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() !=  null){
                alert(result.getContents());
            }else{
                alert("Scan cancelado");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void alert(String msg){
        String[] parts = msg.split("λ");
        Log.d("STRING","Gotcha: " + parts[0]);
        if (parts[0].equals("8528"))
        {
            finish();
            Info_Imovel_1 imv = new Info_Imovel_1();
            startActivity(new Intent(Second_Screen.this, imv.getClass()));
            imv.Info(msg);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Não faz parte do serviço",Toast.LENGTH_LONG).show();

            finish();
        }


    }
}

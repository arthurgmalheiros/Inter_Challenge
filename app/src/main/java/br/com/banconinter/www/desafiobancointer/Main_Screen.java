package br.com.banconinter.www.desafiobancointer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__screen);
<<<<<<< HEAD
=======

    final Button button = (Button) findViewById(R.id.button3);
         button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(Main_Screen.this, Second_Screen.class));
        }
    });
>>>>>>> 35f645c8ed01223ee1e58a776d39d27e401ab656
        }
    }


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

    final Button button = (Button) findViewById(R.id.button3);
         button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent myIntent = new Intent(this, .class);
            startActivity(myIntent);
        }
    });
        }
    }


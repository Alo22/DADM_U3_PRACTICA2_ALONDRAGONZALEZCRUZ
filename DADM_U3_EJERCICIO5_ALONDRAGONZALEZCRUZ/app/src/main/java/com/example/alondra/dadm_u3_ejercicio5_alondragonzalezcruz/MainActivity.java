package com.example.alondra.dadm_u3_ejercicio5_alondragonzalezcruz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Lienzo(this));
    }
    public void abrir() {
        Intent sonido = new Intent(MainActivity.this, Main3Activity.class);
        startActivity(sonido);
    }
    public void abrir2(){
        Intent letras=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(letras);
    }
}

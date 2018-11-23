package com.example.alondra.dadm_u3_ejercicio5_alondragonzalezcruz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen2 {
    private Bitmap icono;
    private float x, y;
    private boolean visible;
    private CountDownTimer timer;

    public Imagen2(int resource, float _x, float _y, Lienzo2 l) { //se recibre un 4 parametro de lienzo
        icono = BitmapFactory.decodeResource(l.getResources(), resource);
        x = _x;
        y = _y;
        visible = true;
    } //imagen

    public void pintar(Canvas c, Paint p) {
        if (visible)
            c.drawBitmap(icono, x, y, p);
    }//metodo pintar
    public void mover(float xp, float yp) {
        //donde se esta moviendo el objeto
        x = xp - (icono.getWidth() / 2);
        y = yp - (icono.getHeight() / 2);
    }

    public void hacerVisible(boolean v) {
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp) {
        if (!visible) return false;
        float x2, y2;
        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();
        if (xp>=x && xp<x2){
        if (yp >= y && yp < x2) {
            // validando el valor de las x
            return true;
        }
        } //del toquen
        return false; //retornara verdadero si ambos if son SI
    }
    public boolean colision(Imagen2 objetoB) {
        float x2 = x + icono.getWidth(); //se tiene calculado x2
        float y2 = y + icono.getHeight(); //se tiene calculado el y2
        //metodo si colosiono
        if (objetoB.estaEnArea(x2, y)) {
            //revisando caso 1
            return true;
        }
        if (objetoB.estaEnArea(x, y)) {
            //caso 2
            return true;
        }

        if ((objetoB.estaEnArea(x2, y2))) {
            //REVISANDO CASO 3
            return true;
        }
        if (objetoB.estaEnArea(x, y2)) {
            //caso 4
            return true;
        }
        return false;
    }
}

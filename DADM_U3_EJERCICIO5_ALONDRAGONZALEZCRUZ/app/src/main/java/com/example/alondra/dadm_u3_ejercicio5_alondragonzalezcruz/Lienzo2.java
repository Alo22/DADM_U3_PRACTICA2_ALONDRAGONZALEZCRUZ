package com.example.alondra.dadm_u3_ejercicio5_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Imagen2 letra, letraa, gre, r, az, v, puntero;
   Main2Activity punteroo;
    public Lienzo2(Context context) {
        super(context);
         punteroo=(Main2Activity) context;
        puntero = null;
        r = new Imagen2(R.drawable.r, 50, 40, this);
        az = new Imagen2(R.drawable.az, 50, 350, this);
        v = new Imagen2(R.drawable.v, 50, 650, this);
        letra = new Imagen2(R.drawable.letra, 500, 450, this);
        letraa = new Imagen2(R.drawable.letraa, 500, 130, this);
        gre = new Imagen2(R.drawable.gre, 500, 720, this);
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.CYAN);
        r.pintar(c, p);
        az.pintar(c, p);
        v.pintar(c, p);
        letraa.pintar(c, p);
        letra.pintar(c, p);
        gre.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (letra.estaEnArea(xp, yp)) {
                    puntero = letra; //si es que esta en el area apunta al icono
                }
                if (letraa.estaEnArea(xp, yp)) {
                    puntero = letraa;
                }
                if (gre.estaEnArea(xp, yp)) {
                    puntero = gre;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                //evento de cuando esta en movimiento las letras
                if (puntero != null) {
                    puntero.mover(xp, yp);
                    if (puntero.colision(r) && puntero == letraa) {
                        letraa.hacerVisible(false);
                    }
                    if(puntero.colision(az)&& puntero==letra){
                        letra.hacerVisible(false);
                    }
                    if(puntero.colision(v)&& puntero==gre){
                    gre.hacerVisible(false);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //evento de cuando suelto el objeto(imagen de las letras)
                puntero = null;
                break;
        }
        invalidate();
        return true;
    }
}

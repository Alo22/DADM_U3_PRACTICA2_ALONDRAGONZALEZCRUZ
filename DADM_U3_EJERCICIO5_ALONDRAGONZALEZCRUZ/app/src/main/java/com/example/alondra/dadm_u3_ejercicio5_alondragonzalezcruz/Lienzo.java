package com.example.alondra.dadm_u3_ejercicio5_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {
    Imagen cara, playy, startt;
    MainActivity puntero;

    public Lienzo(Context context) {
        super(context);
        puntero = (MainActivity) context;
        cara = new Imagen(R.drawable.cara, 120, 300, this);
        startt = new Imagen(R.drawable.startt, 100, 750, this);
        playy = new Imagen(R.drawable.playy, 380, 750, this);
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.CYAN);
        p.setColor(Color.YELLOW); //asistente del dibjo es la p
        p.setTextSize(50);
        c.drawText("BIENVENIDO/WELCOME", 80, 100, p);
        c.drawText("COLORES PLAY", 80, 180, p);
        cara.pintar(c, p);
        startt.pintar(c, p);
        playy.pintar(c, p);

    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX(); //tipo flotante
        float yp = e.getY();
        //cuando precionas,arrastras y cuando sueltas
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (startt.estaEnArea(xp, yp)) {
                    puntero.abrir();
                    break;
                }
               if (playy.estaEnArea(xp, yp)) puntero.abrir2();
                break;
        }
        invalidate();
        return true;
    }
}

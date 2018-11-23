package com.example.alondra.dadm_u3_ejercicio5_alondragonzalezcruz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {
    Imagen3 az, bl, g, n, r, v;
    Main3Activity puntero;
    MediaPlayer ma, me, mi, mo, mu, ms;

    public Lienzo3(Context context) {
        super(context);
        puntero = (Main3Activity) context;
        az = new Imagen3(R.drawable.az, 50, 60, this);
        g = new Imagen3(R.drawable.g, 50, 380, this);
        r = new Imagen3(R.drawable.r, 50, 680, this);
        bl = new Imagen3(R.drawable.bl, 350, 60, this);
        n = new Imagen3(R.drawable.n, 351, 382, this);
        v = new Imagen3(R.drawable.v, 353, 678, this);
    }

    @Override
    protected void onDraw(Canvas c) {
        Paint p = new Paint();
        c.drawColor(Color.CYAN);
        az.pintar(c, p);
        g.pintar(c, p);
        r.pintar(c, p);
        bl.pintar(c, p);
        n.pintar(c, p);
        v.pintar(c, p);
    }

    public boolean onTouchEvent(MotionEvent e) {
        float xp = e.getX();
        float yp = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (bl.estaEnArea(xp, yp)) {
                    mu = MediaPlayer.create(puntero, R.raw.white);
                    mu.start();
                }
                if (az.estaEnArea(xp, yp)) {
                    ma = MediaPlayer.create(puntero, R.raw.blue);
                    ma.start();
                }
                if (r.estaEnArea(xp, yp)) {
                    mo = MediaPlayer.create(puntero, R.raw.red);
                }
                if (v.estaEnArea(xp, yp)) {
                    mi = MediaPlayer.create(puntero, R.raw.green);
                }
                if (g.estaEnArea(xp, yp)) {
                    me = MediaPlayer.create(puntero, R.raw.gray);
                }
                if (n.estaEnArea(xp, yp)) {
                    ms = MediaPlayer.create(puntero, R.raw.black);
                }
                break;
            case MotionEvent.ACTION_MOVE://evento cuando mueves
                break;
            case MotionEvent.ACTION_UP:
                // puntero = null;
                break;
        }
        invalidate();
        return true;
    }
}

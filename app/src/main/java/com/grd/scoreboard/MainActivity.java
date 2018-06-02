package com.grd.scoreboard;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends Activity {
    private TextView score1,score2;
    private Button tripoina,twopoina,onea,tripoinb,twopoinb,oneb,btnreset;
    int poin1=0,poin2=0;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score1 = (TextView)findViewById(R.id.scorea);
        score2 = (TextView)findViewById(R.id.scoreb);
        tripoina = (Button)findViewById(R.id.tigapoina);
        twopoina = (Button)findViewById(R.id.duapoina);
        onea = (Button)findViewById(R.id.freea);
        tripoinb = (Button)findViewById(R.id.tigapoinb);
        twopoinb = (Button)findViewById(R.id.duapoinb);
        oneb = (Button)findViewById(R.id.freeb);
        btnreset = (Button)findViewById(R.id.reset);

        tripoina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin1=poin1+3; tampil(poin1);
            }
        });

        twopoina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin1=poin1+2; tampil(poin1);
            }
        });

        onea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin1=poin1+1; tampil(poin1);
            }
        });

        tripoinb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin2=poin2+3; tampil2(poin2);
                }
        });

        twopoinb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin2=poin2+2; tampil2(poin2);
                }
        });

        oneb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin2=poin2+1; tampil2(poin2);
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                poin1=0;
                poin2=0;
                score1.setText(String.valueOf(poin1));
                score2.setText(String.valueOf(poin2));
            }
        });
    }
    public void tampil (int poin1){
        score1.setText(String.valueOf(poin1));
    }
    public void tampil2 (int poin2) {
        score2.setText(String.valueOf(poin2));
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}

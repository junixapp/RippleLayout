package com.lxj.wavelayoutdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lxj.ripplelayout.RippleLayout;

public class MainActivity extends AppCompatActivity {

    private RippleLayout ripple1,ripple2,ripple3,ripple4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ripple1 = (RippleLayout) findViewById(R.id.wave1);
        ripple2 = (RippleLayout) findViewById(R.id.wave2);
        ripple3 = (RippleLayout) findViewById(R.id.wave3);
        ripple4 = (RippleLayout) findViewById(R.id.wave4);

        ripple1.setRippleColor(Color.CYAN);
        ripple1.setRippleInternal(6000);


        ripple2.setRippleColor(Color.RED);
        ripple2.setRippleInternal(5000);
        ripple2.setRippleCenter(100,200);
        ripple2.setEndRadius(300);

        ripple3.setRippleColor(Color.BLUE);
        ripple3.setRippleCenter(500,200);
        ripple3.setEndRadius(200);

        ripple4.setRippleColor(Color.MAGENTA);
        ripple4.setRippleCenter(500,700);
        ripple4.setEndRadius(500);

        ripple1.startRipple();
        ripple2.startRipple();
        ripple3.startRipple();
        ripple4.startRipple();
    }

}

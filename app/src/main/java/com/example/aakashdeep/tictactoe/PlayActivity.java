package com.example.aakashdeep.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    int user=0;//0= player 1 and 1=player 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //button onclick code
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
/*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity

            }
        });  */

       // public void onClick(View v) {
            //starts playactivity


        //}

        //android:onClick="buttonClick"


/*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
b1.setText("X");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b2.setText("X");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b3.setText("X");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b4.setText("X");
            }
        });



        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b5.setText("X");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b6.setText("X");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b7.setText("X");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b8.setText("X");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                b9.setText("X");
            }
        });

        */
        Bundle bundle = getIntent().getExtras();
        String user1 = bundle.getString("user1");
        String user2= bundle.getString("user2");
        System.out.print("user1");
       // b1.setText(message);
       // b2.setText(message1);
        //System.out.print(message);

    }
    public void buttonClick(View v) {
        //starts playactivity
        //Log.d("hhhhhhh", "hdbbbd+" + v.findViewById());


//b1.setText(v.getId().toString());

    }
}

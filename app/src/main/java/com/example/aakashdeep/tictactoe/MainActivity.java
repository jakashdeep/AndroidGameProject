package com.example.aakashdeep.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        final Intent i= new Intent(this,NameActivity.class);
        System.out.print("message dfsdfsdfsdfd");
        Timer timer= new Timer();
        timer.schedule(
                new TimerTask() {

                    public void run() {


                        startActivity(i);

                    }

                }, 3000);
    }
}

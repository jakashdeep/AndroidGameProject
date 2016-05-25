package com.example.aakashdeep.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

/**Class to display the welcome screen to the users
 * @author team9
 * @version deliverable 2
 * @since 15-05-2016
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        final Intent i= new Intent(this,NameActivity.class);

        Timer timer= new Timer();
        timer.schedule(
                new TimerTask() {

                    public void run() {


                        startActivity(i);

                    }

                }, 3000);
    }
}

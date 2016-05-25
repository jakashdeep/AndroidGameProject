package com.example.aakashdeep.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Map;


/**
 * @author Aakashdeep
 * @version deliverable 2
 * @since 15-5-2016
 */
public class Score extends AppCompatActivity {

    /**
     * Primary method that creates the activity as well as print the contain of database on the textview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        SharedPreferences sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);
        TextView t1=(TextView)findViewById(R.id.textView9);

        Map<String, ?> allEntries = sharedpre.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            //Display score
            t1.append(entry.getKey() + "     " + entry.getValue().toString() + "\n");

        }

    }
}

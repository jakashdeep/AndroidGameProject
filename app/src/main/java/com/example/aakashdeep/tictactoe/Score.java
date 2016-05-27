package com.example.aakashdeep.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;


/**
 * @author Aakashdeep
 * @version deliverable 2
 * @since 15-5-2016
 */
public class Score extends AppCompatActivity {
    SharedPreferences sharedpre;
    Button b1;
    TextView t1;
    /**
     * Primary method that creates the activity as well as print the contain of database on the textview
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);
        t1=(TextView)findViewById(R.id.textView9);
        b1 = (Button) findViewById(R.id.button18);

       show();

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);
                Clear();

            }
        });

    }
    private void Clear()
    {
        SharedPreferences.Editor editor= sharedpre.edit();
        editor.clear();
        editor.commit();
        //show();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void show()
    {
        Map<String, ?> allEntries = sharedpre.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            //Display score
            t1.append(entry.getKey() + "     " + entry.getValue().toString() + "\n");

        }
    }
}

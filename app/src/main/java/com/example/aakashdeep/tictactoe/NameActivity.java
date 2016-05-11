package com.example.aakashdeep.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);



        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);


        final Intent i= new Intent(NameActivity.this,PlayActivity.class);

        b1 = (Button) findViewById(R.id.button10);
        
        //Listener for button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity

                i.putExtra("user1",et1.getText().toString());
                i.putExtra("user2",et2.getText().toString());
                startActivity(i);
            }
        });






    }


}

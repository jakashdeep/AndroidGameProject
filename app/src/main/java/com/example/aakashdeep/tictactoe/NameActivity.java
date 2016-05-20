package com.example.aakashdeep.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button b1;
    Button b2;
    Spinner dropdown;
    SharedPreferences sharedpre;
    String player1;
    String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);



        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"X", "Y"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        final Intent i= new Intent(NameActivity.this,PlayActivity.class);

        b1 = (Button) findViewById(R.id.button10);
        b2 = (Button) findViewById(R.id.button11);
       // System.out.print("Valueeeeeeee" + );


        //Listener for button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                player1=et1.getText().toString();
                SearchName();
                i.putExtra("user1",et1.getText().toString());
                i.putExtra("user2",et2.getText().toString());
                i.putExtra("selection",DropDownCheck());
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Exit the Game
                AppExit();

            }
        });


    }

    public void AppExit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }

    private String DropDownCheck(){
        return String.valueOf(dropdown.getSelectedItem());
    }

    private void SearchName()
    {
        sharedpre=getSharedPreferences("MyData", Context.MODE_PRIVATE);

        String temp=sharedpre.getString("Name",null);
        Log.d("hhhhhhh", "2");
        //String score=sharedpre.getInt("Score",null);
        Log.d("hhhhhhh", "3");

        if(temp!=null)
        {
            Log.d("hhhhhhh", "2"+player1);
            String name=sharedpre.getString("Name",player1);
            Log.d("hhhhhhh", "2"+name);
            Toast.makeText(this, "Data Was found", Toast.LENGTH_LONG).show();
            //scoreUpdate();
        }
        else
        {
            Toast.makeText(this,"No Data Was found",Toast.LENGTH_LONG).show();

        }
    }

}


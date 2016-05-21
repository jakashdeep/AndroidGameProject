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
    Button b3;
    Button b4;
    Spinner dropdown;
    SharedPreferences sharedpre;
    String player1;
    String player2;
    SharedPreferences.Editor editor;
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
        b3 = (Button) findViewById(R.id.button12);
        b4 = (Button) findViewById(R.id.button13);
       // System.out.print("Valueeeeeeee" + );

     /*sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedpre.edit();
       editor.clear();
       editor.commit();*/

       // Listener for button

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
                player1=et1.getText().toString();
                Log.d("Player1", "value"+player1);
                player2=et2.getText().toString();
                Log.d("Player2", "value" + player2);
                //SearchName();
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

        final Intent a= new Intent(NameActivity.this,About.class);
        //For about activity calling
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(a);
            }
        });


        final Intent s= new Intent(NameActivity.this,Score.class);
        //For about score board activity calling
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(s);
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
        Log.d("In Search Name", "--");
        sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);

        //String temp=sharedpre.getString("Name",null);
        Log.d(" sharedpre", "2");
        //String score=sharedpre.getInt("Score",null);
if (sharedpre.contains("akash")){
    Toast.makeText(this, "Akash Was found", Toast.LENGTH_LONG).show();
}
        if (sharedpre.contains("comp")){
            Toast.makeText(this, "comp Was found", Toast.LENGTH_LONG).show();
        }


/*
        if(sharedpre.contains("Name"))
        {
            Log.d("in  ", "if");
            Log.d("player1", "2"+player1);
            String name=sharedpre.getString("Name",player1);
            Log.d("name", "2"+name);
            Toast.makeText(this, "Data Was found", Toast.LENGTH_LONG).show();
            //scoreUpdate();
        }
        else
        {
            editor= sharedpre.edit();
            Log.d("in  ", "else");
            Toast.makeText(this,"No Data Was found",Toast.LENGTH_LONG).show();
            //editor.putString(player1, player1);
            editor.putInt(player1, 0);
            //editor.putString("Name1", player2);
            editor.putInt(player2,0);
            //FirstEntry(player1);
           // FirstEntry(player2);
            editor.commit();
        }*/
    }

    private void FirstEntry(String temp1)
    {
        Log.d("in  ", "firstentry");

       // editor.clear();
        Log.d("in  ", "temp1 value"+temp1);
        editor.putString("Name",temp1);
        editor.putInt("Score",0);


    }

}


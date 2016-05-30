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


/**The class takes Players name, symbol selection as well as the button click from user and submit
 * the data to the PlayActivity
 * @author Aakashdeep
 * @version deliverable 2
 * @since 15-05-2016
 */
public class NameActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Spinner dropdown;
    SharedPreferences sharedpre;
    String player1;
    String player2;
    SharedPreferences.Editor editor;
    public static int plays=1;

    Intent i;

    /**
     * It has the onclick listeners for the buttons and paramater passing to the playactivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);



        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        dropdown = (Spinner)findViewById(R.id.spinner);
        String[] items = new String[]{"X", "O"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        final Intent i= new Intent(NameActivity.this,PlayActivity.class);

        b1 = (Button) findViewById(R.id.button10);
        b2 = (Button) findViewById(R.id.button11);
        b3 = (Button) findViewById(R.id.button12);
        b4 = (Button) findViewById(R.id.button13);
        b5 = (Button) findViewById(R.id.button14);
        b6 = (Button) findViewById(R.id.button15);




       // Listener for buttons

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //starts playactivity
               plays=1;
                player1=et1.getText().toString();

                player2=et2.getText().toString();


                i.putExtra("user1",et1.getText().toString());
                i.putExtra("user2",et2.getText().toString());
                i.putExtra("selection",DropDownCheck());
                i.putExtra("plays",plays);

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

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                plays=3;
                player1=et1.getText().toString();
                Log.d("Player1", "value"+player1);
                player2=et2.getText().toString();
                Log.d("Player2", "value" + player2);
                i.putExtra("user1",et1.getText().toString());
                i.putExtra("user2",et2.getText().toString());
                i.putExtra("selection",DropDownCheck());
                i.putExtra("plays",plays);
                startActivity(i);


            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                player1=et1.getText().toString();
                Log.d("Player1", "value"+player1);
                player2=et2.getText().toString();
                Log.d("Player2", "value" + player2);
                i.putExtra("user1",et1.getText().toString());
                i.putExtra("user2",et2.getText().toString());
                i.putExtra("selection",DropDownCheck());
                plays=5;
                i.putExtra("plays",plays);
                startActivity(i);


            }
        });

    }

    /**
     * Function to exit the application
     */
    public void AppExit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }

    /**
     * Check the dropdown selection
     * @return the selected dropdown item
     */
    private String DropDownCheck(){
        return String.valueOf(dropdown.getSelectedItem());
    }



    /*private void FirstEntry(String temp1)
    {
        Log.d("in  ", "firstentry");

       // editor.clear();
        Log.d("in  ", "temp1 value"+temp1);
        editor.putString("Name",temp1);
        editor.putInt("Score",0);


    }*/

}


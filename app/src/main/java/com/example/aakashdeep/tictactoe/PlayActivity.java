package com.example.aakashdeep.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView t1;
    //Player Name Text field
    TextView t2;
    TextView t3;

    int user=0;//0= player 1 and 1=player 2
    int counter=0;//For number of moves
    int playerMove1=0;
    int playerMoves2=0;
    String user1;
    String user2;
    String select;

    String Player1;
    String Player2;

    public static final String DEFAULT = "N/A";

    //Button b[][];

    int r11=0,r12=0,r13=0,r21=0,r22=0,r23=0,r31=0,r32=0,r33=0;//X=1 and O=2

    SharedPreferences sharedpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Alert Dialog Box
       // AlertDialog.Builder Popup  = new AlertDialog.Builder(this);
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



        t1=(TextView)findViewById(R.id.textView3);
        t2=(TextView)findViewById(R.id.textView4);
        t3=(TextView)findViewById(R.id.textView5);

        //For storing the Score
        sharedpre=getSharedPreferences("MyData", Context.MODE_PRIVATE);



        Bundle bundle = getIntent().getExtras();
        user1 = bundle.getString("user1");
        user2= bundle.getString("user2");
        Player1=user1;
        Player2=user2;
        select=bundle.getString("selection");
        user1=user1+" "+select;
        if(select.equals("X"))
            user2=user2+" "+"Y";
        else
            user2=user2+" "+"X";


        Log.d("hhhhhhh", "hdbbbd+" + select);
        t2.setText(user1);
        t3.setText(user2);

        searchData();
        //System.out.print("user1");
       // b1.setText(message);
       // b2.setText(message1);
        //System.out.print(message);

    }

    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(user==0){
                    b1.setText("X");
                    //b1.setEnabled(false);
                    t1.setText(user2+" turn");
                    r11=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b1.setEnabled(false);
                    user++;
                    counter++;

                }
                else{
                    b1.setText("O");
                    t1.setText(user1+" turn");
                    r11=2;
                    winConditionChecker();
                   //drawConditionChecker();
                    b1.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button2:
                // do something else
                if(user==0){
                    b2.setText("X");
                    t1.setText(user2+" turn");
                    r12=1;
                    winConditionChecker();
                   //drawConditionChecker();
                    b2.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b2.setText("O");
                    t1.setText(user1+" turn");
                    r12=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b2.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button3:
                if(user==0){
                    b3.setText("X");
                    t1.setText(user2+" turn");
                    r13=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b3.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b3.setText("O");
                    t1.setText(user1+" turn");
                    r13=2;
                    winConditionChecker();
                   // drawConditionChecker();
                    b3.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button4:
                if(user==0){
                    b4.setText("X");
                    t1.setText(user2+" turn");
                    r21=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b4.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b4.setText("O");
                    t1.setText(user1+" turn");
                    user--;
                    winConditionChecker();
                    //drawConditionChecker();
                    b4.setEnabled(false);
                    r21=2;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button5:
                if(user==0){
                    b5.setText("X");
                    t1.setText(user2+" turn");
                    r22=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b5.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b5.setText("O");
                    t1.setText(user1+" turn");
                    r22=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b5.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button6:
                if(user==0){
                    b6.setText("X");
                    t1.setText(user2+" turn");
                    r23=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b6.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b6.setText("O");
                    t1.setText(user1+" turn");
                    r23=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b6.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button7:
                if(user==0){
                    b7.setText("X");
                    t1.setText(user2+" turn");
                    r31=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b7.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b7.setText("O");
                    t1.setText(user1+" turn");
                    r31=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b7.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button8:
                if(user==0){
                    b8.setText("X");
                    t1.setText(user2+" turn");
                    r32=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b8.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b8.setText("O");
                    t1.setText(user1+" turn");
                    r32=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b8.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
            case R.id.button9:
                if(user==0){
                    b9.setText("X");
                    t1.setText(user2+" turn");
                    r33=1;
                    winConditionChecker();
                    //drawConditionChecker();
                    b9.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b9.setText("O");
                    t1.setText(user1+" turn");
                    r33=2;
                    winConditionChecker();
                    //drawConditionChecker();
                    b9.setEnabled(false);
                    user--;
                    counter++;
                }
                //
                if (counter==9)
                    drawConditionChecker();
                break;
        }
    }


    private void winConditionChecker(){

        //Condition for player one win
        //Horizontal Row Checker
        if((r11==1 & r12==1 & r13==1) || (r11==2 & r12==2 & r13==2) )
        {
         b1.setBackgroundColor(0x66ccff00);
            b2.setBackgroundColor(0x66ccff00);
            b3.setBackgroundColor(0x66ccff00);
            ButtonDisabler();

            if(r11==1)
                playerWin1();
                else
                playerWin2();

        }
        if ((r21==1 & r22==1 & r23==1) || (r21==2 & r22==2 & r23==2))
        {
            b4.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b6.setBackgroundColor(0x66ccff00);
            ButtonDisabler();

            if(r21==1)
                playerWin1();
            else
                playerWin2();
        }
        if ((r31==1 & r32==1 & r33==1)||(r31==2 & r32==2 & r33==2) )
        {
            b7.setBackgroundColor(0x66ccff00);
            b8.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
            ButtonDisabler();

            if(r31==1)
                playerWin1();
            else
                playerWin2();
        }
        //Diagonal Checker
        if((r11==1 & r21==1 & r31==1) || (r11==2 & r21==2 & r31==2) )
        {
            b1.setBackgroundColor(0x66ccff00);
            b4.setBackgroundColor(0x66ccff00);
            b7.setBackgroundColor(0x66ccff00);
            ButtonDisabler();

            if(r11==1)
                playerWin1();
            else
                playerWin2();
        }
        if((r13==1 & r23==1 & r33==1) || (r13==2 & r23==2 & r33==2) )
        {
            b3.setBackgroundColor(0x66ccff00);
            b6.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
            ButtonDisabler();
            if(r13==1)
                playerWin1();
            else
                playerWin2();
        }

        if((r12==1 & r22==1 & r32==1) || (r12==2 & r22==2 & r32==2) )
        {
            b2.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b8.setBackgroundColor(0x66ccff00);
            ButtonDisabler();
            if(r12==1)
                playerWin1();
            else
                playerWin2();
        }

        if((r11==1 & r22==1 & r33==1) || (r11==2 & r22==2 & r33==2))
        {
            b1.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
            ButtonDisabler();
            if(r11==1)
                playerWin1();
            else
                playerWin2();
        }
        if((r13==1 & r22==1 & r31==1) || (r13==2 & r22==2 & r31==2) )
        {
            b3.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b7.setBackgroundColor(0x66ccff00);
            ButtonDisabler();
            if(r13==1)
                playerWin1();
            else
                playerWin2();
        }

    }

    private void drawConditionChecker()
    {
      if(r11!=0 & r12!=0 & r13!=0 & r21!=0 & r22!=0 & r23!=0 & r31!=0 & r32!=0 & r33!=0)
      {
       t1.setText("Draw!");

      }
    }

    private void Reset()
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");

       /* for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                r[i][j]=0;
            }
        }*/

        r11=0;r12=0;r13=0;r21=0;r22=0;r23=0;r31=0;r32=0;r33=0;
        counter=0;
    }

    private void ButtonDisabler(){
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }

    private void playerWin1(){
        t1.setText("Winner is "+user1);
    }
    private void playerWin2(){
        t1.setText("Winner is "+user2);
    }

    private void searchData()
    {
        Log.d("hhhhhhh", "1");
        String name=sharedpre.getString("Name",null);
        Log.d("hhhhhhh", "2");
        //String score=sharedpre.getInt("Score",null);
        Log.d("hhhhhhh", "3");

        if(name!=null)
        {
            Toast.makeText(this,"No Data Was found",Toast.LENGTH_LONG).show();
            scoreUpdate();
        }
        else
        {
            Toast.makeText(this,"Data Was found",Toast.LENGTH_LONG).show();

        }
    }

    private void scoreUpdate()
    {

        SharedPreferences.Editor editor= sharedpre.edit();
        editor.putString("Name",Player1);
        editor.putInt("Score", 0);

        editor.putString("Name",Player2);
        editor.putInt("Score",0);
        editor.commit();
    }
}

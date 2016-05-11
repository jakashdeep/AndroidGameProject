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
    int counter=0;//For number of moves
    int playerMove1=0;
    int playerMoves2=0;

    int r11=0,r12=0,r13=0,r21=0,r22=0,r23=0,r31=0,r32=0,r33=0;//X=1 and O=2



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




        Bundle bundle = getIntent().getExtras();
        String user1 = bundle.getString("user1");
        String user2= bundle.getString("user2");
        //System.out.print("user1");
       // b1.setText(message);
       // b2.setText(message1);
        //System.out.print(message);

    }
   // public void buttonClick(View v) {
        //starts playactivity
        //Log.d("hhhhhhh", "hdbbbd+" + v.findViewById());


//b1.setText(v.getId().toString());

  //  }

    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(user==0){
                    b1.setText("X");
                    r11=1;
                    winConditionChecker();
                    user++;

                }
                else{
                    b1.setText("O");
                    r11=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button2:
                // do something else
                if(user==0){
                    b2.setText("X");
                    r12=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b2.setText("O");
                    r12=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button3:
                if(user==0){
                    b3.setText("X");
                    r13=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b3.setText("O");
                    r13=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button4:
                if(user==0){
                    b4.setText("X");
                    r21=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b4.setText("O");
                    user--;
                    winConditionChecker();
                    r21=2;
                }
                break;
            case R.id.button5:
                if(user==0){
                    b5.setText("X");
                    r22=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b5.setText("O");
                    r22=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button6:
                if(user==0){
                    b6.setText("X");
                    r23=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b6.setText("O");
                    r23=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button7:
                if(user==0){
                    b7.setText("X");
                    r31=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b7.setText("O");
                    r31=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button8:
                if(user==0){
                    b8.setText("X");
                    r32=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b8.setText("O");
                    r32=2;
                    winConditionChecker();
                    user--;
                }
                break;
            case R.id.button9:
                if(user==0){
                    b9.setText("X");
                    r33=1;
                    winConditionChecker();
                    user++;
                }
                else{
                    b9.setText("O");
                    r33=2;
                    winConditionChecker();
                    user--;
                }
                break;
        }
    }

    private void winConditionChecker(){

        //Condition for player one win
        if((r11==1 & r12==1 & r13==1) || (r11==2 & r12==2 & r13==2) )
        {
         b1.setBackgroundColor(0x66ccff00);
            b2.setBackgroundColor(0x66ccff00);
            b3.setBackgroundColor(0x66ccff00);
        }
        if ((r21==1 & r22==1 & r23==1) || (r21==2 & r22==2 & r23==2))
        {
            b4.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b6.setBackgroundColor(0x66ccff00);
        }
        if ((r31==1 & r32==1 & r33==1)||(r31==2 & r32==2 & r33==2) )
        {
            b7.setBackgroundColor(0x66ccff00);
            b8.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
        }
        if((r11==1 & r21==1 & r31==1) || (r11==2 & r21==2 & r31==2) )
        {
            b1.setBackgroundColor(0x66ccff00);
            b4.setBackgroundColor(0x66ccff00);
            b7.setBackgroundColor(0x66ccff00);
        }
        if((r12==1 & r22==1 & r32==1) || (r12==2 & r22==2 & r32==2) )
        {
            b2.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b8.setBackgroundColor(0x66ccff00);
        }
        if((r13==1 & r23==1 & r33==1) || (r13==2 & r23==2 & r33==2) )
        {
            b3.setBackgroundColor(0x66ccff00);
            b6.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
        }
        if((r11==1 & r22==1 & r33==1) || (r11==2 & r22==2 & r33==2))
        {
            b1.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b9.setBackgroundColor(0x66ccff00);
        }
        if((r13==1 & r22==1 & r31==1) && (r13==2 & r22==2 & r31==2) )
        {
            b3.setBackgroundColor(0x66ccff00);
            b5.setBackgroundColor(0x66ccff00);
            b7.setBackgroundColor(0x66ccff00);
        }

    }

    private void drawConditionChecker()
    {

    }
}

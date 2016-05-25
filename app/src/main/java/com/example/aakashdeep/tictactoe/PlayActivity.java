package com.example.aakashdeep.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.*;

/**The class implements gameplay of the tic-tac-toe game between 2 players
 * @author team 9
 * @version Deliverable 2
 * @since
 */
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
    TextView t4;
    TextView t5;
    boolean flag =false;
    int user=0;//0= player 1 and 1=player 2
    int counter=0;//For number of moves
    int playerMove1=0;
    int playerMoves2=0;
    String user1;
    String user2;
    String select;
    int no_of_plays=0;
    String Player1;
    String Player2;

    int scorePlayer1;
    int scorePlayer2;
boolean flag2 = true;
    String winner = null;

    //Symbols to store the symbols X and O
    String symbol1;
    String symbol2;

    public static final String DEFAULT = "N/A";

    //Button b[][];

    int r11=0,r12=0,r13=0,r21=0,r22=0,r23=0,r31=0,r32=0,r33=0;//X=1 and O=2

    SharedPreferences sharedpre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
Log.d("In Play Activity","XXXXXXX");
       /* if(flag2){
        no_of_plays = NameActivity.plays ;
        flag2 =false;
       }*/

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
        t4=(TextView)findViewById(R.id.textView6);
        t5=(TextView)findViewById(R.id.textView7);
        //SharedPreferences declaration
        sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);

        ButtonBackground();
        //For getting Data from NameActivity
        Bundle bundle = getIntent().getExtras();
        Log.d("Before","User1");
        user1 = bundle.getString("user1");
        user2= bundle.getString("user2");
        Player1=user1;
        Player2=user2;
        select=bundle.getString("selection");
        Log.d("before ", "no_of_plays");
        no_of_plays=bundle.getInt("plays");
        Log.d("no_of_plays", "no_of_plays" + no_of_plays);
       // no_of_plays=1;
        user1=user1+" "+select;
        if(select.equals("X")){
            user2=user2+" "+"O";
            symbol1="X";
            symbol2="O";
        }
        else{
            user2=user2+" "+"X";
            symbol2="X";
            symbol1="O";
        }


        Log.d("hhhhhhh", "hdbbbd+" + select);
        t2.setText(user1);
        t3.setText(user2);
        Log.d("Before Search Data", "call");
        searchData();
        //System.out.print("user1");
       // b1.setText(message);
       // b2.setText(message1);
        //System.out.print(message);

    }

    /**
     *
     * @param v
     */
    public void buttonClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if(user==0){
                    b1.setText(symbol1);
                    //b1.setEnabled(false);
                    t1.setText(user2+" turn");
                    r11=1;
                  flag=  winConditionChecker();
                    //drawConditionChecker();
                    b1.setEnabled(false);
                    user++;
                    counter++;
                    Log.d("checking","Button 1");

                }
                else{
                    b1.setText(symbol2);
                    t1.setText(user1+" turn");
                    r11=2;
                    flag=  winConditionChecker();
                   //drawConditionChecker();
                    b1.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button2:
                // do something else
                if(user==0){
                    b2.setText(symbol1);
                    t1.setText(user2+" turn");
                    r12=1;
                    flag=  winConditionChecker();
                   //drawConditionChecker();
                    b2.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b2.setText(symbol2);
                    t1.setText(user1+" turn");
                    r12=2;
                    flag=  winConditionChecker();
                    //drawConditionChecker();
                    b2.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button3:
                if(user==0){
                    b3.setText(symbol1);
                    t1.setText(user2+" turn");
                    r13=1;
                    flag=    winConditionChecker();
                    //drawConditionChecker();
                    b3.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b3.setText(symbol2);
                    t1.setText(user1+" turn");
                    r13=2;
                    flag=  winConditionChecker();
                   // drawConditionChecker();
                    b3.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button4:
                if(user==0){
                    b4.setText(symbol1);
                    t1.setText(user2+" turn");
                    r21=1;
                    flag=  winConditionChecker();
                    //drawConditionChecker();
                    b4.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b4.setText(symbol2);
                    t1.setText(user1+" turn");
                    user--;
                    flag= winConditionChecker();
                    //drawConditionChecker();
                    b4.setEnabled(false);
                    r21=2;
                    counter++;
                }
                //

                break;
            case R.id.button5:
                if(user==0){
                    b5.setText(symbol1);
                    t1.setText(user2+" turn");
                    r22=1;
                    flag=  winConditionChecker();
                    //drawConditionChecker();
                    b5.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b5.setText(symbol2);
                    t1.setText(user1+" turn");
                    r22=2;
                    flag=  winConditionChecker();
                    //drawConditionChecker();
                    b5.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button6:
                if(user==0){
                    b6.setText(symbol1);
                    t1.setText(user2+" turn");
                    r23=1;
                   flag =  winConditionChecker();
                    //drawConditionChecker();
                    b6.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b6.setText(symbol2);
                    t1.setText(user1+" turn");
                    r23=2;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b6.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button7:
                if(user==0){
                    b7.setText(symbol1);
                    t1.setText(user2+" turn");
                    r31=1;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b7.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b7.setText(symbol2);
                    t1.setText(user1+" turn");
                    r31=2;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b7.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button8:
                if(user==0){
                    b8.setText(symbol1);
                    t1.setText(user2+" turn");
                    r32=1;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b8.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b8.setText(symbol2);
                    t1.setText(user1+" turn");
                    r32=2;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b8.setEnabled(false);
                    user--;
                    counter++;
                }
                //

                break;
            case R.id.button9:
                if(user==0){
                    b9.setText(symbol1);
                    t1.setText(user2+" turn");
                    r33=1;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b9.setEnabled(false);
                    user++;
                    counter++;
                }
                else{
                    b9.setText(symbol2);
                    t1.setText(user1+" turn");
                    r33=2;
                    flag = winConditionChecker();
                    //drawConditionChecker();
                    b9.setEnabled(false);
                    user--;
                    counter++;
                }

                break;
        }

        if(flag)
        {
            if(no_of_plays>=2){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Alert");
                alert.setMessage("Player Won"+winner+"\n"+"New Game Starts");
                alert.setPositiveButton("OK",null);
                alert.show();
                no_of_plays--;
                Reset();

            }

            return;
        }
        if(counter>=9)
        {


            t1.setText("Game is drawn");
            t1.setBackgroundColor(0x66ccff00);
            Log.d("Game is drawn", "---");



            if(no_of_plays>=2){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Alert");
                alert.setMessage("Game is Draw" + "\n" + "New Game Starts");
                alert.setPositiveButton("OK", null);
                alert.show();

                no_of_plays--;
                Reset();

            }



        }
    }

    /**
     * Check the win condition as well as graphically represent the winners row or column by coloring it
     * @return Returns the boolean variable which states that the winning condition has already occurred
     */
    private boolean winConditionChecker(){

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
            return true;

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
            return true;


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
            return true;

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
            return true;

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
            return true;

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
            return true;

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
            return true;

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
            return true;

        }
        return false;

    }

    /**
     * Reset the board and resets all the variables associate with the game play
     */
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
        ButtonEnabler();
        ButtonBackground();
        t1.setText("");
        if(no_of_plays <=1)
        {


        }

        r11=0;r12=0;r13=0;r21=0;r22=0;r23=0;r31=0;r32=0;r33=0;
        counter=0;
    }

    /**
     * Function to disable all the buttons
     */
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

    /**
     * Function to enable all the buttons
     */
    private void ButtonEnabler()
    {

        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
    }

    /**
     * Change the button background
     */
    private void ButtonBackground()
    {

        b1.setBackgroundResource(android.R.drawable.btn_default);
        b2.setBackgroundResource(android.R.drawable.btn_default);
        b3.setBackgroundResource(android.R.drawable.btn_default);
        b4.setBackgroundResource(android.R.drawable.btn_default);
        b5.setBackgroundResource(android.R.drawable.btn_default);
        b6.setBackgroundResource(android.R.drawable.btn_default);
        b7.setBackgroundResource(android.R.drawable.btn_default);
        b8.setBackgroundResource(android.R.drawable.btn_default);
        b9.setBackgroundResource(android.R.drawable.btn_default);
    }

    private void playerWin1(){
        t1.setText("Winner is "+user1);
        winner=Player1;
        Log.d("In winner declared", "--");
        scoreUpdate();
    }
    private void playerWin2(){
        t1.setText("Winner is "+user2);
        winner=Player2;
        Log.d("In winner declared", "--");
        scoreUpdate();
    }




    private void searchData()
    {
        //sharedpre=getSharedPreferences("Try1", Context.MODE_PRIVATE);

        Log.d("In Search Data", "--");
        //Condition to check if the database already have the score of the Player 1
       //if (sharedpre.contains(Player1)==false){

      // }
        //if (sharedpre.contains(Player2)){

        //}
            Log.d("In Search Data", "Player1");
            Toast.makeText(this, "Akash Was found", Toast.LENGTH_LONG).show();
            Log.d("In Search Data", " before getint");
            scorePlayer1=sharedpre.getInt(Player1,0);
            Log.d("After Search Data", " before getint");
            Log.d("scorePlayer1", " --" + scorePlayer1);

       // }
        //Condition to check if the database already have the score of the Player 2
       // if (sharedpre.contains(Player2)){
            Log.d("In Search Data", "Player2");
            Toast.makeText(this, "comp Was found", Toast.LENGTH_LONG).show();
            scorePlayer2=sharedpre.getInt(Player2,0);



            //Updating the text field with the Score
            t4.setText(String.valueOf(scorePlayer1));
            t5.setText(String.valueOf(scorePlayer2));
            Log.d("done Search Data", "Player2");
            Log.d("scorePlayer2", " --"+scorePlayer2);


    }

    private void scoreUpdate()
    {
        Log.d("In winner if", "--");
        SharedPreferences.Editor editor= sharedpre.edit();

        if(winner==Player1){
            scorePlayer1++;
            editor.putInt(winner, scorePlayer1);
            Log.d("In winner if Player1", "--");
        }
        else
        {
            scorePlayer2++;
            editor.putInt(winner, scorePlayer2);
            Log.d("In winner if Player2", "--");
        }
        editor.commit();

        t4.setText(String.valueOf(scorePlayer1));
        t5.setText(String.valueOf(scorePlayer2));
    }
}

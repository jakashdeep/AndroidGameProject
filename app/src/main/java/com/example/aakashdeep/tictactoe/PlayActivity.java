package com.example.aakashdeep.tictactoe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
    Button b10;
    Button b11;

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

    //Reset button status
    boolean reset=false;
    //For Single play condition
    boolean  singlegame=false;

    //Calculate number of players wins
    int p1wins=0;
    int p2wins=0;

    //Symbols to store the symbols X and O
    String symbol1;
    String symbol2;

    public static final String DEFAULT = "N/A";


    int r11=0,r12=0,r13=0,r21=0,r22=0,r23=0,r31=0,r32=0,r33=0;//X=1 and O=2

    SharedPreferences sharedpre;

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
        //Reset Button
        b10 = (Button) findViewById(R.id.button16);
        //Exit Button
        b11 = (Button) findViewById(R.id.button17);

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
        if(no_of_plays==1)
            singlegame=true;
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


    }

    /**
     *Handles the button click for the board
     * @param v Get View for the button click
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
            case R.id.button16:
                reset=true;
                Reset();
                break;
            case R.id.button17:
                exit();
                break;
        }

        if(flag)
        {

            if(no_of_plays>=1 || singlegame==true){

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Alert");
                String alert1="Player " + winner + " Wins";

                if(no_of_plays>1 && singlegame==false){
                    alert1=alert1.concat(" New Game Starts");}

                if(no_of_plays==1 && singlegame==false) {

                    if (p1wins > p2wins)
                        alert1=alert1.concat("\n" + "Winner of Game series " + Player1);
                    else
                        alert1=alert1.concat("\n" + "Winner of Game series " + Player2);

                }
                alert.setMessage(alert1);
                alert.setPositiveButton("OK", null);
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

            if(no_of_plays>=1 || singlegame==true){
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Alert");
                String alert1="Game is Draw ";
                if(singlegame==false) {
                    alert1=alert1.concat(" New Game Starts");
                }
                if(no_of_plays==1 && singlegame==false) {

                    if (p1wins > p2wins)
                        alert1=alert1.concat("\n" + "Winner of Game series " + Player1);//alert.setMessage("\n" + "Winner of Game series " + Player1);
                    else
                        alert1=alert1.concat("\n" + "Winner of Game series " + Player2);// alert.setMessage("\n" + "Winner of Game series " + Player2);

                    }

                alert.setMessage(alert1);
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


        ButtonEnabler();
        ButtonBackground();
        t1.setText("");
        if(no_of_plays <=0 && reset==false )
        {
            ButtonDisabler();

        }
        p1wins=0;
        p2wins=0;
        r11=0;r12=0;r13=0;r21=0;r22=0;r23=0;r31=0;r32=0;r33=0;
        counter=0;
        flag=false;
        reset=false;
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

    /**
     * Function to display the winner name
     */
    private void playerWin1(){
        t1.setText("Winner is " + user1);
        winner=Player1;
        p1wins++;
        scoreUpdate();
    }
    private void playerWin2(){
        t1.setText("Winner is "+user2);
        winner=Player2;
        p2wins++;
        scoreUpdate();
    }


    /**
     * Search the players name in the database
     */
    private void searchData()
    {

            scorePlayer1=sharedpre.getInt(Player1,0);

            scorePlayer2=sharedpre.getInt(Player2,0);



            //Updating the text field with the Score
            t4.setText(String.valueOf(scorePlayer1));
            t5.setText(String.valueOf(scorePlayer2));

    }

    /**
     * Updates the data from the database on the scoreboards
     */
    private void scoreUpdate()
    {
        Log.d("In winner if", "--");
        SharedPreferences.Editor editor= sharedpre.edit();

        if(winner==Player1){
            scorePlayer1++;
            editor.putInt(winner, scorePlayer1);

        }
        else
        {
            scorePlayer2++;
            editor.putInt(winner, scorePlayer2);

        }
        editor.commit();

        t4.setText(String.valueOf(scorePlayer1));
        t5.setText(String.valueOf(scorePlayer2));
    }

    /**
     * Function to exit the game
     */
    private void exit()
    {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}



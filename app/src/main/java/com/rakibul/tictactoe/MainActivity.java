package com.rakibul.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   List<Button> mybuttons=new ArrayList<>();
   Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
   boolean isOdd=true;
   int counter=0;
   Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        reset=findViewById(R.id.reset);
        reset.setOnClickListener(this);

        mybuttons.add(btn0);
        mybuttons.add(btn1);
        mybuttons.add(btn2);
        mybuttons.add(btn3); mybuttons.add(btn4); mybuttons.add(btn5);
        mybuttons.add(btn6); mybuttons.add(btn7); mybuttons.add(btn8);

        for (int i=0;i<9;i++){

            Button btn=mybuttons.get(i);
            btn.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.reset){
            ResetButton();
            return;
        }

       counter++;

        if (isOdd){
            int id=view.getId();

            Button btn=(Button) view;
            btn.setText("X");
            isOdd=false;


        }else{
            isOdd=true;
            int id=view.getId();
            Button btn=(Button) view;
            btn.setText("O");
        }
        CheckNow();

    }

    private void CheckNow() {


        if (isWin(0, 1, 2)) {
            WInner();
        } else if (isWin(3, 4, 5)) {
            WInner();
        } else if (isWin(6, 7, 8)) {
            WInner();
            return;
        } else if (isWin(0, 3, 6)) {
            WInner();
            return;
        } else if (isWin(1, 4, 7)) {
            WInner();
            return;
        } else if (isWin(2, 5, 8)) {
            WInner();
            return;
        } else if (isWin(0, 4, 8)) {
            WInner();
            return;
        } else if (isWin(2, 4, 6)){
            WInner();
            return;
    }
        if (counter==9){
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        }

    }
  private  boolean isWin(int a, int b, int c){

        Button aa, bb,cc;
        aa=mybuttons.get(a);
        bb=mybuttons.get(b);
        cc=mybuttons.get(c);
        String text=aa.getText().toString();
        String text2=bb.getText().toString();
        String text3=cc.getText().toString();

        if (text.equals("X")&&text.equals(text2)&&text.equals(text3)){
            return  true;
        }
        else if (text.equals("O")&&text.equals(text2)&&text.equals(text3)) {
            return true;
        }
        else
            return false;

  }

  private  void WInner(){
        if (isOdd)
          Toast.makeText(this, "Second Player WIn", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(this, "First Player WIn", Toast.LENGTH_SHORT).show();
      ResetButton();
  }

    private void ResetButton() {

        for (int i=0;i<9;i++){
            Button btn=mybuttons.get(i);
            btn.setText("");
        }
        counter=0;
        isOdd=true;
    }

}

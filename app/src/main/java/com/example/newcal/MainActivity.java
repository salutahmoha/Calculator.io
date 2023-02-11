package com.example.newcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private Button AC,power,Back,Div,Multiply,Add,Sub,one,two,three,four,five,six,seven,eight,nine,zero,ans,point,equals;
    private String input,answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        AC =  findViewById(R.id.ac);
        power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Multiply = findViewById(R.id.multiply);
        Add = findViewById(R.id.addition);
        Sub = findViewById(R.id.minus);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        ans= findViewById(R.id.ans);
        point = findViewById(R.id.point);
        equals = findViewById(R.id.equals);



    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input = "";
                break;
            case "Ans":
                input+=answer;
                break;
            case "x":
                Solve();
                input += "*";
                break;
            case "^":
                Solve();
                input += "^";
                break;
            case "=":
                Solve();
                answer = input;
                break;
            case "Back":
                String newText = input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if(input==null){
                    input="";

                }
                if(data.equals("+")|| data.equals("-")|| data.equals("/")){
                    Solve();
                }
                input +=data;

        }
        screen.setText(input);
    }

    private void Solve() {
        if (input.split("\\*").length == 2) {
            String number[] = input.split("\\*");
            try {
                double Multiply = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = Multiply+"";

            } catch (Exception e) {
            }

        }
       else if(input.split("/").length==2){
            String number[]=input.split("/");
            try{
                double Div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input =Div+"";

            }
            catch (Exception e){
            }

        }
        if(input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try{
                double power = Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input =power+"";

            }
            catch (Exception e){
            }

        }
        if(input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try{
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input =sum+"";

            }
            catch (Exception e){
            }

        }
        if(input.split("-").length==2){
            String number[]=input.split("-");
            if(number[0]==""&&number.length==2){
                number[0]=0+"";
            }
            try{
                double Sub=0;
                if(number.length==2){
                    Sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);

                }
                else if(number.length==3){
                    Sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }
                input = Sub+"";

            }
            catch (Exception e){
            }

        }
        String n[] = input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input = n[0];
            }
        }
        screen.setText(input);

    }
}
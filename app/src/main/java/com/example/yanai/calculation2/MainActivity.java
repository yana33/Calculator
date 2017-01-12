package com.example.yanai.calculation2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //宣言
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button button_divide;
    Button button_multiply;
    Button button_minus;
    Button button_plus;
    Button button_clear;
    Button button_equal;

    //数字とかを記録する用の変数
    double first;
    //押してないからfalse
    //boolean isPlus = false;
    double second;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(this);

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);

        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);

        button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(this);

        button_divide = (Button) findViewById(R.id.button_divide);
        button_divide.setOnClickListener(this);

        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(this);

        button_minus = (Button) findViewById(R.id.button_minus);
        button_minus.setOnClickListener(this);

        button_plus = (Button) findViewById(R.id.button_plus);
        button_plus.setOnClickListener(this);

        button_clear = (Button) findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);

        button_equal = (Button) findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);

    }

    public void onClick(View v) {
        TextView textView = (TextView) findViewById(R.id.textView);

        switch (v.getId()) {
            case R.id.button0:
                textView.setText(textView.getText() + "0");
                break;
            case R.id.button1:
                textView.setText(textView.getText() + "1");
                break;
            case R.id.button2:
                textView.setText(textView.getText() + "2");
                break;
            case R.id.button3:
                textView.setText(textView.getText() + "3");
                break;
            case R.id.button4:
                textView.setText(textView.getText() + "4");
                break;
            case R.id.button5:
                textView.setText(textView.getText() + "5");
                break;
            case R.id.button6:
                textView.setText(textView.getText() + "6");
                break;
            case R.id.button7:
                textView.setText(textView.getText() + "7");
                break;
            case R.id.button8:
                textView.setText(textView.getText() + "8");
                break;
            case R.id.button9:
                textView.setText(textView.getText() + "9");
                break;
            case R.id.button_divide:
                textView.setText(textView.getText() + " / ");
                setButton(false);
                break;
            case R.id.button_multiply:
                textView.setText(textView.getText() + " * ");
                setButton(false);
                break;
            case R.id.button_minus:
                textView.setText(textView.getText() + " - ");
                setButton(false);
                break;
            case R.id.button_plus:
                textView.setText(textView.getText() + " + ");
                setButton(false);
                break;
            case R.id.button_equal:
                String answer = calc(textView.getText().toString());
                textView.setText(answer);
                setButton(true);
                break;
            case R.id.button_clear:
                textView.setText("");
                setButton(true);
                break;
        }
    }

    //ボタンのオンオフを切り替えるメソッド
    //引数をisEnabledにすれば、上でtrueとかfalseを引数に入れるだけでOK
    public void setButton(boolean isEnabled){

        //オフにしたいボタンの名前.setEnabled(オフにしたいのでfalse);
        //()の中は名前でOK
        button_plus.setEnabled(isEnabled);
        button_minus.setEnabled(isEnabled);
        button_divide.setEnabled(isEnabled);
        button_multiply.setEnabled(isEnabled);
    }

    public String calc(String text) {
        String[] inputs = text.split(" ", 0);

        try {
            if (text.contains("+")) {
                return String.valueOf(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[2]));
            } else if (text.contains("-")) {
                return String.valueOf(Integer.parseInt(inputs[0]) - Integer.parseInt(inputs[2]));
            } else if (text.contains("*")) {
                return String.valueOf(Integer.parseInt(inputs[0]) * Integer.parseInt(inputs[2]));
            } else if (text.contains("/")) {
                return String.valueOf(Integer.parseInt(inputs[0]) / Integer.parseInt(inputs[2]));
            }
        } catch (NumberFormatException e) {
            return "error";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "error";
        }
        return inputs[0];
    }
}

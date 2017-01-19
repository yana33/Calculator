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
    Button button_excludingTax;
    Button button_taxIncluded;

    //押してないからfalse
    //boolean isPlus = false;

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

        button_excludingTax = (Button) findViewById(R.id.button_excludingTax);
        button_excludingTax.setOnClickListener(this);

        button_taxIncluded =(Button) findViewById(R.id.button_taxIncluded);
        button_taxIncluded.setOnClickListener(this);

        //はじめに計算ボタンを押せないように、falseにしておく。けど、なんでここ？
        setButton(false);
    }

    public void onClick(View v) {
        //textView使う時に書く
        TextView textView = (TextView) findViewById(R.id.textView);

        switch (v.getId()) {
            case R.id.button0:
                textView.setText(textView.getText() + "0");
                setButton(true);
                break;
            case R.id.button1:
                textView.setText(textView.getText() + "1");
                setButton(true);
                break;
            case R.id.button2:
                textView.setText(textView.getText() + "2");
                setButton(true);
                break;
            case R.id.button3:
                textView.setText(textView.getText() + "3");
                setButton(true);
                break;
            case R.id.button4:
                textView.setText(textView.getText() + "4");
                setButton(true);
                break;
            case R.id.button5:
                textView.setText(textView.getText() + "5");
                setButton(true);
                break;
            case R.id.button6:
                textView.setText(textView.getText() + "6");
                setButton(true);
                break;
            case R.id.button7:
                textView.setText(textView.getText() + "7");
                setButton(true);
                break;
            case R.id.button8:
                textView.setText(textView.getText() + "8");
                setButton(true);
                break;
            case R.id.button9:
                textView.setText(textView.getText() + "9");
                setButton(true);
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
                setButton(false);
                break;
            case R.id.button_clear:
                textView.setText("");
                setButton(false);
                break;
            case R.id.button_excludingTax:
                String tax2 = calcTax2(textView.getText().toString());
                textView.setText(tax2);
                setButton(false);
                break;
            case R.id.button_taxIncluded:
                String tax1 = calcTax1(textView.getText().toString());
                textView.setText(tax1);
                setButton(false);
        }
    }

    //ボタンのオンオフを切り替えるメソッド
    //引数をisEnabledにすれば、上でtrueとかfalseを引数に入れるだけでOK
    public void setButton(boolean isEnabled) {

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
            switch (inputs[1]) {
                //inputs[1]は計算記号の部分だから、そこで場合分け
                case "+":
                    return String.valueOf(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[2]));
                case "-":
                    return String.valueOf(Integer.parseInt(inputs[0]) - Integer.parseInt(inputs[2]));
                case "*":
                    return String.valueOf(Integer.parseInt(inputs[0]) * Integer.parseInt(inputs[2]));
                case "/":
                    return String.valueOf(Integer.parseInt(inputs[0]) / Integer.parseInt(inputs[2]));
            }
        } catch (NumberFormatException e) {
            return "error";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "error";
        }
        return inputs[0];
    }

    public String calcTax1(String num){
        return String.valueOf((int)(Integer.parseInt(num) * 1.08));
    }

    public String calcTax2(String num){
        //四捨五入はMath.round(四捨五入したいの)？
        return String.valueOf((int)Math.round(Integer.parseInt(num) / 1.08));
    }
}

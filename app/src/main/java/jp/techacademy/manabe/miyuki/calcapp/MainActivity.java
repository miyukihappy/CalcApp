package jp.techacademy.manabe.miyuki.calcapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {

        if(mEditText1.getText().length() == 0){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("値１を入力してください。");
            textView.setTextColor(Color.RED);
            return;
        }
        if(mEditText2.getText().length() == 0){
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("値２を入力してください。");
            textView.setTextColor(Color.RED);
            return;
        }
        double num1 = Double.parseDouble(mEditText1.getText().toString());
        double num2 = Double.parseDouble(mEditText2.getText().toString());
        double ret = 0;

        if (v.getId() == R.id.button1) {
            ret = num1 + num2;
        } else if (v.getId() == R.id.button2) {
            ret = num1 - num2;
        } else if (v.getId() == R.id.button3) {
            ret = num1 * num2;
        } else if (v.getId() == R.id.button4) {
            ret = num1 / num2;
        }
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALUE1", ret);
        startActivity(intent);
    }
}
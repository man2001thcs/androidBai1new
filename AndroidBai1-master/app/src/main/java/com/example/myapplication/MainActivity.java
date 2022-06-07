package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button AC;
    private Button plu;
    private Button mod;
    private Button divide;
    private Button mul;
    private Button minus;
    private Button plus;
    private Button equal;
    private Button point;
    private Button del;
    private boolean deleted = false;
    private boolean continued = false;
    private int storeFunc = 0;
    private double tempo;
    private double now;

    public void showConvert(){
        Intent switchActivityIntent = new Intent(this, MainActivity1.class);
        startActivity(switchActivityIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.caculator:
                return true;
            case R.id.convert:
                showConvert();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Caculator");
        text1 = (TextView) findViewById(R.id.functionShow);
        text2 = (TextView) findViewById(R.id.funct);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        AC = (Button) findViewById(R.id.buttonAC);
        plu = (Button) findViewById(R.id.buttonplu);
        mod = (Button) findViewById(R.id.buttonmod);
        mul = (Button) findViewById(R.id.buttonmul);
        minus = (Button) findViewById(R.id.buttonminus);
        plus = (Button) findViewById(R.id.buttonplus);
        equal = (Button) findViewById(R.id.buttonequal);
        point = (Button) findViewById(R.id.buttonpoint);
        del = (Button) findViewById(R.id.buttondel);
    }



    //Enter number 0->9
    public void setButton1(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("1");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("1");
            }
        }
    }
    public void setButton2(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("2");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("2");
            }
        }
    }
    public void setButton3(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("3");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("3");
            }
        }
    }

    public void setButton4(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("4");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("4");
            }
        }
    }
    public void setButton5(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("5");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("5");
            }
        }
    }
    public void setButton6(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("6");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("6");
            }
        }
    }
    public void setButton7(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("7");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("7");
            }
        }
    }
    public void setButton8(View view){
        if (text1.getText().equals("0")  || deleted){
            text1.setText("8");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("8");
            }
        }
    }
    public void setButton9(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("9");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("9");
            }
        }
    }
    public void setButton0(View view){
        if (text1.getText().equals("0") || deleted){
            text1.setText("0");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append("0");
            }
        }
    }

    //funtion thing:

    //delete
    public void setButtondel(View view){
        if (text1.getText().length() == 1 || text1.getText().length() == 0){
            deleted = true;
            text1.setText("0");
        }else{
            text1.setText(text1.getText().subSequence(0, text1.getText().length()-1));
        }
    }
    //AC
    public void setButtonAC(View view){
        text1.setText("0");
        storeFunc = 'n';
        tempo = 0.0;
        now = 0.0;
        deleted = true;
        text2.setText("function");
    }

    //

    public void setRemain(Double doubleone){
        long intpart = (new Double(doubleone)).longValue();
        String inparts = String.valueOf(intpart);
        int inpartLong = inparts.length();
        inpartLong = 12 - inpartLong;
        if (inpartLong >= 0){
            StringBuffer temp = new StringBuffer();
            temp.append("%.");
            temp.append(inpartLong);
            temp.append("f");
            String tempora = String.format(temp.toString(), doubleone);
            int temporaL = tempora.length();
            int count = 0;
            while ((tempora.charAt(temporaL - 1)) == 48){
                temporaL--;
                count++;
            }
            if (count != 0) tempora = tempora.substring(0, tempora.length() - count - 1);
            if (tempora.charAt(tempora.length()-1) == 46) tempora = tempora.substring(0, tempora.length() - 1);

            text1.setText(tempora);
        } else{
            text1.setText(doubleone.toString());
        }

    }

    //equal
    public void setButtonequal(View view){
        text2.setText("equal");
        now = Double.parseDouble(String.valueOf(text1.getText()));
        if (storeFunc != 0) {
            double temporary = tempo;
            tempo = now;
            if (storeFunc == 1) now  = temporary + now;
            if (storeFunc == 2) now  = temporary - now;
            if (storeFunc == 3) now  = temporary * now;
            if (storeFunc == 4) now  = temporary / now;
            if (storeFunc == 5) now  = temporary % now;
            tempo = now;
            deleted = true;
            setRemain(tempo);
            storeFunc = 0;
        }
    }

    public void setequal(View view){
        now = Double.parseDouble(String.valueOf(text1.getText()));
        if (storeFunc != 0) {
            double temporary = tempo;
            tempo = now;
            if (storeFunc == 1) now  = temporary + now;
            if (storeFunc == 2) now  = temporary - now;
            if (storeFunc == 3) now  = temporary * now;
            if (storeFunc == 4) now  = temporary / now;
            if (storeFunc == 5) now  = temporary % now;
            tempo = now;
            deleted = true;
            setRemain(tempo);
        }
    }
    //point
    public void setButtonpoint(View view){
        String temp = text1.getText().toString();
        for (int i = 0; i < temp.length(); i++){
            if (temp.charAt(i) == '.') return;
        }
        if (text1.getText().equals("0") || deleted){
            text1.setText("0.");
            deleted = false;
        }else{
            if (text1.getText().length() < 13){
                text1.append(".");
            }
        }
    }
    //plus
    public void setButtonplus(View view){
        if (storeFunc == 1 && deleted == true) return;
        text2.setText("+");
        if (storeFunc != 0) {
            setequal(view);
            storeFunc = 1;
            tempo = now;
            setRemain(tempo);
        } else{
            tempo = Double.parseDouble(String.valueOf(text1.getText()));
            storeFunc = 1;
            deleted = true;
            now = tempo;
        }
    }

    //minus
    public void setButtonminus(View view){
        text2.setText("-");
        if (storeFunc == 2 && deleted == true) return;
        if (storeFunc != 0) {
            setequal(view);
            storeFunc = 2;
            tempo = now;
            setRemain(tempo);
        } else{
            tempo = Double.parseDouble(String.valueOf(text1.getText()));
            storeFunc = 2;
            deleted = true;
            now = tempo;
        }
    }
    //mul
    public void setButtonmul(View view){
        if (storeFunc == 3 && deleted == true) return;
        text2.setText("x");
        if (storeFunc != 0) {
            setequal(view);
            storeFunc = 3;
            tempo = now;
            setRemain(tempo);
        } else{
            tempo = Double.parseDouble(String.valueOf(text1.getText()));
            storeFunc = 3;
            deleted = true;
            now = tempo;
        }
    }
    //divide
    public void setButtondivide(View view){
        if (storeFunc == 4 && deleted == true) return;
        text2.setText("/");
        if (storeFunc != 0) {
            setequal(view);
            storeFunc = 4;
            tempo = now;
            setRemain(tempo);
        } else{
            tempo = Double.parseDouble(String.valueOf(text1.getText()));
            storeFunc = 4;
            deleted = true;
            now = tempo;
        }
    }
    //mod
    public void setButtonmod(View view){
        if (storeFunc == 5 && deleted == true) return;
        text2.setText("%");
        if (storeFunc != 0) {
            setequal(view);
            storeFunc = 5;
            tempo = now;
            setRemain(tempo);
        } else{
            tempo = Double.parseDouble(String.valueOf(text1.getText()));
            storeFunc = 5;
            deleted = true;
            now = tempo;
        }
    }
    //+/- positive and negative
    public void setButtonplu(View view){
        Double temp = Double.parseDouble(String.valueOf(text1.getText()));
            temp = 0 - temp;
            now = temp;
            setRemain(now);
    }
}
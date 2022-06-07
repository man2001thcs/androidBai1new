package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity1 extends AppCompatActivity {

    String[] items = { "Data-0", "Data-1", "Data-2", "Data-3",
           "Data-4", "Data-5", "Data-6", "Data-7" };

    Map<String, Double> data = new HashMap<String, Double>(){
        {
            put("Dong", 1.00);
            put("USD", 0.000043);
            put("JPY", 0.005609);
            put("Euro", 0.0000404633);
            put("CAD", 0.000544432);
            put("NZD", 0.0000664265);
            put("NOK", 0.0004077);
            put("GBP", 0.0000344942);
            put("AUD", 0.0000600045);
            put("SEK", 0.0004242);
        }
    };

    Spinner spinner1;
    Spinner spinner2;
    TextView textView;
    TextView cur1;
    TextView cur2;

    EditText editText1;
    TextView editText2;

    public String setRemain(Double doubleone){
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

            return tempora;
        } else{
            return doubleone.toString();
        }

    }

    public void showCaculator(){
        Intent switchActivityIntent = new Intent(this, MainActivity.class);
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
                showCaculator();
                return true;
            case R.id.convert:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Convert");
        setContentView(R.layout.activity_main1);

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        editText1 = (EditText) findViewById(R.id.textView2);
        editText2 = (TextView) findViewById(R.id.textView3);

        textView = (TextView) findViewById(R.id.textView4);
        textView.setText("None");
        cur1 = (TextView) findViewById(R.id.cur1);
        cur2 = (TextView) findViewById(R.id.cur2);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if ((spinner1.getSelectedItem().toString()).equals("--Default--")){
                    cur1.setText("Currency 1");
                    editText1.setHint("None");
                } else {
                    cur1.setText(spinner1.getSelectedItem().toString());
                    editText1.setHint(spinner1.getSelectedItem().toString());

                    if ((spinner2.getSelectedItem().toString()).equals("--Default--")){
                        textView.setText("None1");
                    } else{
                        double shield = data.get(spinner2.getSelectedItem().toString());
                        double spear = data.get(spinner1.getSelectedItem().toString());

                        StringBuilder stringBuilder = new StringBuilder("");
                        stringBuilder.append("Tỉ lệ trao đổi đồng giá: ");
                        stringBuilder.append(spinner1.getSelectedItem().toString());
                        stringBuilder.append(" -> ");
                        stringBuilder.append(spinner2.getSelectedItem().toString());
                        stringBuilder.append(": ");
                        stringBuilder.append(setRemain(shield/spear));
                        textView.setText(stringBuilder.toString());

                        double temp1 = Double.parseDouble(editText1.getText().toString());
                        editText2.setText(setRemain(temp1*shield/spear));

                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (spinner2.getSelectedItem().toString().compareTo("--Default--") == 0){
                    cur2.setText("Currency 2");
                    editText2.setHint("0");
                    return;
                }
                cur2.setText(spinner2.getSelectedItem().toString());
                editText2.setHint(spinner2.getSelectedItem().toString());

                if ((spinner1.getSelectedItem().toString()).equals("--Default--")){
                    textView.setText("None1");
                } else{
                    double shield = data.get(spinner2.getSelectedItem().toString());
                    double spear = data.get(spinner1.getSelectedItem().toString());

                    StringBuilder stringBuilder = new StringBuilder("");
                    stringBuilder.append("Tỉ lệ trao đổi đồng giá: ");
                    stringBuilder.append("\n");
                    stringBuilder.append("1 ");
                    stringBuilder.append(spinner1.getSelectedItem().toString());
                    stringBuilder.append(" -> ");
                    stringBuilder.append(spinner2.getSelectedItem().toString());
                    stringBuilder.append(": ");
                    stringBuilder.append(setRemain(shield/spear));
                    textView.setText(stringBuilder.toString());

                    double temp1 = Double.parseDouble(editText1.getText().toString());
                    editText2.setText(setRemain(temp1*shield/spear));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (spinner2.getSelectedItem().toString().compareTo("--Default--") == 0){
                    editText2.setText("0");
                    return;
                }

                //cur 2 la dong
                if (spinner2.getSelectedItem().toString().compareTo("Dong") == 0){
                    double temp1 = Double.parseDouble(charSequence.toString());
                    double spear = data.get(spinner1.getSelectedItem().toString());
                    double temp2 = temp1 / spear;
                    editText2.setText(Double.toString(temp2));
                    return;
                }

                //cur 1 la dong
                if (spinner1.getSelectedItem().toString().compareTo("Dong") == 0){
                    double temp1 = Double.parseDouble(charSequence.toString());
                    double spear = data.get(spinner2.getSelectedItem().toString());
                    double temp2 = temp1 * spear;
                    editText2.setText(Double.toString(temp2));
                    return;
                }

                //cur 1 cur 2 khong la dong, chuyen cur 1 ve dong r chuyen sang cur 2
                if (spinner1.getSelectedItem().toString().compareTo("Dong") != 0 &&
                        spinner2.getSelectedItem().toString().compareTo("Dong") != 0){
                    double temp1 = Double.parseDouble(charSequence.toString());
                    double shield = data.get(spinner2.getSelectedItem().toString());
                    double spear = data.get(spinner1.getSelectedItem().toString());
                    double temp2 = temp1 / spear * shield;
                    editText2.setText(Double.toString(temp2));
                    return;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
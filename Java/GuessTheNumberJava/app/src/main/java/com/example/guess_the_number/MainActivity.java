package com.example.guess_the_number;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    TextView resultField;
    TextView rField;
    TextView aLField;
    CheckBox lCheckBox;
    RadioButton rCheckBox;
    RadioButton aCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultField =(TextView) findViewById(R.id.textView9);
        rField = (TextView) findViewById(R.id.editTextR);
        aLField = (TextView) findViewById(R.id.editTextAL);
        lCheckBox = (CheckBox) findViewById(R.id.checkBox);
        rCheckBox = (RadioButton) findViewById(R.id.radioButton3);
        aCheckBox = (RadioButton) findViewById(R.id.radioButton4);
    }
    // обработка нажатия на числовую кнопку
    public void onNumberClick(View view){
        Button button = (Button)view;
        if(rCheckBox.isChecked()) {
            rField.append(button.getText());
        }
        if(aCheckBox.isChecked())
        {
            aLField.append(button.getText());
        }
    }

    // обработка нажатия на кнопку операции
    public void onOperationClick(View view){
        String r = rField.getText().toString();
        String a = aLField.getText().toString();

        // если введенно что-нибудь
        if(aLField.length()>0 && rField.length()>0 ){
            r = r.replace(',', '.');
            a = a.replace(',', '.');
            Double result = Double.parseDouble(r);
            Double aL = Double.parseDouble(a);
            try{
                if(lCheckBox.isChecked())
                {
                    result = result*aL/2;

                    resultField.setText(result.toString());
                }
                else
                {
                    result = result*aL*3.14/360;
                    resultField.setText(result.toString());
                }
            }catch (NumberFormatException ex){
                rField.setText("");
                aLField.setText("");
            }
        }
        rField.setText("");
        aLField.setText("");
    }

}
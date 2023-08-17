package org.spiralarms.exam;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dataActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editPersonFirstName;
    private EditText editPersonLastName;
    private TextView textViewFirstName;
    private TextView textViewLastName;
    private TextView textViewPhone;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        textViewFirstName = findViewById(R.id.textView3);
        textViewLastName = findViewById(R.id.textView2);
        textViewPhone = findViewById(R.id.textView);
        editPersonFirstName = findViewById(R.id.editTextTextPersonName);
        editPersonLastName = findViewById(R.id.editTextTextPersonName2);
        buttonRegister = findViewById(R.id.buttonRegister);
        Bundle extras = getIntent().getExtras();
        textViewFirstName.setText(extras.getString("first_name"));
        textViewLastName.setText(extras.getString("last_name"));
        textViewPhone.setText(extras.getString("phone"));


    }
    @Override
    public void onClick(View v) {
        Intent switchActivity = new Intent(dataActivity.this, InfoActivity.class);
        switchActivity.putExtra("first_name", String.valueOf(textViewFirstName.getText()));
        switchActivity.putExtra("last_name", String.valueOf(textViewLastName.getText()));
        switchActivity.putExtra("phone", String.valueOf(textViewPhone.getText()));
        switchActivity.putExtra("date", String.valueOf(editPersonFirstName.getText()));
        switchActivity.putExtra("date2", String.valueOf(editPersonLastName.getText()));
        startActivity(switchActivity);
    }
}

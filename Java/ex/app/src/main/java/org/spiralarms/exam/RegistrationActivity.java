package org.spiralarms.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editPersonFirstName;
    private EditText editPersonLastName;
    private EditText editPhone;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editPersonFirstName = findViewById(R.id.editPersonFirstName);
        editPersonLastName = findViewById(R.id.editPersonLastName);
        editPhone = findViewById(R.id.editPhone);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent switchActivity = new Intent(RegistrationActivity.this, InfoActivity.class);
        switchActivity.putExtra("first_name", String.valueOf(editPersonFirstName.getText()));
        switchActivity.putExtra("last_name", String.valueOf(editPersonLastName.getText()));
        switchActivity.putExtra("phone", String.valueOf(editPhone.getText()));
        startActivity(switchActivity);
    }
}
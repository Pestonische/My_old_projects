package org.spiralarms.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewFirstName;
    private TextView textViewLastName;
    private TextView textViewPhone;
    private TextView textViewdate;
    private TextView textViewdate2;
    private Button buttonNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textViewFirstName = findViewById(R.id.textViewFirstName);
        textViewLastName = findViewById(R.id.textViewLastName);
        textViewPhone = findViewById(R.id.textViewPhone);

        textViewdate = findViewById(R.id.textView4);
        textViewdate2 = findViewById(R.id.textView5);
        buttonNext = findViewById(R.id.buttonNext);

        Bundle extras = getIntent().getExtras();
        textViewFirstName.setText(extras.getString("first_name"));
        textViewLastName.setText(extras.getString("last_name"));
        textViewPhone.setText(extras.getString("phone"));
        textViewdate.setText(extras.getString("date"));
        textViewdate2.setText(extras.getString("date2"));
        buttonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent switchActivity = new Intent(InfoActivity.this, dataActivity.class);
        switchActivity.putExtra("first_name", String.valueOf(textViewFirstName.getText()));
        switchActivity.putExtra("last_name", String.valueOf(textViewLastName.getText()));
        switchActivity.putExtra("phone", String.valueOf(textViewPhone.getText()));
        startActivity(switchActivity);
    }
}

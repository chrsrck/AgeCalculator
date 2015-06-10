/* By: chrsrck (Christopher Rickey)
Date: 6.10.2015
This project was made to review concepts after the second Android Treehouse tutorial (the
Interactiver Story App).
 */
package com.example.chrsrck.agecalculator;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    private EditText mAgeEditText;
    private Button mCalcButton;
    private int mAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAgeEditText = (EditText) findViewById(R.id.ageEditText);
        mCalcButton = (Button) findViewById(R.id.calcButton);

        mCalcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAgeEditText.getText().toString().length() == 0)
                    Toast.makeText(getApplicationContext(), "Enter an age!", Toast.LENGTH_SHORT).show();
                else {
                    mAge = Integer.parseInt(mAgeEditText.getText().toString());
                    Intent intent = new Intent();
                    startActivity(mAge);
                }
            }
        });
    }

    private void startActivity(int age) {
        Intent intent = new Intent(this, Calculations.class);
        intent.putExtra("AGE", age);
        startActivity(intent);
    }
}

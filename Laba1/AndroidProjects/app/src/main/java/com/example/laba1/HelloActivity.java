package com.example.laba1;

import androidx.annotation.Nullable;

import android.content.Context;
import android.content.res.Resources;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
public class HelloActivity extends Activity {
    TextView messageView;
    Button btnEnglish;
    Context context;
    Resources resources;
    boolean sost = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloact);

        // referencing the text and button views
        messageView = (TextView) findViewById(R.id.text1);
        //btnHindi = findViewById(R.id.btnHindi);
        btnEnglish = findViewById(R.id.buttonEn);



        TextView text1 = findViewById(R.id.text1);
        final int[] a = {0,0};

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0]++;
                text1.setText(String.valueOf(a[0])+","+String.valueOf(a[1]));
            }
        });

        Button button2 = findViewById(R.id.buttonRus);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[1]++;
                text1.setText(String.valueOf(a[0])+","+String.valueOf(a[1]));
            }
        });

        // setting up on click listener event over the button
        // in order to change the language with the help of
        // LocaleHelper class
        btnEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sost)
                {
                    context = LocaleHelper.setLocale(HelloActivity.this, "eng");
                    resources = context.getResources();
                    btnEnglish.setText("Eng");
                    button1.setText("Pressed!");
                    if(a[0] == 0 && a[1] == 0)
                        text1.setText("Hello World");
                    button2.setText("Pressed!");
                    sost = false;
                }
                else
                {
                    context = LocaleHelper.setLocale(HelloActivity.this, "rus");
                    resources = context.getResources();
                    btnEnglish.setText("Rus");
                    button1.setText("Нажато!");
                    if (a[0] == 0 && a[1] == 0)
                        text1.setText("Привет мир");
                    button2.setText("Нажато!");
                    sost = true;
                }

        }

    });
}
}


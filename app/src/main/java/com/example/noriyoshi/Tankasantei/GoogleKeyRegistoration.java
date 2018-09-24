package com.example.noriyoshi.Tankasantei;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GoogleKeyRegistoration extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_key_registoration);



    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView id = findViewById(R.id.userid);
        TextView pw = findViewById(R.id.password);
        String ID = id.getText().toString();
        String PW = pw.getText().toString();

        View v=findViewById(R.id.googleidstore);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

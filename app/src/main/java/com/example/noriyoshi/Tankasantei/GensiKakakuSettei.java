package com.example.noriyoshi.Tankasantei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GensiKakakuSettei extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

    /*
m戻るボタン押し下げ
 */
        View modoru = findViewById(R.id.sub_modoru);
        modoru.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

 /*
 ライナーキロ価格取得
  */
        TextView ln = findViewById(R.id.linerkakaku);
        ln.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextView ts;
                    ts = (TextView) v;
                    String s = ts.getText().toString();

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("LINER_KAKAKU",s);
                    editor.apply();

                    double d = (double) Integer.parseInt(s);
                    NumBase.setLinerkiro(d);
                }
            }
        });
 /*
普通芯キロ価格取得
  */
        TextView fs = findViewById(R.id.hutuusinkakaku);
        fs.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextView tv;
                    tv = (TextView) v;
                    String s = tv.getText().toString();

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("HUTUU_KAKAKU",s);
                    editor.apply();

                    double d = (double) Integer.parseInt(s);
                    NumBase.setSinkiro(d);
                }
            }
        });
 /*
強化芯キロ価格取得
  */
        TextView ks = findViewById(R.id.kyoukasinkakaku);
        ks.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    TextView tu;
                    tu = (TextView) v;
                    String s = tu.getText().toString();

                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("KYOUKA_KAKAKU",s);
                    editor.apply();

                    double d = (double) Integer.parseInt(s);
                    NumBase.setKyoukakiro(d);
                }
            }
        });



    }
}

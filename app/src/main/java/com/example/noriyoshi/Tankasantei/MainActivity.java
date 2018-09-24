package com.example.noriyoshi.Tankasantei;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

/*  */

public class MainActivity extends AppCompatActivity {

    private void updatestuts(){
        double a,b,c,d,e,f,g,h,i,j;

        a=NumBase.getFlute() + NumBase.getLiner();
        b=NumBase.getHaba() * NumBase.getNagare() / 1000000;
        c=NumBase.getTenun();
        d=NumBase.getLot();
        e=NumBase.getInsatuset();
        f=NumBase.getInsatutoosi();

        h=NumBase.getNukiset();
        i=NumBase.getNukitoosi();
        j=NumBase.getNukitukisuu();

        try {
            if (j == 0) {

                g = (a + c) * b + (e / d) + f;
            } else {
                g = (a + c) * b + (e / d) + f / j + (h / d) + (i / j);
            }

            TextView tv = findViewById(R.id.result);
            tv.setText(BigDecimal.valueOf(g).toPlainString());
        }catch(Exception ex){}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*
        保存済み原紙価格の取得
         */
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String ln = sharedPreferences.getString("LINER_KAKAKU", "0");
        Log.d("LinerKiro", "LinerKiro is " + ln);
        String hs = sharedPreferences.getString("HUTUU_KAKAKU", "0");
        Log.d("SinKiro", "SinKiro is " + hs);
        String ks = sharedPreferences.getString("KYOUKA_KAKAKU", "0");
        Log.d("KyoukaKiro", "KyoukaKiro is " + ks);


        NumBase.setLinerkiro(ln);
        NumBase.setSinkiro(hs);
        NumBase.setKyoukakiro(ks);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return true;

    }



    protected void onResume(){
        super.onResume();
               /*
        原紙価格設定ボタン押し下げ
         */
        View gen = findViewById(R.id.gensikakakusettei);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.activity_sub);
                Intent intent = new Intent(getApplication(), GensiKakakuSettei.class);
                startActivity(intent);
            }
        });


/*
原紙とフルートの種類選択
 */
        RadioGroup f = findViewById(R.id.flute);
        RadioGroup l = findViewById(R.id.liner);

        f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double bairitu=1;
                switch (checkedId) {
                    case R.id.radioA:
                        bairitu= 0.12 * 1.6;
                        break;
                    case R.id.radioAB:
                        bairitu= 0.12 * 4;
                        break;
                    case R.id.radioB:
                        bairitu= 0.12 * 1.4;
                        break;
                }
                try {
                    NumBase.setFlute(Integer.parseInt(NumBase.getSinkiro()) * bairitu);
                }catch (Exception ex){}
                updatestuts();
            }
        });

        l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                double bairitu=1;
                switch (checkedId) {
                    case R.id.radioK5:
                        bairitu= 0.17 * 2;
                        break;
                    case R.id.radioK6:
                        bairitu= 0.21 * 2;
                        break;
                    case R.id.radioK7:
                        bairitu= 0.28 * 2;
                        break;
                }
                try {
                    NumBase.setLiner(Integer.parseInt(NumBase.getLinerkiro()) * bairitu);
                }catch(Exception ex){}

                updatestuts();
            }
        });

/*
巾罫の取得と格納
 */
        TextView hb;
        hb = findViewById(R.id.haba);
        hb.addTextChangedListener(new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    NumBase.setHaba((double) Integer.parseInt(s.toString()));
                    updatestuts();
                } catch (Exception ex) {}
            }
        } );


/*
流れ罫の取得と格納
 */
        TextView ngr;
        ngr = findViewById(R.id.nagare);
        ngr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    NumBase.setNagare((double) Integer.parseInt(s.toString()));
                }catch (Exception ex){}
                updatestuts();


            }
        });

/*
貼合運賃の取得と格納

 */
        TextView tu;
        tu = findViewById(R.id.tengouuntin);
        tu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try
                {
                    NumBase.setTenun((double)Integer.parseInt(s.toString()));
                }catch (Exception ex){}

                updatestuts();

            }
        });

        /*
ロットの取得と格納

 */
        TextView lt;
        lt = findViewById(R.id.lot);
        lt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setLot((double)Integer.parseInt(s.toString()));
                }catch (Exception ex){}
                updatestuts();

            }
        });

/*
セットの取得と格納
*/
        TextView st;
        st = findViewById(R.id.insatuset);
        st.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setInsatuset((double)Integer.parseInt(s.toString()));
                }catch (Exception ex){}
                updatestuts();

            }
        });

/*
通しの取得と格納
*/
        TextView ts;
        ts = findViewById(R.id.insatutoosi);
        ts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setInsatutoosi((double)Integer.parseInt(s.toString()));
                }catch(Exception ex){}

                updatestuts();

            }
        });

/*
抜きセットの取得と格納
*/
        TextView ns;
        ns = findViewById(R.id.nukiset);
        ns.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setNukiset((double)Integer.parseInt(s.toString()));
                }catch (Exception ex){}

                updatestuts();

            }
        });

/*
抜き通しの取得と格納
*/
        TextView nt;
        nt = findViewById(R.id.nukitoosi);
        nt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setNukitoosi((double)Integer.parseInt(s.toString()));
                }catch(Exception ex){}

                updatestuts();

            }
        });

 /*
抜きつきすうの取得と格納
*/
        TextView nts;
        nts = findViewById(R.id.nukitukisuu);
        nts.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    NumBase.setNukitukisuu((double)Integer.parseInt(s.toString()));
                }catch(Exception ex){                }
                updatestuts();

            }
        });


        /*
計算ボタン押し下げ
 */

        View cal = findViewById(R.id.calc);
        cal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                updatestuts();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.googlekey:
                Intent intent = new Intent(getApplication(), GoogleKeyRegistoration.class);
                startActivity(intent);

                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.googlekey:
                Intent intent = new Intent(getApplication(), GoogleKeyRegistoration.class);
                startActivity(intent);

                return true;
            default:


                return super.onContextItemSelected(item);
        }
    }
}

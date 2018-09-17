package com.example.noriyoshi.Tankasantei;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.BigDecimal;

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

        if (j == 0) {


            g = (a + c) * b + (e / d) + f;
        }else{
            g = (a + c) * b + (e / d) + f/j+(h/d)+(i/j) ;
        }

        TextView tv=findViewById(R.id.result);
        tv.setText(BigDecimal.valueOf(g).toPlainString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        保存済み原紙価格の取得
         */
       SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       //SharedPreferences.Editor editor = sharedPreferences.edit();

       String ln = sharedPreferences.getString("LINER_KAKAKU","0");
        Log.d("LinerKiro", "LinerKiro is "+ln);
       String hs = sharedPreferences.getString("HUTUU_KAKAKU","0");
        Log.d("SinKiro", "SinKiro is "+hs);
        String ks = sharedPreferences.getString("KYOUKA_KAKAKU","0");
        Log.d("KyoukaKiro", "KyoukaKiro is "+ks);


        NumBase.setLinerkiro((double)Integer.parseInt(ln));
        NumBase.setSinkiro((double)Integer.parseInt(hs));
      NumBase.setKyoukakiro((double)Integer.parseInt(ks));

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
                switch (checkedId){

                    case R.id.radioA:
                        NumBase.setFlute(NumBase.getSinkiro()*0.12*1.6);
                        break;
                    case R.id.radioAB:
                        NumBase.setFlute(NumBase.getSinkiro()*0.12*4);
                        break;
                    case R.id.radioB:
                        NumBase.setFlute(NumBase.getSinkiro()*0.12*1.4);
                        break;
                }

                //updatestuts();

            }
        });
        l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.radioK5:
                        NumBase.setLiner(NumBase.getLinerkiro()*0.17*2);
                        break;
                    case R.id.radioK6:
                        NumBase.setLiner(NumBase.getLinerkiro()*0.21*2);
                        break;
                    case R.id.radioK7:
                        NumBase.setLiner(NumBase.getLinerkiro()*0.28*2);
                        break;
                }
//                updatestuts();
                //updatestuts();
            }
        });


/*
巾罫の取得と格納
 */
        TextView hb;
        hb = findViewById(R.id.haba);
        hb.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setHaba(d);
  //                  updatestuts();
                }
            }

        });

/*
流れ罫の取得と格納

 */
        TextView ngr;
        ngr = findViewById(R.id.nagare);
        ngr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setNagare(d);
    //                updatestuts();
                }
            }

        });

/*
貼合運賃の取得と格納

 */
        TextView tu;
        tu = findViewById(R.id.tengouuntin);
        tu.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setTenun(d);
      //              updatestuts();
                }
            }

        });
        /*
ロットの取得と格納

 */
        TextView lt;
        lt = findViewById(R.id.lot);
        lt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setLot(d);
        //            updatestuts();
                }
            }

        });
/*
セットの取得と格納
*/
        TextView st;
        st = findViewById(R.id.insatuset);
        st.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setInsatuset(d);
          //          updatestuts();
                }
            }

        });
/*
通しの取得と格納
*/
        TextView ts;
        ts = findViewById(R.id.insatutoosi);
        ts.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setInsatutoosi(d);
            //        updatestuts();
                }
            }

        });
/*
抜きセットの取得と格納
*/
        TextView ns;
        ns = findViewById(R.id.nukiset);
        ns.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setNukiset(d);
                    //        updatestuts();
                }
            }

        });
/*
抜き通しの取得と格納
*/
        TextView nt;
        nt = findViewById(R.id.nukitoosi);
        nt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setNukitoosi(d);
                    //        updatestuts();
                }
            }

        });
 /*
抜きつきすうの取得と格納
*/
        TextView nts;
        nts = findViewById(R.id.nukitukisuu);
        nts.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    TextView tv;
                    tv=(TextView)v;
                    String s =tv.getText().toString();
                    double d = (double) Integer.parseInt(s);
                    NumBase.setNukitukisuu(d);
                    //        updatestuts();
                }
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

}

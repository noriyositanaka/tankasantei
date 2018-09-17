package com.example.noriyoshi.Tankasantei;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.BigDecimal;

/*  */

public class MainActivity extends AppCompatActivity {

    private void updatestuts(){
        double a,b,c,d,e,f,g,h;

        a=NumBase.getFlute() + NumBase.getLiner();
        b=NumBase.getHaba() * NumBase.getNagare() / 1000000;
        c=NumBase.getTenun();
        d=NumBase.getLot();
        e=NumBase.getInsatuset();
        f=NumBase.getInsatutoosi();

        g= (a+c)*b+(e/d)+f;

        TextView tv=findViewById(R.id.result);
        tv.setText(BigDecimal.valueOf(g).toPlainString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumBase nb=new NumBase();

        RadioGroup f = findViewById(R.id.flute);
        RadioGroup l = findViewById(R.id.liner);

        f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){

                    case R.id.radioA:
                        NumBase.setFlute(11.13);
                        break;
                    case R.id.radioAB:
                        NumBase.setFlute(27.84);
                        break;
                    case R.id.radioB:
                        NumBase.setFlute(9.74);
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
                        NumBase.setLiner(24.82);
                        break;
                    case R.id.radioK6:
                        NumBase.setLiner(30.66);
                        break;
                    case R.id.radioK7:
                        NumBase.setLiner(40.88);
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
遠しの取得と格納
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

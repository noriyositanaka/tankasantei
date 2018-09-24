package com.example.noriyoshi.Tankasantei;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;


            public class GensiKakakuSettei extends AppCompatActivity {
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_sub);

         /*
        保存済み原紙価格の取得
         */
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String lnr = sharedPreferences.getString("LINER_KAKAKU", "0");
//        Log.d("LinerKiro", "LinerKiro is " + lnr);
        String hsn = sharedPreferences.getString("HUTUU_KAKAKU", "0");
//        Log.d("SinKiro", "SinKiro is " + hsn);
        String ksn = sharedPreferences.getString("KYOUKA_KAKAKU", "0");
//        Log.d("KyoukaKiro", "KyoukaKiro is " + ksn);

        TextView ln = findViewById(R.id.linerkakaku);
        ln.setText(lnr);
        TextView fs = findViewById(R.id.hutuusinkakaku);
        fs.setText(hsn);
        TextView ks = findViewById(R.id.kyoukasinkakaku);
        ks.setText(ksn);
    }


    protected void onResume(){
        super.onResume();


/*
戻るボタン押し下げ
*/
        View modoru = findViewById(R.id.sub_modoru);
        modoru.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

/*
ライナー価格取得
 */
                TextView ts=findViewById(R.id.linerkakaku);
                String s = ts.getText().toString();

/*
普通芯価格取得
 */
                TextView tv =findViewById(R.id.hutuusinkakaku);
                String t = tv.getText().toString();

/*
強化芯価格取得

 */
                TextView tu =findViewById(R.id.kyoukasinkakaku);
                String u = tu.getText().toString();
/*
保管
 */
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("LINER_KAKAKU",s);
                editor.putString("HUTUU_KAKAKU",t);
                editor.putString("KYOUKA_KAKAKU",u);
                editor.apply();

                NumBase.setLinerkiro(s);
                NumBase.setSinkiro(t);
                NumBase.setKyoukakiro(u);

                finish();
            }
        });
    }
}

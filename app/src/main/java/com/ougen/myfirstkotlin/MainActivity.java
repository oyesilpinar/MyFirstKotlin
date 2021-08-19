package com.ougen.myfirstkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView tv_q;
    Button b_opt1,b_opt2,b_opt3;

    List<Sorular> Sorulacaklar;
    int GuncelSoru=0;

    int dogru=0 , yanlis=0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //R java dosyasına ulasmamiz icin findViewById gerekli
        tv_q=findViewById(R.id.q);
        b_opt1=findViewById(R.id.opt1);
        b_opt2=findViewById(R.id.opt2);
        b_opt3=findViewById(R.id.opt3);

        loadTumSorular();
        //Soruları karistirmak istersek
        Collections.shuffle(Sorulacaklar);
        //ilk soruyu yükle
        setQuestionScreen(GuncelSoru);


        //Burada butonun tıklama işlemi olayını yakalaması icin setOnClickListener Kullanıcagız.
        b_opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kontrol et dogrumu degilmi
                if (Sorulacaklar.get(GuncelSoru).getOpt1().equals(Sorulacaklar.get(GuncelSoru).getAnswer())){
                    dogru++;
                    Toast.makeText(MainActivity.this,"Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    yanlis++;
                    Toast.makeText(MainActivity.this,"Yanlış Doğru Cevap:"
                            +Sorulacaklar.get(GuncelSoru).getAnswer(),Toast.LENGTH_SHORT).show();
                }
                //bir sonraki soru icin
                if(GuncelSoru<Sorulacaklar.size()-1){
                    GuncelSoru++;
                    setQuestionScreen(GuncelSoru);
                }else{

                }

            }
        });

        b_opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Sorulacaklar.get(GuncelSoru).getOpt2().equals(Sorulacaklar.get(GuncelSoru).getAnswer())){
                    dogru++;
                    Toast.makeText(MainActivity.this,"Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    yanlis++;
                    Toast.makeText(MainActivity.this,"Yanlış Doğru Cevap:"
                            +Sorulacaklar.get(GuncelSoru).getAnswer(),Toast.LENGTH_SHORT).show();
                }
                //bir sonraki soru icin
                if(GuncelSoru<Sorulacaklar.size()-1){
                    GuncelSoru++;
                    setQuestionScreen(GuncelSoru);
                }else{

                }

            }
        });

        b_opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Sorulacaklar.get(GuncelSoru).getOpt3().equals(Sorulacaklar.get(GuncelSoru).getAnswer())){
                    dogru++;
                    Toast.makeText(MainActivity.this,"Doğru",Toast.LENGTH_SHORT).show();
                }
                else{
                    yanlis++;
                    Toast.makeText(MainActivity.this,"Yanlış Doğru Cevap:"
                            +Sorulacaklar.get(GuncelSoru).getAnswer(),Toast.LENGTH_SHORT).show();
                }
                //bir sonraki soru icin
                if(GuncelSoru<Sorulacaklar.size()-1){
                    GuncelSoru++;
                    setQuestionScreen(GuncelSoru);
                }else{

                }


            }
        });

    }

    //soruları set edelim ekrana
    private void setQuestionScreen(int number){
        tv_q.setText(Sorulacaklar.get(number).getQ());
        b_opt1.setText(Sorulacaklar.get(number).getOpt1());
        b_opt2.setText(Sorulacaklar.get(number).getOpt2());
        b_opt3.setText(Sorulacaklar.get(number).getOpt3());


    }


    //tüm soruların oldugu listemizi yapalım
    private void loadTumSorular(){
        Sorulacaklar =new ArrayList<>();

        String jsonStr = loadJSONFromAsset("ingilizcekelimeler.json");
        //tüm datayı yüklüyoruz
        try{
            JSONObject jsonObj = new JSONObject(jsonStr);
            JSONArray Sorular =jsonObj.getJSONArray("Sorular");
            for(int i=0;i<Sorular.length();i++){
                JSONObject q = Sorular.getJSONObject(i);

                String qString =q.getString("Sorular");
                String opt1String=q.getString("opt1");
                String opt2String=q.getString("opt2");
                String opt3String=q.getString("opt3");
                String answerString=q.getString("answer");

                Sorulacaklar.add(new Sorular(
                        qString,
                        opt1String,
                        opt2String,
                        opt3String,
                        answerString

                ));

            }
        }catch (JSONException e){
            e.printStackTrace();

        }
    }



    //asset klasorundeki json dosyasını yüklüyoruz try catch kullanarak
    private String loadJSONFromAsset(String file){
        String json="";
        try {
            InputStream is =getAssets().open(file);
            int size=is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json =new String(buffer,"UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }


}
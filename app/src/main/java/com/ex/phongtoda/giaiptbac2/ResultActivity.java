package com.ex.phongtoda.giaiptbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView Result;
    Button Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Back=(Button)findViewById(R.id.Back);
        Result = (TextView)findViewById(R.id.tvResult);
        Intent callerIntent = getIntent();
        Bundle packBundle= callerIntent.getBundleExtra("Package");
        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");
        int c = packBundle.getInt("soC");
        GiaiPTbac2(a,b,c);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1 = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(myIntent1);
            }
        });

    }
    public void GiaiPTbac2(int a,int b,int c) {
        if(a==0) {
            if(b==0){
                if(c==0)
                    Result.setText("Phương trình có vô số nghiệm");
                else
                    Result.setText("Phương trình vô nghiệm");
            } else {
                Result.setText("Phương trình có một nghiệm \nx = "+String.valueOf((float)(-c/b)));
            }
        } else {
            double delta =(b*b - 4*a*c);
            double t =Math.sqrt(delta);
            if (delta < 0) {
                Result.setText("Phương trình vô nghiệm\n");
            } else if (delta == 0) {
                Result.setText("Phương trình có nghiệm kép \nx1 = x2 = "+(-b/(2*a)));
            } else {
                Result.setText("Phương trình có 2 nghiệm phân biệt \nx1 = "+(-b+t)/(2*a) + "\n" +"x2 = " +((-b-t)/(2*a)));
            }
        }
    }
}




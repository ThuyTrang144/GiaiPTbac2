package com.ex.phongtoda.giaiptbac2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnResult;
    EditText editA,editB,editC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editA =(EditText)findViewById(R.id.edtA);
        editB = (EditText)findViewById(R.id.edtB);
        editC = (EditText)findViewById(R.id.edtC);
        btnResult = (Button)findViewById(R.id.Result);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent Intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();

                int a = Integer.parseInt(editA.getText().toString());
                int b = Integer.parseInt(editB.getText().toString());
                int c = Integer.parseInt(editC.getText().toString());
                //dua du lieu vao bundle
                bundle.putInt("soA", a);
                bundle.putInt("soB", b);
                bundle.putInt("soC", c);
                //dua bundle vao Intent
                Intent.putExtra("Package", bundle);
                startActivity(Intent);

            }
        });

    }
}



package com.example.lanspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner lanSpinner,marginSpinner;
    Button lanBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        marginSpinner=findViewById(R.id.MarginSpinner);
        lanSpinner=findViewById(R.id.lanSpinner);
        lanBut=findViewById(R.id.lanBut);
        lanBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale=null;
                Toast.makeText(MainActivity.this,lanSpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                switch (lanSpinner.getSelectedItem().toString()){
                    case "ru":{
                        locale=new Locale("ru");
                        break;
                    }
                    case "en":{
                        locale=new Locale("en");
                        break;
                    }
                }
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

                switch (marginSpinner.getSelectedItem().toString()){
                    case "Малый отступ":
                    case "Little margin":
                        Utils.changeToTheme(MainActivity.this,1);
                        break;
                    case "Средний отступ":
                    case "Medium margin":
                        Utils.changeToTheme(MainActivity.this,2);
                        break;
                    case "Большой отступ":
                    case "Large margin":
                        Utils.changeToTheme(MainActivity.this,3);
                        break;
                }
            }
        });
    }


}

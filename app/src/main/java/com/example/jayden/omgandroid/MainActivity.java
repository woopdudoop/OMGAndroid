package com.example.jayden.omgandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button butPull1, butPush1, butLegs1, butPull2, butPush2, butLegs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butPull1 = (Button) this.findViewById(R.id.Pull1);
        butPush1 = (Button) this.findViewById(R.id.Push1);
        butLegs1 = (Button) this.findViewById(R.id.Legs1);
        butPull2 = (Button) this.findViewById(R.id.Pull2);
        butPush2 = (Button) this.findViewById(R.id.Push2);
        butLegs2 = (Button) this.findViewById(R.id.Legs2);
        butPull1.setOnClickListener(this);
        butPush1.setOnClickListener(this);
        butLegs1.setOnClickListener(this);
        butPull2.setOnClickListener(this);
        butPush2.setOnClickListener(this);
        butLegs2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Pull1:
                startActivity(new Intent(MainActivity.this, Pull_1.class));
                break;
            case R.id.Push1:
                startActivity(new Intent(MainActivity.this, Push_1.class));
                break;
            case R.id.Legs1:
                startActivity(new Intent(MainActivity.this, Legs_1.class));
                break;
            case R.id.Pull2:
                startActivity(new Intent(MainActivity.this, Pull_2.class));
                break;
            case R.id.Push2:
                startActivity(new Intent(MainActivity.this, Push_2.class));
                break;
            case R.id.Legs2:
                startActivity(new Intent(MainActivity.this, Legs_2.class));
                break;

        }
    }
}
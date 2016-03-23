package com.example.jayden.omgandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Legs_2 extends AppCompatActivity implements View.OnClickListener{

    private CountDownTimer Timer1, Timer2, Timer3;
    private boolean timer1Started = false, timer2Started = false, timer3Started = false;
    private Button button230, button130, button100;
    public TextView textView;
    private final long startTime = 1000;
    private final long interval = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs_2);
        button230 = (Button) this.findViewById(R.id.button1);
        button130 = (Button) this.findViewById(R.id.button2);
        button100 = (Button) this.findViewById(R.id.button3);
        button230.setOnClickListener(this);
        button130.setOnClickListener(this);
        button100.setOnClickListener(this);
        textView = (TextView) this.findViewById(R.id.edtTimerValue);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button1:
                if (!timer1Started) {
                    Timer1 = new CountDownTimerActivity(150 * startTime, interval);
                    Timer1.start();
                    timer1Started = true;
                    button230.setText("Stop");
                } else {
                    Timer1.cancel();
                    timer1Started = false;
                    button230.setText("2:30");
                    textView.setText("Time");
                }
                break;
            case R.id.button2:
                if (!timer2Started) {
                    Timer2 = new CountDownTimerActivity(90 * startTime, interval);
                    Timer2.start();
                    timer2Started = true;
                    button130.setText("Stop");
                } else {
                    Timer2.cancel();
                    timer2Started = false;
                    button130.setText("1:30");
                    textView.setText("Time");
                }
                break;
            case R.id.button3:
                if (!timer3Started) {
                    Timer3 = new CountDownTimerActivity(60 * startTime, interval);
                    Timer3.start();
                    timer3Started = true;
                    button100.setText("Stop");
                } else {
                    Timer3.cancel();
                    timer3Started = false;
                    button100.setText("1:00");
                    textView.setText("Time");
                }
                break;
        }
    }



    public class CountDownTimerActivity extends CountDownTimer {
        public CountDownTimerActivity(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            textView.setText("Done");
            Vibrator workpls = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            workpls.vibrate(1000);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            int mins = (int) (millisUntilFinished/60000);
            int secs = (int) ((millisUntilFinished - mins*60000)/1000);

            textView.setText(String.format("%01d:%02d",mins,secs));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

}

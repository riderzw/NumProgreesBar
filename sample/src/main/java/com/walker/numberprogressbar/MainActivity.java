package com.walker.numberprogressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.walker.numberprogressbar.library.NumProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    NumProgressBar numberProgressBar;
    NumProgressBar numberProgressBar1;
    NumProgressBar numberProgressBar2;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberProgressBar = (NumProgressBar) this.findViewById(R.id.numberProgressBar);
        numberProgressBar1 = (NumProgressBar) this.findViewById(R.id.numberProgressBar1);
        numberProgressBar2 = (NumProgressBar) this.findViewById(R.id.numberProgressBar2);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        numberProgressBar.setCurrentProgress(progress);
                        numberProgressBar1.setCurrentProgress(progress);
                        numberProgressBar2.setCurrentProgress(progress);
                        progress++;
                        if (progress >= 100) {
                            progress = 0;
                        }
                    }
                });

            }
        };
        timer.schedule(task, 0, 500);
    }
}

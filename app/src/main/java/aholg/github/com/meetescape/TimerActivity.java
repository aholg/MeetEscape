package aholg.github.com.meetescape;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final Button button = (Button) findViewById(R.id.startButton);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        startTimerHandler(button, timePicker);
    }

    private void startTimerHandler(Button button, final TimePicker timePicker) {
        timePicker.setIs24HourView(true);
        timePicker.setHour(getTimeOf(Calendar.HOUR));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startTimer(timePicker);
            }
        });
    }

    private void startTimer(TimePicker timePicker) {
        //TODO: Handle time calculation properly
        int hours= timePicker.getHour() - getTimeOf(Calendar.HOUR);
        int minutes = timePicker.getMinute() - getTimeOf(Calendar.MINUTE) ;

        int milliSeconds = convertTimeToMillis(hours, minutes);
        setTimerTo(milliSeconds);
    }

    private int getTimeOf(int field) {
        return Calendar.getInstance().get(field);
    }

    private int convertTimeToMillis(int hours, int minutes) {
        return hours * 60 * 60 * 1000 + minutes * 60 * 1000;
    }

    public void setTimerTo(int milliSeconds) {
        new CountDownTimer(/*milliSeconds*/ 1, 1000) {

            public void onTick(long millisUntilFinished) {
                System.out.println("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                System.out.println("done!");
                startActivity(new Intent(TimerActivity.this, CallActivity.class));
            }
        }.start();
    }
}

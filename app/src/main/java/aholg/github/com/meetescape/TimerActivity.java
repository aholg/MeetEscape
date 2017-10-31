package aholg.github.com.meetescape;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        final Button button = (Button) findViewById(R.id.startButton);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        startTimerHandler(button, timePicker);
    }

    public void startTimerHandler(Button button, final TimePicker timePicker) {
        final TimerService timerService =
                new TimerService(TimerActivity.this, new Intent(TimerActivity.this, CallActivity.class));

        timePicker.setIs24HourView(true);
        timePicker.setHour(Calendar.getInstance().get(Calendar.HOUR));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timerService.startTimer(timePicker);
            }
        });
    }
}

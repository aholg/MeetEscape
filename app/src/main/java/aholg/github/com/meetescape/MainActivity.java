package aholg.github.com.meetescape;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.startButton);

        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        timePicker.setHour(hour);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO: Handle time calculation properly
                int hours= timePicker.getHour() - Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ;
                int minutes = timePicker.getMinute() - Calendar.getInstance().get(Calendar.MINUTE) ;

                setTimerTo(hours, minutes , timePicker.getTransitionName());
            }
        });
    }

    public void setTimerTo(int hours, int minutes, String period) {
        new CountDownTimer(hours * 60 * 60 * 1000 + minutes * 60 * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                System.out.println("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                System.out.println("done!");
            }
        }.start();
    }
}

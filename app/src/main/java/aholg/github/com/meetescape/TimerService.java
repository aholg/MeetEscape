package aholg.github.com.meetescape;


import android.content.Context;
import android.content.Intent;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerService {

    private Context context;
    private Intent activityToStart;

    TimerService(Context context, Intent activityToStart) {
        this.context = context;
        this.activityToStart = activityToStart;
    }

     void startTimer(TimePicker timePicker) {
        //TODO: Handle time calculation properly
        int hours= timePicker.getHour() - getTimeOf(Calendar.HOUR);
        int minutes = timePicker.getMinute() - getTimeOf(Calendar.MINUTE);

        int milliSeconds = convertTimeToMillis(hours, minutes);
        setTimerTo(milliSeconds);
    }

    private int getTimeOf(int field) {
        return Calendar.getInstance().get(field);
    }

    private int convertTimeToMillis(int hours, int minutes) {
        return hours * 60 * 60 * 1000 + minutes * 60 * 1000;
    }

    private void setTimerTo(int milliSeconds) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                context.startActivity(activityToStart);
                System.out.println("done!");
            }
        }, milliSeconds);
    }
}

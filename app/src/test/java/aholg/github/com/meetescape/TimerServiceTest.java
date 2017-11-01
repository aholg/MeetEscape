package aholg.github.com.meetescape;

import android.content.Context;
import android.content.Intent;
import android.widget.TimePicker;

import org.junit.Test;

import java.util.Calendar;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TimerServiceTest {

    @Test
    public void shouldStartTimer() throws Exception {
        Context mockContext = mock(Context.class);
        Intent mockIntent = mock(Intent.class);
        TimerService timerService = new TimerService(mockContext, mockIntent);

        TimePicker timePicker = mock(TimePicker.class);
        when(timePicker.getHour()).thenReturn(Calendar.getInstance().get(Calendar.HOUR));
        when(timePicker.getMinute()).thenReturn(Calendar.getInstance().get(Calendar.MINUTE));

        timerService.startTimer(timePicker);

        verify(mockContext).startActivity(mockIntent);
    }
}
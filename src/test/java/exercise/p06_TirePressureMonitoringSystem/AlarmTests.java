package exercise.p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AlarmTests {
    private static final double VALUE_LOWER_THAN_17 = 16;
    private static final double VALUE_HIGHER_THAN_21 = 22;
    private static final double VALUE_BETWEEN_17_AND_21 = 19;

    Sensor sensor;
    Alarm alarm;

    @BeforeEach
    public void setUp() {
        sensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void test_Alarm_With_Lower_Value() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_LOWER_THAN_17);
        alarm.check();
        Assertions.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_With_Higher_Value() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_HIGHER_THAN_21);
        alarm.check();
        Assertions.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void test_Alarm_With_Correct_Value() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(VALUE_BETWEEN_17_AND_21);
        alarm.check();
        Assertions.assertFalse(alarm.getAlarmOn());
    }
 }

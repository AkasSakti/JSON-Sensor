import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

public class SensorHelper implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private List<SensorData> sensorDataList = new ArrayList<>();

    public SensorHelper(Context context) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    public void startListening() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void stopListening() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        long timestamp = System.currentTimeMillis();

        sensorDataList.add(new SensorData(x, y, z, timestamp));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    public List<SensorData> getSensorDataList() {
        return sensorDataList;
    }
}

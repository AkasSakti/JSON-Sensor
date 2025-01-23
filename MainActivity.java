import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorHelper sensorHelper;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        sensorHelper = new SensorHelper(this);

        sensorHelper.startListening();

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            sensorHelper.stopListening();
            List<SensorData> data = sensorHelper.getSensorDataList();
            JsonHelper.saveSensorData(this, data);
            textView.setText("Data berhasil disimpan!");
        });

        findViewById(R.id.btnLoad).setOnClickListener(v -> {
            List<SensorData> data = JsonHelper.getSensorData(this);
            if (data != null && !data.isEmpty()) {
                SensorData first = data.get(0);
                textView.setText("X: " + first.getX() + " Y: " + first.getY() + " Z: " + first.getZ());
            } else {
                textView.setText("Data tidak ditemukan");
            }
        });
    }
}

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class JsonHelper {
    private static final String PREFS_NAME = "sensor_prefs";
    private static final String KEY_SENSOR_DATA = "sensor_data";

    // Simpan data sensor sebagai JSON di SharedPreferences
    public static void saveSensorData(Context context, List<SensorData> data) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(data);
        editor.putString(KEY_SENSOR_DATA, json);
        editor.apply();
    }

    // Ambil data JSON dari SharedPreferences dan konversi kembali ke objek
    public static List<SensorData> getSensorData(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_SENSOR_DATA, null);
        Type type = new TypeToken<List<SensorData>>() {}.getType();
        return gson.fromJson(json, type);
    }
}

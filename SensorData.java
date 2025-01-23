public class SensorData {
    private float x;
    private float y;
    private float z;
    private long timestamp;

    public SensorData(float x, float y, float z, long timestamp) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.timestamp = timestamp;
    }

    public float getX() { return x; }
    public float getY() { return y; }
    public float getZ() { return z; }
    public long getTimestamp() { return timestamp; }
}

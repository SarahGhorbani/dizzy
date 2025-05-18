package com.example.dizzy_robot;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final float SHAKE_THRESHOLD = 800.0f;
    private GifImageView gifImageView;
    private Button stopButton;
    private SensorManager sensorManager;
    private Sensor accelerometer;
    private float lastX, lastY, lastZ;
    private long lastUpdateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initSensor();
        setupStopButton();
    }

    private void initViews() {
        gifImageView = findViewById(R.id.gifView);
        stopButton = findViewById(R.id.stopButton);
    }

    private void initSensor() {
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    private void setupStopButton() {
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopGif();
            }
        });
    }

    private void stopGif() {
        gifImageView.setVisibility(View.GONE);
    }

    private void playGif() {
        gifImageView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            detectShake(event.values);
        }
    }

    private void detectShake(float[] values) {
        float x = values[0];
        float y = values[1];
        float z = values[2];

        long currentTime = System.currentTimeMillis();

        if ((currentTime - lastUpdateTime) > 100) {
            float deltaX = x - lastX;
            float deltaY = y - lastY;
            float deltaZ = z - lastZ;

            float speed = Math.abs(deltaX + deltaY + deltaZ) / (currentTime - lastUpdateTime) * 10000;

            if (speed > SHAKE_THRESHOLD) {
                playGif();
            }

            lastX = x;
            lastY = y;
            lastZ = z;
            lastUpdateTime = currentTime;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}


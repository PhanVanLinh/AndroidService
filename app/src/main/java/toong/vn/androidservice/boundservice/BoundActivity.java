package toong.vn.androidservice.boundservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import toong.vn.androidservice.R;

public class BoundActivity extends AppCompatActivity {
    private boolean binded = false;
    private BoundService weatherService;

    private TextView weatherText;
    private EditText locationText;
    private Button btnWeather;

    ServiceConnection weatherServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.LocalWeatherBinder binder = (BoundService.LocalWeatherBinder) service;
            weatherService = binder.getService();
            binded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binded = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);

        weatherText = (TextView) this.findViewById(R.id.text_weather);
        locationText = (EditText) this.findViewById(R.id.text_input_location);
        btnWeather = (Button) this.findViewById(R.id.button_weather);

        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWeather();
            }
        });
    }

    // Khi Activity start.
    @Override
    protected void onStart() {
        super.onStart();

        // Tạo đối tượng Intent cho WeatherService.
        Intent intent = new Intent(this, BoundService.class);

        // Gọi method bindService(..) để giàng buộc dịch vụ với giao diện.
        this.bindService(intent, weatherServiceConnection, Context.BIND_AUTO_CREATE);
    }

    // Khi Activity ngừng hoạt động.
    @Override
    protected void onStop() {
        super.onStop();
        if (binded) {
            // Hủy giàng buộc kết nối với dịch vụ.
            this.unbindService(weatherServiceConnection);
            binded = false;
        }
    }

    public void showWeather() {
        String location = locationText.getText().toString();
        String weather = this.weatherService.getWeatherToday(location);
        weatherText.setText(weather);
    }
}
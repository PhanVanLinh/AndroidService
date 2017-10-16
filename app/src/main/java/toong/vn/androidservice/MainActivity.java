package toong.vn.androidservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        findViewById(R.id.button_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSong();
            }
        });
    }

    public void playSong()  {
        Intent myIntent = new Intent(MainActivity.this, PlaySongService.class);
        this.startService(myIntent);
    }

    public void stopSong()  {
        Intent myIntent = new Intent(MainActivity.this, PlaySongService.class);
        this.stopService(myIntent);
    }

}

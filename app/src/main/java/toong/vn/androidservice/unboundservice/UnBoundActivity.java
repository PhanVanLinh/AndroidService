package toong.vn.androidservice.unboundservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import toong.vn.androidservice.R;

public class UnBoundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_play_bound_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        findViewById(R.id.button_stop_unbound_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSong();
            }
        });
    }

    public void playSong()  {
        Intent myIntent = new Intent(UnBoundActivity.this, UnBoundedSongService.class);
        this.startService(myIntent);
    }

    public void stopSong()  {
        Intent myIntent = new Intent(UnBoundActivity.this, UnBoundedSongService.class);
        this.stopService(myIntent);
    }

}
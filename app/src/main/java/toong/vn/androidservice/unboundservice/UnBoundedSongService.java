package toong.vn.androidservice.unboundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import toong.vn.androidservice.R;

public class UnBoundedSongService extends Service {
    private String TAG = getClass().getSimpleName();
    private MediaPlayer mediaPlayer;

    public UnBoundedSongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // This is unbounded service => this method will never called
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.romance);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        mediaPlayer.start();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }
}
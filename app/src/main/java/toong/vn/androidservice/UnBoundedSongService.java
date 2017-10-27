package toong.vn.androidservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class UnBoundedSongService extends Service {
    private String TAG = getClass().getSimpleName();
    private MediaPlayer mediaPlayer;
    private int i = 0;
    private final TimerTask t = new TimerTask() {
        @Override
        public void run() {
            Log.i(TAG, "" + i++);
            if(i == 10){
                stopSelf();
            }
        }
    };
    Timer timer;

    public UnBoundedSongService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // This is unbounded service => this method will never called
        return null;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate");
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.romance);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        mediaPlayer.start();

        timer = new Timer();
        timer.scheduleAtFixedRate(t, 0, 1000);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        mediaPlayer.release();
        timer.cancel();
        super.onDestroy();
    }
}
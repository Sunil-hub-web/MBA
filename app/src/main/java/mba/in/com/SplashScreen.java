package mba.in.com;

import android.app.UiModeManager;
import android.content.Intent;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final String TAG = "SplashScreen";
    Handler handler;
    private UiModeManager uiModeManager;
    NoiseSuppressor noiseSuppressor;
    int microphoneId = 101;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        /*Window window = SplashScreen.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(SplashScreen.this, R.color.white));*/

        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
        uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);

        getSupportActionBar().hide();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        enableNoiseSuppressor();

        handler = new Handler();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }

//    public void enableNoiseSuppressor() {
//
//        if (NoiseSuppressor.isAvailable() && noiseSuppressor == null) {
//            noiseSuppressor = NoiseSuppressor.create(microphoneId);
//            noiseSuppressor.setEnabled(true);
//            Log.i(TAG, "NoiseSuppressor enabled");
//        } else {
//            Log.e(TAG, "This device don't support NoiseSuppressor");
//        }
//
//    }
}
package mmengchen.videodemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import mmengchen.videodemo.R;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;
    private final static String VIDEO_URL = "http://olzjfqy00.bkt.clouddn.com/aroundtheworld.flv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.act_main_vv);
        initData();
    }

    private void initData() {
        mVideoView.setVideoPath(VIDEO_URL); //设置播放路径
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });
        // 设置video的控制器
        mVideoView.setMediaController(new MediaController(this));
    }
}

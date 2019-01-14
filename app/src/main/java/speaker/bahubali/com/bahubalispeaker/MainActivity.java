package speaker.bahubali.com.bahubalispeaker;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageButton btnOnOff;
    private AudioManager mAudioMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOnOff = (ImageButton) findViewById(R.id.imgBtn_speakeron_off);
        btnOnOff.setOnClickListener(this);
        mAudioMgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtn_speakeron_off:
                if (!mAudioMgr.isSpeakerphoneOn()) {
                    mAudioMgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                    mAudioMgr.setMode(AudioManager.MODE_NORMAL);
                    mAudioMgr.setMode(AudioManager.MODE_IN_CALL);
                    mAudioMgr.setSpeakerphoneOn(true);

                    Toast.makeText(getApplicationContext(), "SpeakerPhone ON", Toast.LENGTH_LONG).show();
                } else {
                    mAudioMgr.setMode(AudioManager.MODE_IN_CALL);
                    mAudioMgr.setMode(AudioManager.MODE_NORMAL);
                    mAudioMgr.setSpeakerphoneOn(false);
                    Toast.makeText(getApplicationContext(), "SpeakerPhone OFF", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}

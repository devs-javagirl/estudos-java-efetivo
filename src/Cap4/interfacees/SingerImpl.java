package Cap4.interfacees;

import javax.sound.sampled.AudioFileFormat;
import java.applet.AudioClip;

public class SingerImpl implements SingerSongwriter {

    @Override
    public AudioClip sing(AudioFileFormat s) {
        return null;
    }

    @Override
    public String strum() {
        return "teste 2";
    }

    @Override
    public void actSensitive() {

    }

    @Override
    public AudioFileFormat compose(int chartPosition) {
        return null;
    }
}

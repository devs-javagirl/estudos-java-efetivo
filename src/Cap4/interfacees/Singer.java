package Cap4.interfacees;

import javax.sound.sampled.AudioFileFormat;


public interface Singer {
    String sing(AudioFileFormat s);
    default int singSong() {
        return 1;
    };
}


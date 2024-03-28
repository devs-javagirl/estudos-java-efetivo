package Cap4.interfacees;


public interface SingerSongwriter extends Singer, Songwriter {

    default String strum() {
        return "teste 1";
    };

    void actSensitive();
}

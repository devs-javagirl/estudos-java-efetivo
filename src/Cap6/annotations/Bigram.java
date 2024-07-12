package Cap6.annotations;

/**
 * Onde está o BUG?
 */
public class Bigram {
    private final char first;
    private final char second;
    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bigram bigram)) return false;
        return first == bigram.first && second == bigram.second;
    }

    /*
    @Override public boolean equals(Bigram b) { // Deveria ser equals(Object o)
        return b.first == first && b.second == second;
    }
    */

    @Override public int hashCode() {
        return 31 * first + second;
    }
}



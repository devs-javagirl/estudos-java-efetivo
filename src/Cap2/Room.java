package Cap2;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();
    final private Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        State state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() {
        cleanable.clean();
        System.out.println("Called close");
    }

    private static class State implements Runnable {
        int numJunkPiles;

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            numJunkPiles = 0;
            System.out.println("Cleaning room");
        }
    }


}

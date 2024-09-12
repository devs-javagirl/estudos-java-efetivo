package Cap8;

public class Item53Varargs {
    static long startTime;

    public static void timeSpent(long start) {
        long endTime = System.nanoTime();
        System.out.println(" em " + (endTime - start) / 1_000_000 + " ms");
    }


    public static int min(int um, int dois, int tres) {
        //soma os 3 números
        int min = um;
        if (dois < min) {
            min = dois;
        }
        return min;
    }

    public static int minVarargs(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Argumentos ausentes.");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    public static int minArray(int[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Argumentos ausentes.");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    public static int minFirst(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        startTime = System.nanoTime();
        System.out.println(min(1, 2, 3));
        timeSpent(startTime);

        startTime = System.nanoTime();
        System.out.println(minVarargs(1, 2, 3));
        timeSpent(startTime);

        startTime = System.nanoTime();
        System.out.println(minFirst(1, 2, 3, 4,5,6,7,8,9,10,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1));
        timeSpent(startTime);
    }
}

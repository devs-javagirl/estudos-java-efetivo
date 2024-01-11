package Cap2;

import java.io.*;


public class TryWithResources {
    private static final int BUFFER_SIZE = 10;

    // try-with-resources - a melhor maneira
    static String firstLineOfFile1(String path, String codError) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return codError;
        }
    }

    // try-with-resources com mais recursos
    static void copy(String entrada, String saida) throws IOException {
        try(InputStream in = new FileInputStream(entrada);
            OutputStream out = new FileOutputStream(saida)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n=in.read(buf)) >= 0)
                out.write(buf,0,n);
        }
    }


}

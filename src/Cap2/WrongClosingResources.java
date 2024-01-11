package Cap2;

import java.io.*;

public class WrongClosingResources {

    private static final int BUFFER_SIZE = 10;

    // try-finally - Não é mais a melhor maneira de fechar recursos
    static String firstLineOfFile() throws IOException {
        BufferedReader br = null;
        try {
            //aqui pode lançar exceção
            return br.readLine();
        } finally {
            //aqui também pelo mesmo motivo
            br.close();
        }
    }

    // try-finally - feio quando usado em mais de um recurso
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n=in.read(buf)) >= 0)
                    out.write(buf,0,n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

}

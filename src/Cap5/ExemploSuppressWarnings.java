package Cap5;

import java.util.ArrayList;
import java.util.List;

public class ExemploSuppressWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Criando uma lista genérica sem especificar seu tipo
        List lista = new ArrayList();

        // Adicionando elementos à lista
        lista.add("Texto");
        lista.add(10);


        // Recuperando elementos da lista
        for (Object elemento : lista) {
            // Aqui, sabemos que os elementos são do tipo String e Integer, mas o compilador não
            // Isso pode gerar um aviso de unchecked cast
            String texto = (String) elemento; // unchecked cast
            System.out.println(texto);
        }

    }
}


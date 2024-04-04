package Cap5;

import java.util.ArrayList;
import java.util.List;

public class ExemploTiposBrutos {

    public static void adicionarElemento(List lista, Object elemento) {
        lista.add(elemento);
    }

    public static void main(String[] args) {
        // Criando uma lista de forma insegura usando um tipo bruto
        List listaInsegura = new ArrayList();

        listaInsegura.add("String");
        listaInsegura.add(10); // Isso é permitido, pois o tipo da lista é bruto

        for (Object elemento : listaInsegura) {
            // Tentativa de cast para String
            String str = (String) elemento; // Isso lançará ClassCastException
            System.out.println(str);
        }
    }
}

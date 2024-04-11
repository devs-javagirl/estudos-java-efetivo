package Cap5;

import java.util.ArrayList;
import java.util.List;

public class ExemploGenerics {

    public static <E> void adicionarElemento(List<E> lista, E elemento) {
        lista.add(elemento);
    }

    public static void main(String[] args) {
        // Criando uma lista de forma segura usando generics
        List<String> listaSegura = new ArrayList<>();

        adicionarElemento(listaSegura, "String");
        //adicionarElemento(listaSegura, 10); // Isso geraria um erro de compilação

        // Iterando pela lista e recuperando os elementos de forma segura
        for (String elemento : listaSegura) {
            System.out.println(elemento);
        }
    }
}


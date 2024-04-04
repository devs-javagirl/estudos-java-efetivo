package Cap5;

import java.util.ArrayList;
import java.util.List;

public class TesteTiposBrutosVsGenerics {

    // Método para adicionar elementos a uma lista de forma insegura
    public static void adicionarElementoListaInsegura(List lista, Object elemento) {
        lista.add(elemento);
    }

    // Método para adicionar elementos a uma lista de forma segura usando generics
    public static <T> void adicionarElementoListaSegura(List<T> lista, T elemento) {
        lista.add(elemento);
    }

    public static void main(String[] args) {

        // Teste usando generics
        List<String> listaSegura = new ArrayList<>();
        adicionarElementoListaSegura(listaSegura, "String");
        //adicionarElementoListaSegura(listaSegura, 10); // Isso geraria um erro de compilação

        // Iterando pela lista e recuperando os elementos de forma segura
        for (String elemento : listaSegura) {
            System.out.println("Lista Segura: " + elemento);
        }

        // Teste usando tipos brutos
        List listaInsegura = new ArrayList();
        adicionarElementoListaInsegura(listaInsegura, "String");
        adicionarElementoListaInsegura(listaInsegura, 10); // Inserção de um inteiro em uma lista de strings

        // Iterando pela lista e tentando recuperar os elementos
        for (Object elemento : listaInsegura) {
            // Tentativa de cast para String
            String str = (String) elemento; // Isso lançará ClassCastException
            System.out.println("Lista Insegura: " + str);
        }


    }
}

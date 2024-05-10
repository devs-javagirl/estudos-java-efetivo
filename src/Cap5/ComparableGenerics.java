package Cap5;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ComparableGenerics {

    /*
    * EXEMPLO limites de Tipo Recursivo
    */

    public record Idade(int idade) implements Comparable<Idade> {
        @Override
        public int compareTo(Idade o) {
            return Integer.compare(idade, o.idade);
        }
    }

    public static void main(String[] args) {
        //Colecao de idades
        Collection<Idade> idades = List.of(new Idade(10), new Idade(20), new Idade(80));
        System.out.println("Idades: " + max(idades));
    }

    /*  Um uso comum dos limites de
        tipo recursivo é junto com a interface Comparable , que define o
        ordenamento natural de um tipo
    */

     public static <E extends Comparable<E>> E max(Collection<E> c) {
         if (c.isEmpty()) {
             throw new IllegalArgumentException("Empty collection");
         }
         E result = null;
         for (E e : c) {
             if (result == null || e.compareTo(result) > 0) {
                 result = Objects.requireNonNull(e);
             }
         }
         return result;
     }

}

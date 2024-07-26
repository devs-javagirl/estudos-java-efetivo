package Cap7;

import java.util.LinkedHashMap;
import java.util.Map;

public class LambdaLinkedHashMap {

    /**
     * Exemplo do LinkedHashMap:
     *
     * Padrão Tradicional: No uso tradicional do LinkedHashMap como cache, você sobrescreveria
     * o método removeEldestEntry para remover a entrada mais antiga quando o mapa atinge um certo tamanho.
     *
     * Com Lambdas: Se LinkedHashMap fosse projetado hoje, poderia oferecer um método fábrica
     * ou construtor que aceitasse uma BiPredicate<Map<K,V>, Map.Entry<K,V>>, que permitiria definir
     * a lógica de remoção diretamente como uma expressão lambda. Por exemplo:
     *
     * @param args
     */
    public static void main(String[] args) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 100; // Limita o tamanho do map a 100 entradas
            }
        };

        /*
            Neste exemplo, a função lambda passada para o construtor define que a entrada mais antiga
            deve ser removida se o tamanho do mapa exceder 100.
         */
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, 0.75f, true);
        //cache = new LinkedHashMap<>(16, 0.75f, true, (map, eldest) -> map.size() > 100);

    }
}

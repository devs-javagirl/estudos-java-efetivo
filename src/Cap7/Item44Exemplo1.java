package Cap7;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;

public class Item44Exemplo1 {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            //Modo tradicional de remover a entrada mais antiga
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 100; // Limita o tamanho do map a 100 entradas
            }
        };

        //Modo mais moderno
        //criar um bipredicate para remover a entrada mais antiga
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, 0.75f, true);
        BiPredicate<Map<String, Integer>,Map.Entry<String, Integer>> removeEldestEntry = (c, eldest) -> c.size() > 100;

        for (int i = 0; i < 105; i++) {
            cache.put("Key" + i, i);
            //usar teste do bipredicate para remover a entrada mais antiga do cache
            if (removeEldestEntry.test(cache, null)) {
                System.out.println("Removendo a entrada mais antiga do cache");
            }
        }

        // Exibindo o tamanho do map após a inserção de elementos
        System.out.println("Tamanho do map: " + cache.size());

        // Exibindo alguns elementos do map
        for (Map.Entry<String, Integer> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

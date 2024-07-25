package Cap7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Item44Exemplo1 {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > 100; // Limita o tamanho do map a 100 entradas
            }
        };

        for (int i = 0; i < 105; i++) {
            map.put("Key" + i, i);
        }

        // Exibindo o tamanho do map após a inserção de elementos
        System.out.println("Tamanho do map: " + map.size());

        // Exibindo alguns elementos do map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
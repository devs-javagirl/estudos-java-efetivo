package Cap5;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapGenericTest {

  @Test
  void testMapGeneric(){
    Map<String, String> map1 = Map.of("key3", "value3", "key2", "value2");
    Map<String, String> map2 = Map.of("key50", "value50", "key20", "value20");
    Map<String, Integer> map3 = Map.of("key50", 50, "key20", 20);

    MapGeneric map = new MapGeneric();
    Map<String, String> result = map.mapAll(map1, map2);

    System.out.println(result);

  }

}

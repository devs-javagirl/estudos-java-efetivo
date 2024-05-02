package Cap5;

import java.util.Map;
import java.util.TreeMap;

public class MapGeneric {

  public <K, V> Map<K, V> mapAll(Map<K, V> m1, Map<K, V> m2){
      Map<K, V> result = new TreeMap<>(m1);
      result.putAll(m2);
      return result;
  }

}

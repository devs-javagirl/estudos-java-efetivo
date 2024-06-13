package Cap5.HeterogeneousContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PropertyMap {

  private final Map<Property<?>, Object> properties = new HashMap<>();

  public <T> T getProperty(Property<T> property) {
    return property.getType().cast(properties.get(property));
  }

  public <T> void setProperty(Property<T> property, T value){
    properties.put(property, property.getType().cast(value));
  }

  @Override
  public String toString(){
    StringBuilder result = new StringBuilder();

    for(Entry<Property<?>, Object> property:properties.entrySet()){
      result.append(property.getKey()).append(": ").append(property.getValue()).append(" ");
    }

    return result.toString();
  }

}

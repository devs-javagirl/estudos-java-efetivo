package Cap5.HeterogeneousContainer;

import java.util.HashMap;
import java.util.Map;

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
    return properties.values().toString();
  }

}

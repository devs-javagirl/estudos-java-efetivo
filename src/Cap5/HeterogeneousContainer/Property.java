package Cap5.HeterogeneousContainer;

public class Property<T>{
  private final String name;
  private final Class<T> type;

  public Property(String name, Class<T> type) {
    this.name = name;
    this.type = type;

  }

  public Class<T> getType(){
    return type;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean equals(Object object) {
    if (object == this)
      return true;

    if (!(object instanceof Property))
      return false;

    Property<?> other = (Property<?>) object;
    return other.name.equals(name) && other.type.equals(type);
  }

  @Override
  public int hashCode(){
    int result = name.hashCode();
    result = 31 * result + type.hashCode();
    return result;
  }
}

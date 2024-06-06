package Cap5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GenericContainers {

  public static class Favorites {
    private final Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
      favorites.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getFavorite(Class<T> type) {
      return type.cast(favorites.get(type));
      // Linha abaixo é teste, funciona mas deixa warning de Unchecked cast
      // return (T)favorites.get(type);
    }

  }

  public static void main(String[] args) {
    Favorites f = new Favorites();
    f.putFavorite(String.class, "Java");
    f.putFavorite(Integer.class, 43);
    f.putFavorite(Class.class, Favorites.class);

    //Linha abaixo é teste, erro em tempo de execução NullPointerException
    //f.putFavorite(null, Favorites.class);

    String favoriteString = f.getFavorite(String.class);
    int favoriteInteger = f.getFavorite(Integer.class);
    Class<?> favoriteClass = f.getFavorite(Class.class);

    System.out.printf("%s %d %s%n", favoriteString,
        favoriteInteger, favoriteClass.getName());
  }
}

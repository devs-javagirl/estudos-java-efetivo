package Cap6;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class PlantEnumMap {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNAL }

    final String name;
    final PlantEnumMap.LifeCycle lifeCycle;

    PlantEnumMap (String name, PlantEnumMap.LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    private static void printUsingEnumMap(List<PlantEnumMap> garden) {
        Map<LifeCycle, Set<PlantEnumMap>> plantsByLifeCycle =
                new EnumMap<>(PlantEnumMap.LifeCycle.class);

        for(PlantEnumMap.LifeCycle lc : PlantEnumMap.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

        for(PlantEnumMap p: garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }

    private static void printUsingBasicStream(List<PlantEnumMap> garden) {
        System.out.println(garden.stream().collect(groupingBy(c -> c.lifeCycle)));
    }

    private static void printUsingEnumMapStream(List<PlantEnumMap> garden) {
        System.out.println(garden.stream().collect(groupingBy(PlantEnumMap::getLifeCycle,
                () -> new EnumMap<>(LifeCycle.class), toSet())));
    }

    private LifeCycle getLifeCycle() {
        return this.lifeCycle;
    }

    public static void main(String[] args) {
        List<PlantEnumMap> garden = new ArrayList<>();
        garden.add(new PlantEnumMap("Rose", PlantEnumMap.LifeCycle.ANNUAL));
        garden.add(new PlantEnumMap("Daisy", PlantEnumMap.LifeCycle.PERENNIAL));
        //garden.add(new PlantEnumMap("Orchidea", LifeCycle.BIENNAL));

        printUsingEnumMap(garden);
        printUsingBasicStream(garden);
        printUsingEnumMapStream(garden);
    }
}

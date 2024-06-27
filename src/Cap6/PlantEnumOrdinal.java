package Cap6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlantEnumOrdinal {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNAL }

    final String name;
    final LifeCycle lifeCycle;

    PlantEnumOrdinal (String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    // EXEMPLO NÃO RECOMENDADO
    public static void main(String[] args) {
        List<PlantEnumOrdinal> garden = new ArrayList<>();
        garden.add(new PlantEnumOrdinal("Rose", LifeCycle.ANNUAL));
        garden.add(new PlantEnumOrdinal("Daisy", LifeCycle.PERENNIAL));

        Set<PlantEnumOrdinal>[] plantsByLifeCycle = (Set<PlantEnumOrdinal>[]) new Set[PlantEnumOrdinal.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        //NÃO USAR O ORDINAL() PARA INDEXAR DENTRO DO ARRAY - NÃO FAÇA ISSO
        for (PlantEnumOrdinal p: garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);

        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", PlantEnumOrdinal.LifeCycle.values()[i],plantsByLifeCycle[i]);
        }
    }
}

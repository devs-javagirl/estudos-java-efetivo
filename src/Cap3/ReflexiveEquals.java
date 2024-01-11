package Cap3;

import java.util.Objects;

public class ReflexiveEquals {

    private int value;

    public ReflexiveEquals(int value) {
        this.value = value;
    }

    // Construtor, getters e setters

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ReflexiveEquals other = (ReflexiveEquals) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(/* atributos relevantes para a comparação */);
    }

}

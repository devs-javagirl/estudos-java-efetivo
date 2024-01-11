package Cap3;

import java.util.Objects;

public class TransitiveEquals {

    private int value;

    public TransitiveEquals(int value) {
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
        TransitiveEquals other = (TransitiveEquals) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(/* atributos relevantes para a comparação */);
    }

}

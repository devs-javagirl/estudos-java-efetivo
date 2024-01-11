package Cap3;

import java.util.Objects;

public class ConsistentEquals {

    private int value;

    public ConsistentEquals(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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
            ConsistentEquals other = (ConsistentEquals) obj;
            return value == other.value;
        }

    @Override
    public int hashCode() {
        return Objects.hash(/* atributos relevantes para a comparação */);
    }


}

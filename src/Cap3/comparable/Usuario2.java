package Cap3.comparable;

import java.time.LocalDate;
import java.util.Comparator;

public class Usuario2 implements Comparable {

    private String name;

    private String email;

    private LocalDate nascimento;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    private static final Comparator<Usuario2> COMPARATOR =
            Comparator.comparing(Usuario2::getName)
                    .thenComparing(Usuario2::getName);

    @Override
    public int compareTo(Object o) {
        Usuario2 usuario = (Usuario2) o;
        return COMPARATOR.compare(this,usuario);
    }

}

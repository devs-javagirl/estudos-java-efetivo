package Cap3.comparable;

import java.time.LocalDate;

public class Usuario1 implements Comparable {

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

    public Usuario1(String name, String email, LocalDate nascimento) {
        this.name = name;
        this.email = email;
        this.nascimento = nascimento;
    }

    @Override
    public int compareTo(Object o) {
        Usuario1 usuario = (Usuario1) o;
        return this.nascimento.compareTo(usuario.nascimento);

    }

    @Override
    public String toString() {
        return "\nUsuario1{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }
}

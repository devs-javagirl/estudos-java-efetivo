package Cap3;

import java.util.Objects;

public class Cliente {

    Integer id;
    String cpf;
    String nome;

    public Cliente(Integer id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getCpf(), cliente.getCpf());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

   */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return getCpf().equals(cliente.getCpf()) && getNome().equals(cliente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf(), getNome());
    }

}

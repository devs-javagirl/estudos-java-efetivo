package Cap3.comparable;

import java.time.LocalDate;
import java.util.TreeSet;

public class ComparableTest {

    public static void main(String[] args) {

        Usuario1 usuario1 = new Usuario1("Ana", "teste1@email.com", LocalDate.of(2024, 1, 31));
        Usuario1 usuario2 = new Usuario1("Beatriz", "teste1@email.com", LocalDate.of(2024, 1, 31));
        Usuario1 usuario3 = new Usuario1("Maria", "teste1@email.com", LocalDate.of(2024, 1, 1));
        Usuario1 usuario4 = new Usuario1("Cris", "teste1@email.com", LocalDate.of(2020, 5, 31));
        Usuario1 usuario5 = new Usuario1("Camila", "teste1@email.com", LocalDate.of(2018, 5, 31));
        Usuario1 usuario6 = new Usuario1("Xuxa", "teste1@email.com", LocalDate.of(2024, 2, 2));

        TreeSet<Usuario1> setList = new TreeSet<>();
        //TreeSet e TreeMap
        setList.add(usuario1);
        setList.add(usuario2);
        setList.add(usuario3);
        setList.add(usuario4);
        setList.add(usuario5);
        setList.add(usuario6);

        System.out.println(setList);
    }

}

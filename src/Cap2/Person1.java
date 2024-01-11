package Cap2;

public class Person1 {
    private String name;
    private int age;

    private Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /** STATIC FACTORY METHOD */
    public static Person1 createPerson(String name, int age) {
        // Validar os parâmetros, executar lógica adicional, etc.
        if (age >= 0 && name != null && !name.isEmpty()) {
            return new Person1(name, age);
        } else {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

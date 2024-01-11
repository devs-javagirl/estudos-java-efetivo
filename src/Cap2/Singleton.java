package Cap2;

public class Singleton {

    // A instância única da classe Singleton
    private static Singleton instance;

    // Construtor privado para evitar a criação de instâncias a partir de fora da classe
    private Singleton() {
        // Inicialização da instância, se necessário
    }

    // Método público para obter a instância única da classe Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            // Se a instância ainda não foi criada, crie-a
            instance = new Singleton();
        }
        return instance;
    }

    // Outros métodos e propriedades da classe Singleton
}

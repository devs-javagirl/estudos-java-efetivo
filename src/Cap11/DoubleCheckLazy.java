package Cap11;

public class DoubleCheckLazy {

    private volatile FieldType field; // O recurso que queremos inicializar de forma segura.

    // M�todo para inicializar e obter o recurso de forma segura.
    FieldType getField() {
        FieldType result = field;
        if (result == null) { // Primeira verifica��o (sem bloqueio)
            synchronized (this) {
                result = field;
                if (result == null) { // Segunda verifica��o (com bloqueio)
                    field = result = computeFieldValue();
                }
            }
        }
        return result;
    }

    // M�todo que simula o c�lculo/inicializa��o do valor do campo.
    private FieldType computeFieldValue() {
        System.out.println("Inicializando o recurso...");
        return new FieldType("Valor Inicializado");
    }
}

// Classe simulada para o tipo do campo.
class FieldType {
    private final String value;

    public FieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static void main(String[] args) {
        DoubleCheckLazy example = new DoubleCheckLazy();

        // Cria v�rias threads para acessar o m�todo getField simultaneamente.
        Runnable task = () -> {
            FieldType field = example.getField();
            System.out.println(Thread.currentThread().getName() + ": " + field.getValue());
        };

        // Inicia v�rias threads.
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}


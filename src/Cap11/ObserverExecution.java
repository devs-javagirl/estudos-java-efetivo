package Cap11;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverExecution {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

        //populateSet(set);
        //populateWithRemove(set);
        populateWithThread(set);
    }

    private static void populateSet(ObservableSet<Integer> set) {
        // adiciona fun��o que ser� executada no notify
        // executa sem erros
        set.addObserver((s, e) -> System.out.println("tamanho " + s.size() + " elemento " + e));

        for (int i = 0; i < 100; i++)
            set.add(i);
    }

    private static void populateWithRemove(ObservableSet<Integer> set) {
        // Adiciona comportamento da fun��o addObserver, que ser� executada pelo notify
        // Se na classe ObservableSet os m�todos addObserver e removeObserver estiverem utilizando syncronized,
        // ou a vari�vel collection seja um ArrayList, lan�a ConcurrentModificationException
        // Isto ocorre pq est� adicionando os itens na cole��o e tenta remover um item, dentro de m�todos syncronized
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    System.out.println("removing item 23");
                    s.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }

    private static void populateWithThread(ObservableSet<Integer> set) {
        // N�o d� erro, mas trava execu��o
        // Se na classe ObservableSet os m�todos addObserver e removeObserver estiverem utilizando syncronized,
        // ou a vari�vel collection seja um ArrayList, trava a execu��o
        // Isto ocorre pq est� adicionando os itens na cole��o e tenta remover um item, dentro de m�todos syncronized
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if(element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        exec.submit(() -> set.removeObserver(this)).get();

                    } catch (ExecutionException | InterruptedException ex){
                        throw new AssertionError(ex);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}

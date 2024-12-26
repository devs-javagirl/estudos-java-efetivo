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
        // adiciona função que será executada no notify
        // executa sem erros
        set.addObserver((s, e) -> System.out.println("tamanho " + s.size() + " elemento " + e));

        for (int i = 0; i < 100; i++)
            set.add(i);
    }

    private static void populateWithRemove(ObservableSet<Integer> set) {
        // Adiciona comportamento da função addObserver, que será executada pelo notify
        // Se na classe ObservableSet os métodos addObserver e removeObserver estiverem utilizando syncronized,
        // ou a variável collection seja um ArrayList, lança ConcurrentModificationException
        // Isto ocorre pq está adicionando os itens na coleção e tenta remover um item, dentro de métodos syncronized
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
        // Não dá erro, mas trava execução
        // Se na classe ObservableSet os métodos addObserver e removeObserver estiverem utilizando syncronized,
        // ou a variável collection seja um ArrayList, trava a execução
        // Isto ocorre pq está adicionando os itens na coleção e tenta remover um item, dentro de métodos syncronized
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

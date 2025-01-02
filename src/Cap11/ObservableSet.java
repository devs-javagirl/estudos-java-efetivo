package Cap11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSet<E> extends FowardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> collection = new ArrayList<>();
    // O metodo CopyOnWriteArrayList é uma variante de ArrayList em que todas as
    // operações são implementadas fazendo uma cópia nova do array, evitando
    // erro de concorrência
    //private final List<SetObserver<E>> collection = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        synchronized(collection) {
            collection.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized(collection) {
            return collection.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        // A implementação abaixo pode gerar erros de concorrência e deadlock,
        // pois depende de como foi implementada a função added, que pode manipular
        // os elementos do array de forma indevida.
         synchronized(collection) {
             for (SetObserver<E> observer: collection)
                 observer.added(this, element);
         }

        // A implementação abaixo, resolve o problema de concorrência,
        // pois executa o syncronized somente quando faz a cópia do array
        // Deve-se evitar utilizar o syncronized com um objeto de função a ser
        // implementado pelo cliente
        // List<SetObserver<E>> snapshot = null;
        // synchronized (collection) {
        //     snapshot = new ArrayList<>(collection);
        //}



        // Se estiver utilizando CopyOnWriteArrayList, a implementação abaixo
        // não gera erro de ConcurrentModificationException
        // for (SetObserver<E> observer : collection) {
        //    observer.added(this, element);
        // }

    }

    @Override
    public boolean add (E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element: c)
            result |= add(element); // Chama a notifyElementAdded

        return result;
    }

}

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
    // O metodo CopyOnWriteArrayList � uma variante de ArrayList em que todas as
    // opera��es s�o implementadas fazendo uma c�pia nova do array, evitando
    // erro de concorr�ncia
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
        // A implementa��o abaixo pode gerar erros de concorr�ncia e deadlock,
        // pois depende de como foi implementada a fun��o added, que pode manipular
        // os elementos do array de forma indevida.
         synchronized(collection) {
             for (SetObserver<E> observer: collection)
                 observer.added(this, element);
         }

        // A implementa��o abaixo, resolve o problema de concorr�ncia,
        // pois executa o syncronized somente quando faz a c�pia do array
        // Deve-se evitar utilizar o syncronized com um objeto de fun��o a ser
        // implementado pelo cliente
        // List<SetObserver<E>> snapshot = null;
        // synchronized (collection) {
        //     snapshot = new ArrayList<>(collection);
        //}



        // Se estiver utilizando CopyOnWriteArrayList, a implementa��o abaixo
        // n�o gera erro de ConcurrentModificationException
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

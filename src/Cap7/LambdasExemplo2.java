package Cap7;

import java.time.Instant;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Aqui est�o exemplos de antes e depois para cada tipo de refer�ncia de m�todo mencionada no livro:
public class LambdasExemplo2 {

    /** 1. Refer�ncia para M�todo Est�tico
    Fun��o: Utiliza um m�todo est�tico de uma classe.
    Exemplo: Convers�o de string para inteiro.
    */
    private void ReferenciaParaMetodoEstatico() {
        //Antes
        Function<String, Integer> parseInt1 = str -> Integer.parseInt(str);
        //Depois
        Function<String, Integer> parseInt2 = Integer::parseInt;
    }

    /** 2. Refer�ncia para M�todo de Inst�ncia Limitada
     * Fun��o: Aplica um m�todo de inst�ncia j� existente em um objeto espec�fico.
     * Exemplo: Verifica se um instante no tempo � posterior a um momento fixo (now).
     */
    private void ReferenciaParaMetodoDeInstanciaLimitada() {
        //Antes
        Instant now = Instant.now();
        Predicate<Instant> isAfterNow1 = t -> now.isAfter(t);
        isAfterNow1.test(now);

        //Depois
        Predicate<Instant> isAfterNow2 = now::isAfter;
        isAfterNow2.test(now);

        Predicate<String> isEmpty = String::isEmpty;
        isEmpty.test("Teste");

    }

    /** 3. Refer�ncia para M�todo de Inst�ncia Ilimitada
     * Fun��o: Aplica um m�todo de inst�ncia de uma classe para qualquer inst�ncia da classe.
     * Exemplo: Converte uma string para min�sculas.
     */
    private void ReferenciaParaMetodoDeInstanciaIlimitada() {
        //Antes
        Function<String, String> toLowerCase1 = string -> string.toLowerCase();
        toLowerCase1.apply("TESTE");

        //Depois
        Function<String, String> toLowerCase2 = String::toLowerCase;
    }

    /** 4. Refer�ncia para Construtor de Classe
     * Fun��o: Cria uma nova inst�ncia de uma classe.
     * Exemplo: Cria��o de um novo TreeMap.
     */
    private void ReferenciaParaConstrutorDeClasse() {
        //Antes
        Supplier<TreeMap<String, Integer>> newTreeMap0 = new Supplier<TreeMap<String, Integer>>() {
            @Override
            public TreeMap<String, Integer> get() {
                return null;
            }
        };
        newTreeMap0.get();

        //Antes
        Supplier<TreeMap<String, Integer>> newTreeMap1 = () -> new TreeMap<>();
        //Depois
        Supplier<TreeMap<String, Integer>> newTreeMap2 = TreeMap::new;
    }

    /** 5. Refer�ncia para Construtor de Array
     * Fun��o: Cria um novo array de um determinado tamanho.
     * Exemplo: Cria��o de um novo array de inteiros de um tamanho espec�fico.
     */
    private void ReferenciaParaConstrutorDeArray() {
        //Antes
        IntFunction<int[]> createArray = len -> new int[len];
        //Depois
        IntFunction<int[]> createArray2 = int[]::new;
    }

    public static void main(String[] args) {

    }


}

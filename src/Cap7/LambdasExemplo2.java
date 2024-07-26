package Cap7;

import java.time.Instant;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

//Aqui estão exemplos de antes e depois para cada tipo de referência de método mencionada no livro:
public class LambdasExemplo2 {

    /** 1. Referência para Método Estático
    Função: Utiliza um método estático de uma classe.
    Exemplo: Conversão de string para inteiro.
    */
    private void ReferenciaParaMetodoEstatico() {
        //Antes
        Function<String, Integer> parseInt1 = str -> Integer.parseInt(str);
        //Depois
        Function<String, Integer> parseInt2 = Integer::parseInt;
    }

    /** 2. Referência para Método de Instância Limitada
     * Função: Aplica um método de instância já existente em um objeto específico.
     * Exemplo: Verifica se um instante no tempo é posterior a um momento fixo (now).
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

    /** 3. Referência para Método de Instância Ilimitada
     * Função: Aplica um método de instância de uma classe para qualquer instância da classe.
     * Exemplo: Converte uma string para minúsculas.
     */
    private void ReferenciaParaMetodoDeInstanciaIlimitada() {
        //Antes
        Function<String, String> toLowerCase1 = string -> string.toLowerCase();
        toLowerCase1.apply("TESTE");

        //Depois
        Function<String, String> toLowerCase2 = String::toLowerCase;
    }

    /** 4. Referência para Construtor de Classe
     * Função: Cria uma nova instância de uma classe.
     * Exemplo: Criação de um novo TreeMap.
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

    /** 5. Referência para Construtor de Array
     * Função: Cria um novo array de um determinado tamanho.
     * Exemplo: Criação de um novo array de inteiros de um tamanho específico.
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

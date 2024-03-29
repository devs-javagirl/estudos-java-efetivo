package Cap4.classlimit;

public class LimitWrong {
    public static void main(String[] args) {
        Utensil utensil = new Utensil();
        Dessert dessert = new Dessert();
        System.out.println(dessert.getName());
        System.out.println(utensil.getName());
    }
}

class Dessert {
    public String getName() {
        return "pancake";
    }
}

class Utensil {
    public String getName() {
        return "apple";
    }
    // Outra classe de nível superior definida em outro arquivo
}


/**
 * Este exemplo é ruim porque mostra como a definição de múltiplas classes de nível superior em um único arquivo fonte pode levar a problemas de compilação e comportamento inconsistente do programa. Aqui estão algumas razões pelas quais este exemplo é ruim:
 *
 * Ambiguidade na Definição das Classes: Como as classes Utensil e Dessert são definidas em arquivos separados, não está claro para o compilador qual definição usar quando ambas são referenciadas na classe Main.
 *
 * Possibilidade de Múltiplas Definições: Se as classes Utensil e Dessert forem definidas em arquivos separados e também em um único arquivo, isso cria a possibilidade de múltiplas definições para essas classes, dependendo da ordem em que os arquivos são passados para o compilador.
 *
 * Comportamento Inconsistente do Programa: Dependendo da ordem em que os arquivos são compilados, o comportamento do programa pode variar. Por exemplo, se o compilador encontrar primeiro o arquivo Utensil.java e depois Dessert.java, o programa pode imprimir "pancake". No entanto, se a ordem for invertida, o programa pode imprimir algo diferente.
 *
 * Dificuldade de Manutenção e Depuração: Este tipo de estrutura dificulta a manutenção e a depuração do código, pois não está claro qual definição de classe está sendo usada em um determinado momento.
 *
 * Portanto, para evitar esses problemas, é uma boa prática limitar os arquivos fonte a uma única classe de nível superior e dividir as classes em arquivos separados. Isso garante consistência no comportamento do programa e facilita a manutenção do código.
 */


package Cap7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class LambdaRinaldoDev {

    // Link para conteúdo Rinaldo Dev
    // https://www.youtube.com/watch?v=lbCYLgoVpfQ&list=PLuYctAHjg89ZkhgOQo0zcTtmHY5nuRYud

    // SAM - Single Abstract Method : Qualquer interface que tenha apenas um método abstrato
    // @FunctionalInterface : notação indicativa, na compilação obriga a classe a ter UM método
    // abstrato (seguir o padrão SAM). A anotação não é obrigatória.
    // Expressão LAMBDA: lado esquerdo parâmetro -> lado direito implementação
    //    neste caso não recebe parâmetro: () -> System.out.println("JConf dia 03/08/2024")
    // Lambdas foram criadas para utilizar Streams, que é um fluxo de dados

    public static void main(String[] args) {
        // Como se instanciava Thread antes do Java 8
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JConf dia 03/08/2024");
            }
        }).run();

        // Thread utilizando lambda
         new Thread(() -> System.out.println("JConf dia 03/08/2024")).run();


        JButton jButton1 = new JButton();
        // Como se instanciava ActionListener antes do Java 8
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello");
            }
        });

        JButton jButton2 = new JButton();
        // Action Listener usando Java 8
        // Apesar do método não estar escrito abstract, o método da interface é abstrato
        // ActionListener.java: public void actionPerformed(ActionEvent e);
        jButton2.addActionListener(e -> System.out.println("Hello"));

        // Examplo de implementação da interface funcional FunctionCustom
        FunctionCustom function = (x) -> "O número informado é " + x;
        System.out.println(function.apply(5));
    }
}

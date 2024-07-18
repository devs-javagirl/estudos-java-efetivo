package Cap7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class LambdaRinaldoDev {

    // Link para conte�do Rinaldo Dev
    // https://www.youtube.com/watch?v=lbCYLgoVpfQ&list=PLuYctAHjg89ZkhgOQo0zcTtmHY5nuRYud

    // SAM - Single Abstract Method : Qualquer interface que tenha apenas um m�todo abstrato
    // @FunctionalInterface : nota��o indicativa, na compila��o obriga a classe a ter UM m�todo
    // abstrato (seguir o padr�o SAM). A anota��o n�o � obrigat�ria.
    // Express�o LAMBDA: lado esquerdo par�metro -> lado direito implementa��o
    //    neste caso n�o recebe par�metro: () -> System.out.println("JConf dia 03/08/2024")
    // Lambdas foram criadas para utilizar Streams, que � um fluxo de dados

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
        // Apesar do m�todo n�o estar escrito abstract, o m�todo da interface � abstrato
        // ActionListener.java: public void actionPerformed(ActionEvent e);
        jButton2.addActionListener(e -> System.out.println("Hello"));

        // Examplo de implementa��o da interface funcional FunctionCustom
        FunctionCustom function = (x) -> "O n�mero informado � " + x;
        System.out.println(function.apply(5));
    }
}

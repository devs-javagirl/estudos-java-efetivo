package Cap5;

import java.util.ArrayList;
import java.util.List;

public class ChooserTest {

        public static void main(String[] args) {
            Chooser<String> chooser = new Chooser<>(List.of("OpenAI", "ChatGPT", "GPT-4"));
            Chooser<Integer> chooserIntegers = new Chooser<>(List.of(2, 5, 8));

            System.out.println(chooser.choose());
            chooser.addChoice("GPT-5");
            System.out.println(chooser);

            System.out.println(chooserIntegers.choose());
            chooserIntegers.addChoice(10);
            System.out.println(chooserIntegers);
        }
}

package Cap5;

public class GenericStackTest {

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("OpenAI");
        stack.push("ChatGPT");
        stack.push("GPT-4");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }


    }


}

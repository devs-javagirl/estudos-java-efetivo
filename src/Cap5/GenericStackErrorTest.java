package Cap5;

public class GenericStackErrorTest {

    public static void main(String[] args) {
        GenericStackError<String> stack = new GenericStackError<>();
        stack.push("OpenAI");
        stack.push("ChatGPT");
        stack.push("GPT-4");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }


    }


}

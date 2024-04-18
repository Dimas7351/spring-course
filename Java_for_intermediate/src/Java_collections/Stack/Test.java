package Java_collections.Stack;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        // LIFO
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek());

        while(!stack.empty())
            System.out.println(stack.pop());
    }
}

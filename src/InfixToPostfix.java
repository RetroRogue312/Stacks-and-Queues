import java.util.Stack;

public class InfixToPostfix
{
    public static int precedence(char op)
    {
        if (op == '^')
            return 3;
        if (op == '*' || op == '/')
            return 2;
        if (op == '+' || op == '-')
            return 1;
        return 0;
    }

    public static String infixtoPostfix(String s)
    {
        Stack<Character> stack = new Stack<>();
        String postfix = "";

        for (int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c))
                postfix += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postfix += stack.pop();
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c))
                    postfix += stack.pop();
                stack.push(c);
            }
        }
        while (!stack.isEmpty())
            postfix += stack.pop();
        return postfix;
    }

    public static void main(String[] args)
    {
        System.out.println(infixtoPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}

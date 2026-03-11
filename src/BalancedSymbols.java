import java.util.Stack;
public class BalancedSymbols
{
    public static String isBalanced(String s)
    {
        Stack<Character> openStack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {

            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[' || c == '<' || c == '¿')
            {
                openStack.push(c);
            }else{
                if (openStack.isEmpty())
                    return "NO";
                char open = openStack.pop();
                if ((c == ')' && open != '(')||
                        (c == '}' && open != '{')||
                        (c == ']' && open != '[')||
                        (c == '>' && open != '<')||
                        (c == '?' && open != '¿'))
                {
                    return "NO";
                }
            }
        }
        if (openStack.isEmpty())
        {
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args)
    {
        String input = "{[(})}";
        String input2 = "(([[{{}}]]))";
        String input3 = "(((()))";
        System.out.println(isBalanced(input));
        System.out.println(isBalanced(input2));
        System.out.println(isBalanced(input3));

    }
}

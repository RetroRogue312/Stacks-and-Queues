import java.util.Stack;
public class DecodeString
{
    public static String decodeString(String s)
    {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        String current = "";
        int num = 0;

        for (int i = 0; i < s.length();i++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                num = num * 10 + (c - '0');
            }
            else if (c == '[')
            {
                numbers.push(num);
                strings.push(current);
                num = 0;
                current = "";
            }
            else if (c == ']')
            {
                int repCount = numbers.pop();
                String previous = strings.pop();
                String tmp = "";
                for (int j = 0; j < repCount; j++)
                {
                    tmp += current;
                }
                current = previous + tmp;
            }
            else
                current += c;
        }
        return current;
    }

    public static void main(String[] args)
    {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));

    }
}

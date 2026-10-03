

public class SyntaxChecker {

    public static boolean isBalanced (String line) {

        Stack<Character> buffer = new ArrayStack<>(line.length()); //Declaring element type character here

        //For loop to inspect every string character
        for (char c: line.toCharArray()) {
            //Checks for opening brackets
            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c); //Stores the opening bracket
            } else if (c == ')' || c == '}' || c == ']') { //Checks for ending brackets
                if (buffer.isEmpty()) { //See is storage is empty (if it is, means unbalanced syntax)
                    return false;
                }

                char topSymbol = buffer.pop(); //

                //Only checks for brackets, skips everything else
                if ((c == ')' && topSymbol != '(' ||
                    c == '}' && topSymbol !='{' ||
                    c == ']' && topSymbol != '[')) {
                    return false;
                }
            }

        }
        return buffer.isEmpty(); //Returns true (i.e. brackets have pair, meaning stack is empty), returns false if they do (no pair found)
    }



    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}

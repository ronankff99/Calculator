import java.util.Stack;

//To be reworked
public class Calculator
{

    public static void main(String[] args)
    {
        String test = "( 2 * 44.85 ) - ( 6 / 2 )";
        calculator(test);

    }

    //Implementation is based off Dijkstra's Two Stack Algorithm
    //Can add operators later :)
    //http://www.wisenheimerbrainstorm.com/archive/algorithms/dijkstra-s-two-stack-algorithm
    static void calculator(String calculation)
    {
        String[] expression = calculation.split("\\s");
        var operands = new Stack<String>();
        var values = new Stack<Double>();

        for (String token : expression)
        {
            if (token.equals("("))
            {
                //Do nothing
            }
            else if (token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-"))
            {
                operands.push(token);
            }
            else if (token.equals(")"))
            {
                quickMaths(operands, values);
            }
            else
            {
                values.push(Double.parseDouble(token));
            }
        }

        quickMaths(operands, values);
        System.out.println(values.pop());

    }

    //This is a stupid, stupid name for this function
    static void quickMaths(Stack<String> operands, Stack<Double> values)
    {
        //Making this a string because I was thinking if you wanted to use operators like sqrt in the future
        String operator = operands.pop();
        Double value = values.pop();
        switch (operator)
        {
            case "+":
                value = values.pop() + value;
                break;
            case "*":
                value = values.pop() * value;
                break;
            case "/":
                value = values.pop() / value;
                break;
            case "-":
                value = values.pop() - value;
                break;
        }
        values.push(value);
    }
}


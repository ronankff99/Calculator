import java.util.Stack;

//To be reworked
public class Calculator {

    public static void main(String[] args) {
        String test = "(2+2)/2";
        calculator(test);

    }

    //Implementation is based off Dijkstra's Two Stack Algorithm
    //Can add operators later, is this better as a switch?
    //http://www.wisenheimerbrainstorm.com/archive/algorithms/dijkstra-s-two-stack-algorithm
    static void calculator(String calculation) {
        String exp[] = calculation.split("");
        var operands = new Stack<String>();
        var values = new Stack<Double>();

        for (String s : exp) {
            if (s.equals("(")) {
                //Do nothing
            } else if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
                operands.push(s);
            } else if (s.equals(")")) {
                quickMaths(operands, values);
            } else {
                values.push(Double.parseDouble(s));
            }
        }

        quickMaths(operands, values);
        System.out.println(values.pop());

    }

    //This is a stupid, stupid name for this function
    static void quickMaths(Stack<String> operands, Stack<Double> values) {
        //Making this a string because I was thinking if you wanted to use operators like sqrt in the future
        String operator = operands.pop();

        switch (operator) {
            case "+":
                values.push(values.pop() + values.pop());
                break;
            case "*":
                values.push(values.pop() * values.pop());
                break;
            case "/":
                values.push(values.pop() / values.pop());
                break;
            case "-":
                values.push(values.pop() - values.pop());
                break;
        }
    }
}


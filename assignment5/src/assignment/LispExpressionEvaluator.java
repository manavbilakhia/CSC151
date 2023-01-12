package assignment;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
/**
 * This class evaluates a simple arithmetic Lisp expression of numeric values.
 *
 * @author Charles Hoot
 * @author Jesse Grabowski
 * @author Joseph Erickson
 * @author Zeynep Orhan modified
 * @version 5.0
 */
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * @author Manav Bilakhia (MB)
 * @author Saeed AlSuwaidi
 * @author Jason D'Amico
 */
public class LispExpressionEvaluator {
    /**
     * Evaluates a Lisp expression.
     *
     * The algorithm: Scan the tokens in the string.
     * If you see "(", push the next operator onto the stack.
     * If you see an operand, push it onto the stack.
     * If you see ")", Pop operands and push them onto a second stack until you find an
     * operator. Apply the operator to the operands on the second stack. Push the
     * result on the stack.
     *
     * What may occur? (Samples only)
     * If you run out of tokens, the value on the top
     * of the stack is the value of the expression.
     * OR
     * How to detect illegal expressions:
     * If you read numeric values and the
     * expression stack is empty
     * Error message: Bad Expression: needs an operator for the data
     *
     * If there is a ) and the expression stack is empty
     * Error message: mismatched )
     *
     * If there is a ) and operands needed but the expression stack is empty
     * Error message: mismatched )
     *
     * If the top operator requires at least one operand but it is not in the expression stack
     * Error message:operator nameOfTheOperand + " requires at least one operand"
     *
     * If the string does not have any more characters but the expression stack is not empty
     * Error message:incomplete expression / multiple expressions
     *
     * If the operator is not one of the +, -, *, ?
     * Error message: found an operator when we should not
     *
     * If the expression is legal
     * Message:" and evaluates to " + whateverTheResultIs
     *
     *
     *
     *
     * Format of sample messages:
     * Message for a legal expression
     *
     * The expression '(+ (- 1) (* 3 3 4) (/ 3 2 3) (* 4 4))' is legal in Lisp:
     * and evaluates to 51.5
     *
     * Message for an illegal expression
     *
     * The expression '(+ (-) (* 3 3 4) (/ 3 2 3) (* 4 4))' is not legal in Lisp:
     * operator - requires at least one operand
     *
     * @param lispExp A string that is a valid lisp expression.
     * @param mes An ArrayList of strings that stores the messages generated.
     * @return A double that is the value of the expression.
     */
    @SuppressWarnings("resource")
    public static double evaluate(String lispExp, ArrayList<String> mes) {
        StackInterface<LispToken> expressionStack = new OurStack<>();
        StackInterface<LispToken> secondStack = new OurStack<>();
        boolean nextIsOperator = false;
        Scanner lispExpScanner = new Scanner(lispExp);
        // Use zero or more white spaces as delimiter
        // that breaks the string into single characters
        lispExpScanner = lispExpScanner.useDelimiter("\\s*");
        boolean legal = true;
        String errorMessage = "";
        // Hint: use
        // lispExpScanner.hasNext() to test if there are more tokens
        // lispExpScanner.hasNextInt() to test if there is an integer
        // lispExpScanner.next() to get the next String

        while (lispExpScanner.hasNext() && legal) {
            // Handles next value in scanner

            if (lispExpScanner.hasNextInt()) {
                double expression = lispExpScanner.nextDouble();
                expressionStack.push(new LispToken(expression));

            } else {
                // Assertion: next value in scanner is a character (i.e., non-numeric value)
                char next = lispExpScanner.next().charAt(0);

                if (next == '(') {
                    // Action: push next operator onto the stack

                    if (!lispExpScanner.hasNextInt()) {
                        // Assertion: next value in scanner is an operator
                        char Operator = lispExpScanner.next().charAt(0);
                        expressionStack.push(new LispToken(Operator));

                    } else {
                        // Assertion: error; next number is not an operator
                        legal = false;
                        errorMessage = "unknown operator";
                    }
                } else if (next == ')') {
                    if (expressionStack.isEmpty()) {
                        // Assertion: expression stack is empty, thus no operation can be performed
                        legal = false;
                        errorMessage = "mismatched )";
                    } else {
                        int counter = 0;

                        // Action: pop operands until an operator is found

                        while (!expressionStack.isEmpty() && !expressionStack.peek().isOperator()) {
                            // Assertion: current top item of stack is an operand
                            LispToken operand = expressionStack.pop();
                            secondStack.push(operand);
                            counter++;
                        }

                        if (expressionStack.isEmpty()) {
                            // Since the stack is empty, there is no operator at the end of the list of operands (thus causing a mismatched ')' error)
                            legal = false;
                            errorMessage = "mismatched )";
                        } else {
                            // Action: Performing operation

                            LispToken operator = expressionStack.pop();
                            Double result = 0.0;

                            if (counter >= 1) {
                                result = secondStack.pop().getValue();

                                if (counter == 1) {
                                    // TODO: Need a comment here explaining why identity is used
                                    result = operator.applyOperator(operator.getIdentity(), result);
                                } else {
                                    while(!secondStack.isEmpty()) {
                                        result = operator.applyOperator(result, secondStack.pop().getValue());
                                    }
                                }
                            } else if (counter == 0) {
                                if (operator.takesZeroOperands()) {
                                    result = operator.getIdentity();
                                } else {
                                    legal = false;
                                    errorMessage = "operator " + operator + " requires at least one operand";
                                }
                            }

                            // Result of operation pushed to expression stack
                            expressionStack.push(new LispToken(result));
                        }
                    }
                } else {
                    // Assertion: character is an operator (should only be added after parentheses)
                    legal = false;
                    errorMessage = "found an operator when we should not";
                }
            }
        }

        // Message creation

        String message = "";
        double value = 0.0;

        // Message handling for legal lisp
        if (legal) {
            value = expressionStack.pop().getValue();

            if (!expressionStack.isEmpty()) {
                // Assertion: the lisp was processed without any errors, but there are multiple items in the expression stack (implying an incomplete expression / multiple expressions error)
                errorMessage = "incomplete expression / multiple expressions";
                legal = false;
            }

            message = "The expression '" + lispExp + "'\nis legal in Lisp:\nand evaluates to " + value + "\n";
        }

        // Message handling for illegal lisp
        if (!legal) {
            message = "The expression '" + lispExp + "'\nis not legal in Lisp:\n" + errorMessage + "\n";

            value = -1.0;
        }

        mes.add(message);
        return value;
    }

    public static void main(String args[]) {
        String tests[] = {
                "(+ 1 3)",
                "(- 1)",
                "(-)",
                "(+)",
                "(*)",
                "(/)",
                "(- 1 2)",
                "(+ (- 1) (* 3 3 4) (/ 3 2 3) (* 4 4))",
                "(+ (-) (* 3 3 4) (/ 3 2 3) (* 4 4))",
                "(+ (- 1) (* 3 3 4) ) 5 (* (/ 3 2 3) (* 4 4))",
                "(+ (- 1) (* 3 3 4) (/ 3 2 3)) (* 4 4))",
                "+ (- 1) (* 3 3 4) (/ 3 2 3)) (* 4 4))",
        };
        ArrayList<String> mes = new ArrayList<>();
        for (int i = 0; i < tests.length; i++) {
            evaluate(tests[i], mes);
            System.out.println(mes.get(i));
        }
        System.out.println("Done.");
    }
}

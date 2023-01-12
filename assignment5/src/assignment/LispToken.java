package assignment;
/**
* This class represents either an operand or an operator for an arithmetic
* expressions in Lisp.
*
* @author Charles Hoot
* @version 5.0
*/
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * @author Manav Bilakhia (MB)
 * @author Saeed AlSuwaidi
 * @author Jason D'Amico
 */
public class LispToken {
    private Character operator;
    private Double operand;
    private boolean isOperator;

    /**
    * Constructor for objects of class LispToken for operators.
    * isOperator is true and operand is 0.0, operator is anOperator
    *
    * @param anOperator of type Character
    */
    public LispToken(Character anOperator) {
        this.operator = anOperator;
        this.operand = 0.0;
        this.isOperator = true;
    }

    /**
    * Constructor for objects of class LispToken for operands.
    * isOperator is false and operand is the value, operator is ' '
    *
    * @param value of type Double
    */
    public LispToken(Double value) {
        this.operator = ' ';
        this.operand = value;
        this.isOperator = false;
    }

    /**
    * applyOperator: Applies this operator to two given operand values.
    *
    * @param value1 The value of the first operand.
    * @param value2 The value of the second operand.
    * @return The real result of the operation.
    */
    public Double applyOperator(Double value1, Double value2) {
        if (this.operator == '*') {
            return value1 * value2;
        } else if (this.operator == '/') {
            return value1 / value2;
        } else if (this.operator == '+') {
            return value1 + value2;
        } else {
            // Assertion: operator is '-'
            return value1 - value2;
        }
    }

    /**
    * getIdentity: Gets the identity value of this operator. For example, x + 0 = x, so 0 is the
    * identity for + and will be the value associated with the expression (+).
    *
    * @return The identity value of the operator as Double.
    */
    public Double getIdentity() {
        if (this.operator == '+' || this.operator == '-') {
            return 0.0;
        } else {
            // Assertion: operator is '/' or '*', which both have an identity value of 1
            return 1.0;
        }
    }

    /**
    * takesZeroOperands: Detects whether this operator returns a value when it has no operands.
    *
    * @return True if the operator returns a value when it has no operands, or
    * false if not.
    */
    public boolean takesZeroOperands() {
        // Only two operators that take zero operands are * and +
        return this.operator == '*' || this.operator == '+';
    }

    /**
    * getValue: Gets the value of this operand.
    *
    * @return The real value of the operand.
    */
    public Double getValue() {
        return this.operand;
    }

    /**
    * isOperator: Returns true if the object is an operator.
    *
    * @return True is this object is an operator.
    */
    public boolean isOperator() {
        return this.isOperator;
    }

    /**
    * toString: Returns a string representation of the operator or operand
    *
    * @return String
    */
    public String toString() {
        if (this.isOperator()) {
            return this.operator.toString();
        } else {
            return this.operand.toString();
        }
    }
}
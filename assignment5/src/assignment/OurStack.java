package assignment;
import java.util.Stack;
/**
* A class of stacks.
*
* @author Frank M. Carrano
* @version 5.0
*/
/*
 * I affirm that I have carried out the attached academic endeavors with full academic honesty.
 * @author Manav Bilakhia (MB)
 * @author Saeed AlSuwaidi
 * @author Jason D'Amico
 */
public class OurStack<T> implements StackInterface<T> {
    private Stack<T> theStack;
    // Implement the constructor with no parameter, push, peek, pop, isEmpty and clear
    // by using the private Stack theStack of type java.util.Stack

    public OurStack() {
        this.theStack = new Stack<T>();
    }

    public void push(T newEntry) {
        this.theStack.push(newEntry);
    }

    public T pop() {
        return this.theStack.pop();
    }

    public T peek() {
        return this.theStack.peek();
    }

    public boolean isEmpty() {
        return this.theStack.isEmpty();
    }

    public void clear() {
        this.theStack.clear();
    }

    public static void main(String[] args) {
        Stack<String> testStack = new Stack<>();
        System.out.println("New stack is empty: " + testStack.isEmpty());
        
        System.out.println("Adding four entries to the stack...");

        for (int i = 0; i < 4; i++) {
            System.out.println("Item added: " + i);
            testStack.add("entry " + i);
        }

    
    }
}

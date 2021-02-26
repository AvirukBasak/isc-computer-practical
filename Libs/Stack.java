package Libs;
/**
 * Stack based on ArrayExtendedxtended program
 * This class is used by class 'EmLang' and 'WellBrackated' of root package
 */
public class Stack {
    /*
     * Instances made private to implement stack
     * This will prevent external modifications to the array
     */
    private int TOP;
    private int SIZE;
    private ArrayExtended stack;
    /**
     * Stack based on ArrayExtendedxtended program
     */
    public Stack() {
        stack = new ArrayExtended();
        SIZE = 0;
        TOP = -1;
    }
    /**
     * Check if Stack is empty
     * @return boolean, true if empty, false otherwise
     */
    public boolean isEmpty(){
        return (TOP == -1);
    }
    /**
     * Push a new data into stack
     * @param entry New stack entry
     * @return boolean, true if pushed successfully
     * @throws Exception When no memory is available to store new entry
     */
    public boolean push(Object entry) throws Exception {
        try {
            if (this.TOP == this.SIZE - 1) {
                this.stack.append(entry);
                ++this.TOP;
                ++this.SIZE;
                return true;
            } else if (this.TOP < this.SIZE - 1) {
                this.stack.setValue(entry, ++this.TOP);
                return true;
            }
        } catch(OutOfMemoryError e) {
            throw new Exception("StackOverflow " + e);
        }
        return false;
    }
    /**
     * Pop the current stack element
     * @throws Exception When poping from an empty stack
     */
    public void pop() throws Exception {
        if (this.TOP < 0) {
            throw new Exception("StackUnderflow");
        }
        this.stack.setValue("", this.TOP--);
    }
    /**
     * Check the current stack element
     * @return The current stack element
     */
    public Object peek() throws Exception {
        if (this.TOP == -1) {
            throw new Exception("StackUnderflow");
        }
        return this.stack.getValue(this.TOP);
    }
    /**
     * Print the entire stack
     * @throws Exception When trying to print an empty stack
     * @deprecated Use peek to check the current element on stack
     */
    public void print( boolean thr ) throws Exception {
        if ( TOP <= -1 & thr) {
		  
	       throw new Exception( "StaclUnderFlow" );
        }
        for (int i = 0; i <= this.TOP; ++i) {
            System.out.print( this.stack.getValue(i) + "  ");
        }
        System.out.println();
    }
}

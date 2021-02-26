package Libs;
/**
 * ArrayE stands for array extended
 * This class allows you to easily create a dynamic size changing array
 * This class has been used by classes Queue and Stack of this package
 */
public class ArrayExtended {
    /*
     * Instance made private to prevent external modification
     * All operations on the array can be made through member methods
     */
    private Object[] arrayE;
    /**
     * Create an instance of an extendable Object array
     * For an extendable array of specific datatype, use corresponding wrapper classes
     */
    public ArrayExtended () {
        arrayE = new Object[0];
    }
    /**
     * Turn your own array into an extendable Object array
     * @param array The array you want to extend
     */
    public ArrayExtended(Object[] array) {
        this.arrayE = array.clone();
    }
    /**
     * Append data to Extended Array
     * @param value The element to be appended
     */
    public void append(Object value) {
        Object[] tmp = new Object[this.arrayE.length + 1];
        tmp[this.arrayE.length] = value;
        System.arraycopy(this.arrayE, 0, tmp, 0, this.arrayE.length);
        this.arrayE = tmp;
    }
    /**
     * Change value at an <b>index</b> of the extended array
     * @param value The replacement element
     * @param index The index to be modified
     */
    public void setValue(Object value, int index) {
        this.arrayE[index] = value;
    }
    /**
     * Get the data stored at an <b>index</b>
     * @param index The index at which desired element is stored
     */
    public Object getValue(int index) {
        return this.arrayE[index];
    }
    public Object[] getArrayE() {
        return this.arrayE;
    }
    /**
     * Print the whole array
     */
    public void print() {
        System.out.println();
        for (Object arrayE1 : this.arrayE) {
            System.out.print(arrayE1 + "\t");
        }
    }
    /**
     * Print a range of values from the array
     * @param startIndex Printing includes this index
     * @param endIndex Printing excludes this index
     */
    public void print(int startIndex, int endIndex) {
        System.out.println();
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(arrayE[i] + "\t");
        }
    }
}
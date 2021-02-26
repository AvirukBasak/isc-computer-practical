package Libs;
/**
 * Queue based on ArrayExtendedxtended program
 * This class is used by class 'RrepairShop' of root package
 */
public class Queue {
    /*
     * Instances made private to implement queue
     * This will prevent external modifications to the array
     */
    private ArrayExtended queue;
    private int front, rear;
    /**
     * Queue based on ArrayExtendedxtended program
     */
    public Queue () {
        queue = new ArrayExtended();
        front = 0;
        rear = -1;
    }
    /**
     * Check if Queue is empty
     * @return boolean, true if empty, false otherwise
     */
    public boolean isEmpty(){
        return (rear == -1);
    }
    /**
     * Push in new data
     * @param entry New queue entry
     * @return boolean, true if pushed successfully
     * @throws Exception When no memory can be allocated to new entry
     */
    public boolean push(Object entry) throws Exception {
        try {
            this.queue.append(entry);
            ++this.rear;
            return true;
        } catch (OutOfMemoryError e) {
            throw new Exception("QueueOverflow " + e);
        }
    }
    /**
     * Pop data from beginning of queue
     * @throws Exception When pop is attempted on an empty queue 
     */
    public void pop() throws Exception {
        this.queue.setValue("", this.front);
        if (this.rear == -1) {
            throw new Exception("QueueUnderflow");
        }
        if (this.front >= this.rear) {
            this.front = 0;
            this.rear = -1;
        } else {
            ++this.front;
        }
    }
    /**
     * Check the current queue element
     * @return The current queue element
     */
    public Object peek() throws Exception {
        if (this.rear == -1) {
            throw new Exception("QueueUnderflow");
        }
        return this.queue.getValue(this.front);
    }
    /**
     * Print the entire queue
     * @throws Exception When trying to print an empty queue
     * @deprecated Use peek to check the current element on queue
     */
    public void print() throws Exception {
        if (this.rear == -1) {
            throw new Exception("QueueUnderflow");
        }
        for (int i = this.front; i <= this.rear; ++i) {
            System.out.print(this.queue.getValue(i) + "\t");
        }
        System.out.println();
    }
}
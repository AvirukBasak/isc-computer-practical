public class Ticket_Queue {
    int Cons_code[];
    int Max_size;
    int front, rear;
    public Ticket_Queue (int size) {
        Max_size = size;
        front = 0;
        rear = -1;
        Cons_code = new int[Max_size];
    }
    boolean checkQueueIfEmpty() {
        // Checkinng if queue is empty
        return rear == -1;
    } 

    boolean checkQueueIfFull() {
        // Checkinng if queue is full
        return rear == Max_size - 1;
    } 
    void pushViewer(int viewer_code) throws Exception {
        // Enters new customer
        if (checkQueueIfFull()) {
            throw new Exception("Queue limit reached");
        } 
        else {
            Cons_code[++rear] = viewer_code;
        }
    }
    int popViewer() throws Exception {
        // Customer goes to the hall
        int out = 0;
        if (!checkQueueIfEmpty()) {
            out = Cons_code[front];
            Cons_code[front] = 0;
            front++;
        } 
        else {
            throw new Exception("None in queue");
        } 
        if(front == rear){
            out = Cons_code[front];
            Cons_code[front] = 0;
            front = 0;
            rear = -1;
        } 
        return out;
    }
    void printQueue() throws Exception{
        if(checkQueueIfEmpty()){
            throw new Exception("");
        } 
        for (int i = front; i <= rear; i++) {
            System.out.print(Cons_code[i]+"    ");
        } 
        System.out.println();
    }
}

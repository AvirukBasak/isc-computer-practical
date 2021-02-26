public class Theatre_Stack {
	int viewer_code[];
	int Max_size;
	int first;
	int last;
	int out;
	public Theatre_Stack(int size) {
		Max_size = size;
		out = 0;
		// last is the stack top pointer
		last = -1;
		viewer_code = new int[Max_size];
	}
	boolean checkStackIfFull() {
		return last == Max_size - 1;
	}
	boolean checkStackIfEmpty() {
		return last == -1;
	}
	void pushBuyTicket(int viewer_code) throws Exception {
		if (checkStackIfFull()) {
			throw new Exception("Hall is full");
		} 
		else {
			this.viewer_code[++last] = viewer_code;
		}
	}
	int popViewer() throws Exception {
		if (!checkStackIfEmpty()) {
			out = viewer_code[last];
			viewer_code[last--] = 0;
		} 
		else {
			throw new Exception("Hall is empty");
		}
		return out;
	}
	void printStack() throws Exception{
		if(checkStackIfEmpty()){
		
			throw new Exception("");
		}
		for (int i = last; i >= 0; i--) {
		
			System.out.print(viewer_code[i]+"    ");
		} 
		System.out.println();
	}
}
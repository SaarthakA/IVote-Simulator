
public class Student implements Students {
	
	private String ID;
	private char[] answer; // can have multiple answers to some questions therefore an array	
	
	//getters & setters
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public char[] getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer.toCharArray();
	}

	/*constructor
	Input: String ID*/
	public Student(String id){
		this.ID = id;
		this.answer = null;
	}
	
	/*Student's answer input call
	Input: String answer
	Output: true if field update successful to non null value*/
	public boolean answerQuestion(String ans) {
		setAnswer(ans);
		if(ans != null) return true;
		return false;
	}

	/* print ID
	Input: none
	Output: displays ID to console*/
	public void displayID() {
		System.out.println("Students ID is: " + getID());
		
	}
	
}

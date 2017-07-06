import java.util.Arrays;

public class Question implements Questions {

	private String askedQuestion;
	private char[] answers;
	private int numOfChoices;
	private String allChoices;
	private boolean correctMultipleAnswers;
	
	//getters & setters
	public String getAllChoices() {
		return allChoices;
	}
	public void setAllChoices(String allChoices) {
		this.allChoices = allChoices;
	}
	
	//getters & setters
	public String getAskedQuestion() {
		return askedQuestion;
	}
	public void setAskedQuestion(String askedQuestion) {
		this.askedQuestion = askedQuestion;
	}
	
	//getters & setters with overloaded setter that takes both array and string
	public char[] getAnswers() {
		
		return answers;
	}
	public void setAnswers(char[] answers) {
		this.answers = answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers.toCharArray();
	}
	
	//getters & setters
	public int getNumOfChoices() {
		return numOfChoices;
	}
	public void setNumOfChoices(int numOfChoices) {
		this.numOfChoices = numOfChoices;
	}
	
	//only getter as question will not change number of answers
	public boolean isCorrectMultipleAnswers() {
		return correctMultipleAnswers;
	}

	//constructor no input
	public Question(){
		this.askedQuestion = null;
		this.numOfChoices = -1;
		this.correctMultipleAnswers = false;
	};
	
	//constructor with inputs
	public Question(String question, int numofChoices, String allchoices, boolean multiple, String ans){
		this.askedQuestion = question;
		this.numOfChoices = numofChoices;
		this.allChoices = allchoices;
		this.correctMultipleAnswers = multiple;
		setAnswers(ans);	
	}
	/* print question
	Input: none
	Output: display question to console*/
	public void displayQuestion() {
		System.out.println("Question asked is: " + getAskedQuestion());
	}
	/* print answer
	Input: none
	Output: display answer to console*/
	public void displayAnswer() {
		String ans = Arrays.toString(getAnswers());
		System.out.println("The Answer is: " + ans);
	}

	/*print choies
	Input: none
	Output: displays all choices to console*/
	public void displayChoices(){
		String[] splited = getAllChoices().split("\\s+");
		System.out.println("Choices are: ");
		//starts at 1 due to Scanner newline consuming creates whitespace at [0]
		for(int i = 1; i < splited.length; i++){ 
			System.out.println(splited[i]);
		}
	}
}

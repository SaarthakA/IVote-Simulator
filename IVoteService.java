import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** Important Note Regarding Nested Loops:
 * 
 * Efficiency was disregarded due to Questions
 * having small amount of choices in implementation.
 * 
 * **/
public class IVoteService{

	private List<Character> allAnswers = new ArrayList<Character>();
	private Scanner kb;
	
	//constructor with input selection of either testing or actual use
	//if testing use test.txt file given to create test values
	public IVoteService(boolean test) throws FileNotFoundException{
		if(test){
			File file = new File("test.txt");
			kb = new Scanner(file);
		}
		else
			kb = new Scanner(System.in);
	}
	
	/* Creates Question
	Input: none
	Output: new Question object*/
	private Question createQuestion() {
		
		System.out.println("Input the Question");
		String question = kb.nextLine();
		
		System.out.println("Input the number of choices possible");
		int numOfChoices = kb.nextInt();
		
		kb.nextLine(); // to consume the last newline character
		String allchoices = new String();
		System.out.println("--Begin inputting choices--");
		for(int choices = numOfChoices; choices > 0; choices--){
			System.out.println("Input choice " + choices);
			allchoices+= " " + kb.nextLine();
		}
		System.out.println("Does this question have multiple answers (T/F)?");
		boolean multiple = false;
		
		if(kb.nextLine().equals("T")) 
			multiple = true;
		
		System.out.println("Input the Answer(s) in one String");
		String ans = kb.nextLine();
		Question newQuestion= new Question(question, numOfChoices, allchoices, multiple, ans);
		return newQuestion;
	}

	/* displays statistics of voting round
	Input: Question object
	Output: none*/
	private void displayStats(Question question) {
		String[] splited = question.getAllChoices().split("\\s+");
		int [] tally = new int[splited.length];
		//starts at 1 due to Scanner newline consuming creates whitespace at [0]
		for(int i = 1; i < splited.length; i ++){
			for(int j = 0; j < allAnswers.size(); j++){
				if(splited[i].charAt(0) == allAnswers.get(j)){
					tally[i] += 1;
				}
			}
			
		}
		System.out.println("--Stats--");
		//starts at 1 due to Scanner newline consuming creates whitespace at [0]
		for(int i = 1; i < tally.length; i ++){
			System.out.println(splited[i].substring(0,1) +": " + tally[i]);
		}
		
	}

	/* System start wrapper
	Input: List of students
	Output: none*/
	public void start(List<? extends Students> classroom){
		
		Question newQ = createQuestion();
		answering(classroom);
		displayStats(newQ);
		newQ.displayAnswer();
	}
	
	/* Gathers all inputs from class
	Input: List of students
	Output: none*/
	private void answering(List<? extends Students> classroom){
		for(int i = 0; i < classroom.size(); i++){
			System.out.println("Student " + (i+1) + " answer is: ");
			String ans = kb.nextLine();
			classroom.get(i).answerQuestion(ans);
			if(ans.length() > 1){
				for(int j = 0; j < ans.length(); j++){
					allAnswers.add(ans.charAt(j));
				}
			}
			allAnswers.add(ans.charAt(0));
		}
		
	}


	
}

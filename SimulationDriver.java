import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver {

	public static void main(String[] args) throws FileNotFoundException {

		//create list of students with random ID
		List<Student> classroom = new ArrayList<Student>();
		Random rand = new Random();
		for(int i = 0; i < 5; i++){
			classroom.add(new Student(Integer.toString(rand.nextInt())));
		}
		//set vote system to test mode
		IVoteService ivote = new IVoteService(true);
		ivote.start(classroom);
		
		
	}

}

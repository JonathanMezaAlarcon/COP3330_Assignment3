
import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3
{
	int studentResponse;
	int randomNum;
	int randomNum2;
	int randomNumIncorr;
	int randomNumCorr;
	int correctAnsCount = 0;
	char retryorno;

	public static void main(String[] args) 
	{
		CAI3 program = new CAI3();
		program.quiz();
	}
	
	public void quiz()
	{
		for (int i = 0 ; i < 10; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
	}	
	
	public void askQuestion()
	{
		SecureRandom newrandom = new SecureRandom();
		setrandomNum(newrandom.nextInt(10));
		setrandomNum2(newrandom.nextInt(10));
		System.out.printf("How much is %d times %d?\n", randomNum, randomNum2);
	}
	
	public void readResponse()
	{
		Scanner response = new Scanner(System.in);
		setStudentResponse(response.nextInt());
	}
	
	public void isAnswerCorrect()
	{
		int correctAns = getrandomNum() * getrandomNum2();
		
		if (getStudentResponse() == correctAns)
		{
			displayCorrectResponse();
		}else{
			displayIncorrectResponse();
		}
	}
	
	public void displayCorrectResponse()
	{
		setCorrectAnsCount(10);
		SecureRandom randomCorrect = new SecureRandom();
		
		switch(randomCorrect.nextInt(4) +1)
		{
			case 1 : System.out.println("Very good!\n"); break;
			case 2 : System.out.println("Excellent!\n"); break;
			case 3 : System.out.println("Nice work!\n"); break;
			case 4 : System.out.println("Keep up the good work!\n"); break;
		}
	}
	
	public void displayIncorrectResponse() 
	{
		SecureRandom randomIncorrect = new SecureRandom();
		
		switch(randomIncorrect.nextInt(4) +1)
		{
			case 1 : System.out.println("No. Wrong Answer.\n"); break;
			case 2 : System.out.println("Wrong. Better luck on the next question.\n"); break;
			case 3 : System.out.println("Don’t give up!\n"); break;
			case 4 : System.out.println("No. Keep trying.\n"); break;
		}
	}
	
	public void retryquiz()
	{
		setCorrectAnsCountForRetry(0);
		for (int i = 0 ; i < 10 ; i++)
		{
			askQuestion();
			readResponse();
			isAnswerCorrect();
		}
		displayCompletionMessage();
	}	
	
	public void displayCompletionMessage()
	{
		if (getCorrectAnsCount() >= 75)
		{
			System.out.println("Congratulations, you are ready to go to the next level! Your score was a " + getCorrectAnsCount());
		}
		
		if (getCorrectAnsCount() < 75)
		{
			System.out.println("Please ask your teacher for extra help. your score was " + getCorrectAnsCount());
		}
		
		System.out.println("\nWould you like to try another set of Problems? (Y or N):");
		Scanner yn = new Scanner(System.in);
		setRetryyorno(yn.next().charAt(0));
		
		if (getRetryyorno() == 'y' || getRetryyorno() == 'Y')
		{
			retryquiz();
		}
		
		if (getRetryyorno() == ('n' | 'N'))
		{
			System.out.println("\nHave a good day!");
			System.exit(0);
		}
	}
	
	public int getStudentResponse() 
	{
		return this.studentResponse;
	}

	private void setStudentResponse(int studentResponse) 
	{
		this.studentResponse = studentResponse;
	}

	private int getrandomNum() 
	{
		return randomNum;
	}

	private void setrandomNum(int randomNum) 
	{
		this.randomNum = randomNum;
	}

	private int getrandomNum2() 
	{
		return randomNum2;
	}

	private void setrandomNum2(int randomNum2) 
	{
		this.randomNum2 = randomNum2;
	}

	private int getCorrectAnsCount() 
	{
		return correctAnsCount;
	}

	private void setCorrectAnsCount(int correctAnsCount) 
	{
		this.correctAnsCount = this.correctAnsCount + correctAnsCount;
	}
	
	private void setCorrectAnsCountForRetry(int correctAnsCount) 
	{
		this.correctAnsCount = correctAnsCount;
	}

	private char getRetryyorno() 
	{
		return retryorno;
	}

	private void setRetryyorno(char retryorno) 
	{
		this.retryorno = retryorno;
	}
}

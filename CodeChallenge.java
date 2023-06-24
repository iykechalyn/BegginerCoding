package Assignments;

import java.util.Random;
import java.util.Scanner;

public class CodeChallenge {
	int userGuess;
	int randNumber;
	int guessCounter;
	int lowerRange;
	int upperRange;
	int maxGuessOptions;
	double userScore;
	int rangeDifferece;
	final double percentage = 100;
	Scanner sc = new Scanner(System.in);

	public void guessRange() {
		System.out.println("             GUESS THE NUMBER CHALLENGE "
				+ "\n***************************************************"
				+ "\nInstruction: Chose a range of number from 1 and above. \nThe difference bwteen the upper and the lower range must not be less than 10"
				+ "\nThe computer will generate a secrete number within the range and you are required to guess the number in not more than 5 attempts\n");
		System.out.println("Choose your number range ");

		lowerRange = errHandler("Lower range:  ");

		upperRange = errHandler("Uper range: ");

		maxGuessOptions = upperRange - lowerRange;
	}

	public int errHandler(String message) {
		while (true) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print(message);
				return Integer.parseInt(input.nextLine());
			} catch (NumberFormatException nf) {
				System.out.println("Invalid input");
			}
		}
	}

	public void score() {

		userScore = ((maxGuessOptions - (guessCounter - 1)) / (double) maxGuessOptions) * percentage;
		System.out.println();
		System.out.println(
				String.format("Congratulations! You guessed the number %s in %s attempts. " + "\nYour score is %.2f",
						randNumber, guessCounter, userScore) + "%");
	}

	public void guess() {

		do {
			userGuess = errHandler("Take a guess: ");
			guessCounter++;
			if (guessCounter >= 5 && userGuess != randNumber) {
				if (randNumber % 2 == 0) {
					System.out.println(" Clue: the number is an even number");
				} else {
					System.out.println("Clue: number is an even odd");
				}
			} else if (userGuess < lowerRange || userGuess > upperRange)

			{
				System.out.println("The guess is out of range");
			} else if (userGuess == randNumber) {
				break;
			} else if (userGuess > randNumber) {
				System.out.println("Too high!");
				continue;
			} else if (userGuess < randNumber) {
				System.out.println("Too low");
			}

		} while (randNumber != userGuess);
		score();

	}

	public int getRandomNum() {
		Random rnd = new Random();
		randNumber = rnd.nextInt(lowerRange, upperRange);
		return randNumber;
	}

	// FOR TEST PURPOSE ONLY
	public void checkResult() {
		System.out.println("(Random Number: " + randNumber + " )\n");

	}

	public static void main(String[] args) {

		CodeChallenge obj = new CodeChallenge();
		obj.guessRange();

		System.out.println("Welcome to Guess the Number! "

				+ "\nI'm thinking of a number between " + obj.lowerRange + " and " + obj.upperRange + "\n");
		obj.getRandomNum();
		obj.checkResult();

		obj.guess();

	}

}

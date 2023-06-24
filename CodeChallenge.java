package Assignments;

import java.util.Random;
import java.util.Scanner;

public class CodeChallenge {
	int userGuess;
	int randNumber;
	int numOfAttempts = 0;
	int lowerRange;
	int upperRange;
	int totalMark = 0;
	double userScore = 0;
	double userScoreCalc;
	int rangeDiffereceMark;
	final double percentage = 100;
	Scanner sc = new Scanner(System.in);

	public void guessRange() {
		System.out.println("             GUESS THE NUMBER CHALLENGE "
				+ "\n***************************************************"
				+ "\nInstruction: Chose a range of number from 1 and above. \nThe difference bwteen the upper and the lower range must not be less than 10"
				+ "\nThe computer will generate a secrete number within the range and you are required to guess the number in not more than 5 attempts\n");
		System.out.println("Choose your number range ");
		System.out.print("Lower range:  ");
		lowerRange = sc.nextInt();
		System.out.print("Uper range:  ");
		upperRange = sc.nextInt();
		rangeDiffereceMark = upperRange - lowerRange;
		totalMark += rangeDiffereceMark;

	}

	public void score() {

		userScore = ((totalMark - (numOfAttempts - 1)) / totalMark) * percentage;
		System.out.println(userScore + "%");
	}

	public void guess() {
		try {
			do {

				System.out.print("Take a guess: ");

				userGuess = sc.nextInt();
				numOfAttempts++;
				if (userGuess < lowerRange || userGuess > upperRange) {
					System.out.println("The guess is out of range");
				} else if (userGuess == randNumber) {
					System.out.println("Congratulations! You guessed the number " + randNumber + " in " + numOfAttempts
							+ " attempts");

					break;
				} else if (userGuess > randNumber) {
					System.out.println("Too high!");
					continue;
				} else if (userGuess < randNumber) {
					System.out.println("Too low");
				}

			} while (randNumber != userGuess);
			score();

		} catch (Exception e) {
			System.out.println("Wromg input ");

		}
		sc.close();
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

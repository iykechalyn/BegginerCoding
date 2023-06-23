package Assignments;

import java.util.Random;
import java.util.Scanner;

public class CodeChallenge {
	int userGuess;
	int randNumber;
	int count = 0;
	Scanner sc = new Scanner(System.in);

	public void guess() {
		try {
			do {

				System.out.print("Take a guess: ");

				userGuess = sc.nextInt();
				count++;
				if (userGuess < 1 || userGuess > 80) {
					System.out.println("The guess is out of range");
				} else if (userGuess == randNumber) {
					System.out.println(
							"Congratulations! You guessed the number " + randNumber 
							+ " in " + count + " attempts");
					break;
				} else if (userGuess > randNumber) {
					System.out.println("Too high!");
					continue;
				} else if (userGuess < randNumber) {
					System.out.println("Too low");
				}

			} while (randNumber != userGuess);
		} catch (Exception e) {
			System.out.println("Wromg input ");

		}
		sc.close();
	}

	public int getRandomNum() {
		Random rnd = new Random();
		randNumber = rnd.nextInt(1, 80);
		return randNumber;
	}

	public void checkResult() {
		System.out.println("(Random Number: " + randNumber+" )\n");


	}

	public static void main(String[] args) {
		CodeChallenge obj = new CodeChallenge();

		System.out.println("Welcome to Guess the Number! " 
		+ "\nI'm thinking of a number between 1 and 80.");
		obj.getRandomNum();
		obj.checkResult();

		obj.guess();

	}

}

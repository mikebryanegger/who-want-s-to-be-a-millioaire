package projekt;

import java.io.File;
import java.util.Scanner;

public class Model {

	String[] questions;
	String[] answers;

	int questionsNumber;
	
	Control control;

	int random;
	int question = 0;

	int[] usedQuestions;

	public Model(Control control) {
		this.control = control;
		
		try {

			File file = new File("/Users/mikebryanegger/Downloads/projekt/bin/QandA.txt");

			Scanner scan = new Scanner(file);
			questionsNumber = scan.nextInt();

			if (questionsNumber >= 10) {
				usedQuestions = new int[10];
			} else {
				usedQuestions = new int[questionsNumber];
			}

			int counter = 0;

			questions = new String[questionsNumber];
			answers = new String[questionsNumber * 4];

			scan.nextLine();

			while (counter < questionsNumber) {
				questions[counter] = scan.nextLine();
				answers[counter * 4] = scan.nextLine();
				answers[counter * 4 + 1] = scan.nextLine();
				answers[counter * 4 + 2] = scan.nextLine();
				answers[counter * 4 + 3] = scan.nextLine();
				counter += 1;
			}
			scan.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		newQuestion();

	}

	public void newQuestion() {
		if (question < questionsNumber) {
			int newrandom = 0;

			do {

				newrandom = Math.round(Math.round(Math.random() * (questionsNumber - 1)));

			} while (control.isNumberinArray(usedQuestions, newrandom+1));

			usedQuestions[question] = newrandom + 1;
			question += 1;

			random = newrandom;
		}
	}
	
	public void reset(){
		question = 0;
		if (questionsNumber >= 10) {
			usedQuestions = new int[10];
		} else {
			usedQuestions = new int[questionsNumber];
		}
		newQuestion();
	}

}

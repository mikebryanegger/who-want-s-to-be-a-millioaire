package projekt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Control implements ActionListener {

	Model model;
	View view;

	public Control() {
		model = new Model(this);
		view = new View(this);

		setQAText();

	}

	public void setQAText() {
		view.question.setText(
				model.questions[model.random] + " ( " + model.question + " / " + model.questionsNumber + " ) ");

		int[] usedAnswers = new int[4];

		for (int i = 0; i < 4; i++) {
			
			int random = 0;
			
			do {

				random = Math.round(Math.round(Math.random() * (3)));

			} while (isNumberinArray(usedAnswers, random + 1));

			usedAnswers[random] = random + 1;

			view.buttons[i].setText(model.answers[model.random*4 + random]);

		}

		view.result.setText("");
	}

	public boolean isNumberinArray(int[] array, int number) {

		for (int i = 0; i < array.length; i++) {
			if (number == array[i]) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		new Control();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < 4; i++) {

			if (e.getSource() == view.buttons[i]) {
				view.result.setVisible(true);
				if (view.buttons[i].getText() == model.answers[model.random * 4]) {

					view.result.setText("Richtig, Bravoo!");
					System.out.println("Richtig");

					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					if (model.question == model.questionsNumber) {
						view.result.setText("Du hast alle Richtig beantwortet");
						System.out.println("Du hast alle Richtig beantwortet");
					}

					model.newQuestion();

					setQAText();
				} else {
					view.result.setText("Falsch! Du hast " + (model.question - 1) + " von " + model.questionsNumber
							+ " richtig beantwortet.");
					System.out.println("Falsch!");

					try {
						Thread.sleep(500);

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					model.reset();
					setQAText();
				}
			}

		}

	}

}

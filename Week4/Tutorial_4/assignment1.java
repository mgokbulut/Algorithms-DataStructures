package Tutorial_4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class assignment1 {
	public static void main(String[] args) {
		ExamQuestion[] questions = { new ExamQuestion(0, 2), new ExamQuestion(1, 10), new ExamQuestion(2, 4) };
		Exam e = new Exam(questions);
		System.out.println("ass");
		System.out.println(e.getNext().getId());
		System.out.println(e.getNext().getId());
		System.out.println(e.getNext().getId());
	}
}

class Exam {

	private PriorityQueue<ExamQuestion> examQuestions;

	/**
	 * Constructor
	 * 
	 * @param questions - the questions that are part of this exam
	 */
	public Exam(ExamQuestion[] questions) {
		this.examQuestions = new PriorityQueue<ExamQuestion>(questions.length, new thePriority());
		this.examQuestions.addAll(Arrays.asList(questions));
	}

	/**
	 * Returns the next question that should be answered on this exam, the values of
	 * the returned exam questions should in descending order (i.e. questions with
	 * high value should be returned first)
	 * 
	 * @return
	 */
	public ExamQuestion getNext() {
		return this.examQuestions.poll();
	}
}

class thePriority implements Comparator<ExamQuestion> {

	@Override
	public int compare(ExamQuestion o1, ExamQuestion o2) {
		return o1.compareTo(o2);
	}

}

class ExamQuestion implements Comparable<ExamQuestion> {

	// The question number
	private int id;

	// The number of points that can be obtained by answering this question
	private int value;

	public ExamQuestion(int id, int value) {
		this.id = id;
		this.value = value;
	}

	/**
	 * Compares two exam questions by comparing their values. Can be used to sort
	 * the exam questions in descending order.
	 * 
	 * @param that - other exam question
	 * @return
	 */
	@Override
	public int compareTo(ExamQuestion that) {
		// By swapping the position of this and that, we will sort in ascending order.
		return Integer.compare(that.value, this.value);
	}

	public int getId() {
		return this.id;
	}

	public int getValue() {
		return this.value;
	}
}

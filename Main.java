import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static String[] questions = {"The series of the Intel HD graphics generation succeeding that of the 5000 and 6000 series (Broadwell) is called:",
            "In computing, what does LAN stand for?",
            "In the programming language Java, which of these keywords would you put on a variable to make sure it doesn't get modified?",
            "What amount of bits commonly equals one byte?",
            "Which computer language would you associate Django framework with?"};

    public static String[][] options = {{"HD Graphics 7000", "HD Graphics 500", "HD Graphics 600", "HD Graphics 700"},
            {"Land Address Navigation", "Light Access Node", "Long Antenna Node", "Local Area Network"},
            {"Final", "Static", "Public", "Private"},
            {"1", "64", "2", "8"},
            {"C++", "Java", "Python", "C#"}};

    public static int[] correctAnswers = {1, 3, 0, 3, 2};

    public static boolean[] userAnswers = new boolean[5];

    public static void main(String[] args) {

        int correctAnswersCount = 0;

        System.out.println("******************************");
        System.out.println("Welcome to the Java Quiz Game!");
        System.out.println("******************************");

        for (int i = 0; i < questions.length; i++) {
            questionActive(i);
            System.out.println("******************");
        }

        for (int i = 0; i < questions.length; i++) {
            correctAnswersCount += (userAnswers[i]) ? 1 : 0;
            System.out.printf("Question %d: %s\n", i + 1, userAnswers[i]);
        }

        System.out.println("Correct answer count: " + correctAnswersCount);
        if (correctAnswersCount == 0) {
            System.out.println("You poor thing...");
        } else if (correctAnswersCount <= 3) {
            System.out.println("You are good actually.");
        } else if (correctAnswersCount == 4) {
            System.out.println("Wow! Amazing performance you cutie!");
        } else {
            System.out.println("Oh my god... You are a genius my beloved!");
        }

        scanner.close();
    }

    public static void questionActive(int index) {
        int answer;

        System.out.printf("%d. %s\n", index + 1, questions[index]);
        System.out.println("***********");
        for (int i = 0; i < options[index].length; i++) {
            System.out.printf("%d. %s\n", i + 1, options[index][i]);
        }

        while (true) {
            System.out.print("Enter your answer: ");
            answer = scanner.nextInt();

            if (answer > 4 || answer < 0) {
                System.out.println("Enter a valid answer.");
            } else {
                answer -= 1;
                break;
            }
        }

        userAnswers[index] = answer == correctAnswers[index];
    }
}

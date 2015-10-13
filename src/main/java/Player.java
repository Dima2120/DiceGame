import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private int score;
    private int attempt; // sproba

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void chooseDesk() {

        System.out.println("Hello! Amigo, to start the game, please, choose and press number of the desk :");
        System.out.println("- 1 desk one, attempts: 4");
        System.out.println("- 2 desk one, attempts: 6");
        System.out.println("- 3 desk one, attempts: 10");
        while (true) {
            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("You choose the " + num + " desk, and you have 4 attempts");
                setAttempt(4);
                break;
            }

            if (num == 2) {
                System.out.println("You choose the " + num + " desk, and you have 6 attempts");
                setAttempt(6);
                break;
            }

            if (num == 3) {
                System.out.println("You choose the " + num + " desk, and you have 10 attempts");
                setAttempt(10);
                break;
            }

        }
    }

    public void startGame() throws IOException {
        System.out.println("Good taste! Are you ready to play ? Let's go ! To start press [Start]");
        while (true) {
            String res = reader.readLine();
            if (res.equals("Start"))
                break;
        }
    }

    public void throwBone() throws InterruptedException {
        score = 0;
        for (int i = attempt; i > 0; i--) {
            Random random = new Random();
            System.out.println("Throw bone");
            int num = random.nextInt(6) + 1;
            Thread thread = new Thread();
            thread.sleep(1000);
            System.out.println("Dropped number: " + num);
            score += num;
        }


    }

    public void showResults() throws IOException, InterruptedException {

        System.out.println("You score: " + score + " points. To play again press [Start] or [Exit]");
        while (true) {
            String res = reader.readLine();
            if (res.equals("Start")) {
                chooseDesk();
                startGame();
                throwBone();
                showResults();

            }
            if (res.equals("Exit")) {
                System.out.println("Good buy! ");
                break;
            }
        }
    }
}

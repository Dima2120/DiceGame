import java.io.IOException;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        Player amigo = new Player();
        amigo.chooseDesk();
        amigo.startGame();
        amigo.throwBone();
        amigo.showResults();
    }
}

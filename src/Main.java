

public class Main {

    public static void main(String[] args) {

        freqTable squares = new freqTable();
        for (int j = 0; j<100;j++){
            Player p = new Player(0);
            for (int i = 0; i <= 30; i++) {
                p.roll();
                squares.log(p.pos);

        }

        }
        //squares.getter();
        squares.plot();
    }
}
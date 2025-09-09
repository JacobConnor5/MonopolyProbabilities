

public class Main {

    public static void main(String[] args) {

        freqTable squares = new freqTable();
        for (int j = 0; j<40;j++){
            Player p = new Player(0);
            for (int i = 0; i <= 40; i++) {
                p.roll();
                squares.log(p.pos);

        }

        }
        //squares.getter();
        squares.plot();
    }
}
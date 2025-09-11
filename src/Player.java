import java.util.ArrayList;
import java.util.List;

public class Player {
    public int pos;
    private boolean locked;
    private int attempts;
    private int doubles;
    private final List<Integer> chances;
    private int chanceSize;

    private final List<Integer> chests;
    private int chestSize;

    public Player (int start){
        pos = start;
        locked = false;
        attempts = 0;
        doubles = 0;


        chances = new ArrayList<>(List.of(0,24,39,11,15,15,12,30,5));
        chanceSize = 16;

        chests = new ArrayList<>(List.of(0,10));
        chestSize = 16;


    }
    public void roll (){
        int di1 = (int) (Math.random()*6)+1;
        int di2 = (int) (Math.random()*6)+1;

        if ((!this.locked)){
            //if not in jail or they haven't rolled a third double or they this isn't their third possible double
            if (di1 == di2){this.doubles++;}
            else{this.doubles = 0;}

            this.pos = ((this.pos)+di1+di2)%40;

            if (pos == 7 || pos == 22 || pos == 36){
                chance();
            }
            else{if(pos == 2 || pos == 17 || pos == 33){
                chest();
            }}

            if (this.pos == 30 || this.doubles >= 3){
                this.jail();
            }

        }
        else{
            this.attempts ++;
            this.doubles = 0;
            if (di1 == di2 || this.attempts >=3){
                this.pos = ((this.pos)+di1+di2)%40;
                this.locked = false;
                this.attempts = 0;
            }
        }

    }


    public void jail(){
        this.locked = true;
        this.pos = 10;
    }

    public void chance(){
        int cardIndex = (int) (Math.random()*chanceSize);

        if (cardIndex<chances.size()){
            int card = chances.get(cardIndex);

            if (card ==15){
                this.pos = ((this.pos/10) *10)+5;
            }
            else{
                if (card == 12){
                    if (pos<20){
                        this.pos = 12;
                    }
                    else{
                        this.pos = 28;
                    }
                }
                else {
                    this.pos = card;
                }
            }
            this.chances.remove(cardIndex);

        }
        chanceSize--;


    }

    public void chest(){

        int cardIndex = (int) (Math.random()*chestSize);
        if (cardIndex<chests.size()){
            this.pos = chests.get(cardIndex);
            this.chests.remove(cardIndex);
        }
        chestSize --;
    }

    public void test(){
        int di1 = (int) (Math.random()*6)+1;
        int di2 = (int) (Math.random()*6)+1;

        System.out.println(di1+","+di2);
    }

    public void RoleGetter(int di1,int di2){
        System.out.println("\n");
        System.out.println("roll:"+di1+","+di2+"\npos: "+this.pos+"\nlocked away: "+this.locked+"\nNo. Doubles: "+this.doubles+"\nNo. Attempts: "+this.attempts);
        System.out.println("\n");

    }



}

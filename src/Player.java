
public class Player {
    public int pos;
    private boolean locked;
    private int attempts;
    private int doubles;

    public Player (int start){
        pos = start;
        locked = false;
        attempts = 0;
        doubles = 0;

    }
    public void roll (){
        int di1 = (int) (Math.random()*6)+1;
        int di2 = (int) (Math.random()*6)+1;
        if ((!this.locked)){
            //if not in jail or they haven't rolled a third double or they this isn't their third possible double
            if (di1 == di2){this.doubles++;}
            else{this.doubles = 0;}

            this.pos = ((this.pos)+di1+di2)%40;

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
        Rolegetter(di1,di2);

    }


    public void jail(){
        this.locked = true;
        this.pos = 10;
    }
    public void chance(){
        //16 chance cards
            //7 advances
            //2 nearest railroads
                //1 kings cross railroad
            //1 utility
            //1 Go
            //1 jail

        //16 community chest
            //1 Go

    }

    public void Rolegetter(int di1,int di2){
        System.out.println("\n");
        System.out.println("roll:"+di1+","+di2+"\npos: "+this.pos+"\nlocked away: "+this.locked+"\nNo. Doubles: "+this.doubles+"\nNo. Attempts: "+this.attempts);
        System.out.println("\n");

    }



}

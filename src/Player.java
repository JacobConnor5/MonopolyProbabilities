
public class Player {
    public int pos;
    private boolean locked;
    private int attempts;

    public Player (int start){
        pos = start;
        locked = false;
        attempts = 0;

    }
    public int roll (){
        int di1 = (int) (Math.random()*6)+1;
        int di2 = (int) (Math.random()*6)+1;
        if ((!this.locked) || (di1 == di2) || (this.attempts == 2)){
            this.attempts = 0;
            this.locked = false;
            this.pos = ((this.pos)+di1+di2)%40;
            if (this.pos == 30){
                this.jail();
            }
            return this.pos;
        }
        else{
            this.attempts ++;
            return (this.pos);
        }

    }


    public void jail(){
        this.locked = true;
        this.pos = 10;
    }

    public void getter(){
        System.out.println("\n");
        System.out.println(this.pos);
        System.out.println(this.locked);
        System.out.println(this.attempts);
        System.out.println("\n");

    }



}

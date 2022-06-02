
public class Products{
    private int coke, pepsi, soda;

    public int Coke(int coke){
        this.coke = coke;
        coke = this.coke*25;
        return coke;
    }

    public int Pepsi(int pepsi){
        this.pepsi = pepsi;
        pepsi = this.pepsi*35;
        return pepsi;
    }
    
    public int Soda(int soda){
        this.soda = soda;
        soda = this.soda*45;
        return soda;
    }
}

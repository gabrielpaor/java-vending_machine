
public class Stocks {

    private int coke, pepsi, soda;

    public int cokeStocks(int cokeStock){
        this.coke = cokeStock;
        coke = this.coke--;
        return coke;
    }

    public int pepsiStocks(int pepsiStock){
        this.pepsi = pepsiStock;
        pepsi = this.pepsi--;
        return pepsi;
    }

    public int sodaStocks(int sodaStock){
        this.soda=sodaStock;
        soda = this.soda--;
        return soda;
    }
}

import javax.swing.*;

public class VendingMachineImpl{
    static int amount, change, payment;
    static int penny, nickel, dime, quarter;
    static int coke, pepsi, soda;
    static int cokeStock, pepsiStock, sodaStock;
    static int selectProduct;
    static int totalStocks;
    static int answer;

    static Products p = new Products();
    static Stocks s = new Stocks();
    static Coins c = new Coins();
   
    VendingMachineImpl(){

        //enter payment
        penny = Integer.parseInt(JOptionPane.showInputDialog("Enter penny: "));
        nickel = Integer.parseInt(JOptionPane.showInputDialog("Enter nickel: "));
        dime = Integer.parseInt(JOptionPane.showInputDialog("Enter dime: "));
        quarter = Integer.parseInt(JOptionPane.showInputDialog("Enter quarter: "));
        
        //total amount
        amount += c.Penny(penny);
        amount += c.Nickel(nickel);
        amount += c.Dime(dime);
        amount += c.Quarter(quarter);

        //choose product
        selectProduct = Integer.parseInt(JOptionPane.showInputDialog("Choose your drink:\nCoke(1) Pepsi(2) Soda(3)"));

        //stocks
        cokeStock = 100;
        pepsiStock = 100;
        sodaStock = 100;

        //display payment
        payment = amount;

        //loop
        do {
            //if your order is coke
            if(selectProduct == 1){
                coke = Integer.parseInt(JOptionPane.showInputDialog("Enter How Many Coke you want: "));
                if(coke>cokeStock) {
                    JOptionPane.showMessageDialog(null,"Our stock is not enough.");
                }
                else {
                    change = amount - p.Coke(coke);
                    if(change >= 0){
                        JOptionPane.showMessageDialog(null,"Total Amount: " + p.Coke(coke) +
                        "\nYour money: " + payment + "\nYour Change: " + change);
                        totalStocks =   s.cokeStocks(cokeStock) - coke;
                        JOptionPane.showMessageDialog(null, "Total Stocks:" + "\nCoke: " + totalStocks + "\nPepsi: " + 
                        s.pepsiStocks(pepsiStock) + "\nSoda: " + s.sodaStocks(sodaStock));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Not enough payment.");
                    }   
                }
            }
            //if your order is pepsi
            else if(selectProduct == 2){
                pepsi = Integer.parseInt(JOptionPane.showInputDialog("Enter How Many Pepsi you want: "));
                if(pepsi>pepsiStock) {
                    JOptionPane.showMessageDialog(null,"Our stock is not enough.");
                }
                else {
                    change = amount - p.Pepsi(pepsi);
                    if(change > 0){
                        JOptionPane.showMessageDialog(null,"Total Amount: " + p.Pepsi(pepsi) +
                        "\nYour money: " + payment + "\nYour Change: " + change);
                        int totalStocks =   s.cokeStocks(pepsiStock) - pepsi;
                        JOptionPane.showMessageDialog(null, "Total Stocks:" + "\nCoke: " + s.cokeStocks(cokeStock) + "\nPepsi: " 
                        + totalStocks + "\nSoda: " + s.sodaStocks(sodaStock));
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Not enough payment.");
                    }  
                }
            }
            //if your order is soda
            else if(selectProduct == 3){
                    soda = Integer.parseInt(JOptionPane.showInputDialog("Enter How Many Soda you want: "));
                    if(soda>sodaStock) {
                        JOptionPane.showMessageDialog(null,"Our stock is not enough.");
                    }
                    else {
                        change = amount - p.Soda(soda);
                        if(change >= 0){
                            JOptionPane.showMessageDialog(null,"Total Amount: " + p.Soda(soda) +
                            "\nYour money: " + payment + "\nYour Change: " + change);
                            int totalStocks =   s.sodaStocks(sodaStock) - soda;
                            JOptionPane.showMessageDialog(null, "Total Stocks:" + "\nCoke: " + s.cokeStocks(cokeStock) + "\nPepsi: "
                            + s.pepsiStocks(pepsiStock) + "\nSoda: " + totalStocks);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Not enough payment.");
                        }
                    }
                }
                if (answer == JOptionPane.NO_OPTION) {
                    System.exit(0);
                } else if (answer == JOptionPane.CLOSED_OPTION) {
                    System.exit(0);
                }
                JOptionPane.showOptionDialog(new JFrame(), "Do you want to Confirm your Purchase", "Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Yes", "No" },
                        JOptionPane.YES_OPTION);
            } while (answer == JOptionPane.YES_OPTION);
    }
} 


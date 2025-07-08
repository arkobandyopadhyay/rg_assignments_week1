public class TaxUtil {
    double rate = 0.15;
    public double calculateTax(double amount) {
        return amount * rate;
    }
    public static void main(String [] args){
           int amount=5;
           TaxUtil obj=new TaxUtil();
        
           //without changing the rate value
           System.out.println("Not Changing the rate value");
           System.out.println("input 5:"+" output value :"+obj.calculateTax(amount));

           //chaning the rate value
           obj.rate=5;
           System.out.println("Changing the rate value");
           System.out.println("input 5:"+" output value :"+obj.calculateTax(amount));

           System.out.println("Thus for same input , different outputs , therefore the function is not a pure function");
    }
}
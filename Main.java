import java.util.Scanner;

record MortgageCalculator(double principal, double interestRate, int years) {
//define mortgage calculator calculation
    //define intvestment raate calculation
    public double calculateMortgage() {
        double monthlyInterestRate = interestRate / 12 / 100;
        int numberOfPayments = years * 12;
        double mortgage = principal * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
        return mortgage;
    }public double calculateTotalInterest() {
        double totalInterest = calculateMortgage() * years * 12 - principal;
        return totalInterest;
    }
}
//create class to take in input values
public class Main {
    //pull in string arguments
    //Take in value perametes
    // take in principal value
    //take in interest rate value


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter the interest rate: ");
        double interestRate = sc.nextDouble();
        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

      //declare value for mortgage calculator funtion
      //prepare outputfeilds


        var mc = new MortgageCalculator(principal, interestRate, years);
        System.out.println("Monthly mortgage payment: $" + mc.calculateMortgage());
        System.out.println("Total interest paid: $" + mc.calculateTotalInterest());
        sc.close();
    }
}

package algorithms;
import java.util.*;

/*根据他给的公式算fixed monthly payment： 
 * P = (monthly rate * Loan amount) / (1 - (1+monthly interest rate)^-n) 
 * Here n is no of payment periods
 * e.g.  input: "6000~6~5~0" means 某人借了6000 loan, 年利率是6%，分5年还清，down payment是0，然后根据上面那个公式算出来每月要还多少钱. 
         output:116.00
*/
public class FixedMonthlyPayment {
	public static void main(String[] args) {
		System.out.println(String.format("%.2f", pay(6000, 6, 5, 0)));
	}
	
	private static double pay(double money, int rate, int year, double downPay) {
		double upper = (rate / 1200.00) * (money - downPay);
		int n = year * 12;
		double lower = 1 - Math.pow((1 + rate / 1200.00), -n);
		return Math.round(upper / lower) * 0.01d;
	}
}

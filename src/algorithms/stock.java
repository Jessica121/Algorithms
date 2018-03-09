package algorithms;
import java.util.*;
/*给两个投资组合，一个叫port，一个叫benchmark，算一下每一个stock在两个投资组合中的比例的差值
  e.g.  input: "PORT:AXN,10,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20"      
  (stock name, stock qty, stock price;)
  expected output: AXN:-15.00,BGT:-15.00,CXZ:30.00,DFG:-30.00 （AXN在port中占10%，在bench中占25%，差值-15.00%*/
public class stock {
	public static void main(String[] args) {
		String str = "PORT:AXN,10,10;BGT,20,30;CXZ,10,30|BENCH:AXN,50,10;BGT,30,30;DFG,30,20";
		System.out.println(check(str));
	}
	
	private static String check(String str) {
		String[] arr = str.split("\\|");System.out.println(arr[0] + " ->> " + arr[1]);
		String[] cmp1 = arr[0].split("\\:"), cmp2 = arr[1].split("\\:");
		String[] detal1 = cmp1[1].split("\\;"), detal2 = cmp2[1].split("\\;");System.out.println(cmp2[0] + " ->> " + cmp2[1]);
		int numOfStock = Math.max(detal1.length, detal2.length);System.out.println(numOfStock);
		double res1[] = new double[numOfStock], res2[] = new double[numOfStock];
		Set<String> names = new HashSet<>();
		int sum1 = 0, sum2 = 0;
		StringBuilder sb1 = new StringBuilder();
		for(int i = 0; i < numOfStock; i++) {
			String[] sArr = detal1[i].split("\\,");
			String[] sArr2 = detal2[i].split("\\,");
			names.add(sArr[0]);
			names.add(sArr2[0]);
			sum1 += Integer.valueOf(sArr[1]) * Integer.valueOf(sArr[2]);
			res1[i] = Integer.valueOf(sArr[1]) * Integer.valueOf(sArr[2]);
			sum2 += Integer.valueOf(sArr2[1]) * Integer.valueOf(sArr2[2]);
			res2[i] = Integer.valueOf(sArr2[1]) * Integer.valueOf(sArr2[2]);
		}
		System.out.println(Arrays.toString(res1) + " " + Arrays.toString(res2));
		for(int i = 0; i < numOfStock; i++) {
			res1[i] = (double) res1[i] / sum1 - (double) res2[i] / sum2;
//			sb1.append(names[i]).append(":").append(res1[i]).append(",");
		}
		return sb1.toString();
	}
}

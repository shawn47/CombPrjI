package combPrj1.main;

import java.util.Scanner;

import combPrj1.method.AlphabetPermutation;
import combPrj1.method.DecrePermutation;
import combPrj1.method.IncrePermutation;

public class main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlphabetPermutation ap = new AlphabetPermutation();
		Scanner scan = new Scanner(System.in);
		System.out.println("please input the number of permutation:");
		int num = scan.nextInt();
		long start = System.currentTimeMillis();
		ap.permutationAlgorathim(ap.creatPermutation(num));
		long end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
	
		IncrePermutation ip = new IncrePermutation();
		scan = new Scanner(System.in);
		System.out.println("Please input scale of permutation: ");
		int scale = scan.nextInt();
		start = System.currentTimeMillis();
		ip.permutationAlgorathim(ip.creatPermutation(scale));
		end = System.currentTimeMillis();
		System.out.println("run time : " + (double)Math.round((end - start)/1000) + " second ");
	
		DecrePermutation dp = new DecrePermutation();
		scan = new Scanner(System.in);
		System.out.println("Please input scale of permutation: ");
		scale = scan.nextInt();
		start = System.currentTimeMillis();
		dp.permutationAlgorathim(dp.creatPermutation(scale));
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
	}

}

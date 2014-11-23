package combPrj1.main;

import java.util.Scanner;

import combPrj1.method.AlphabetPermutation;
import combPrj1.method.APermutation;
import combPrj1.method.DecrePermutation;
import combPrj1.method.DPermutation;
import combPrj1.method.IPermutation;
import combPrj1.method.IncrePermutation;
import combPrj1.method.NeighborSwitchPermutation;
import combPrj1.method.NPermutation;

public class main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/**
		// TODO Auto-generated method stub
		AlphabetPermutation ap = new AlphabetPermutation();
		//Scanner scan = new Scanner(System.in);
		//System.out.println("please input the number of permutation:");
		//int num = scan.nextInt();
		long start = System.currentTimeMillis();
		ap.permutationAlgorathim(ap.creatPermutation(9));
		long end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
	
		IncrePermutation ip = new IncrePermutation();
		//scan = new Scanner(System.in);
		//System.out.println("Please input scale of permutation: ");
		//int scale = scan.nextInt();
		start = System.currentTimeMillis();
		ip.permutationAlgorathim(ip.creatPermutation(9));
		end = System.currentTimeMillis();
		System.out.println("run time : " + (double)Math.round((end - start)/1000) + " second ");
	
		DecrePermutation dp = new DecrePermutation();
		//scan = new Scanner(System.in);
		//System.out.println("Please input scale of permutation: ");
		//scale = scan.nextInt();
		start = System.currentTimeMillis();
		dp.permutationAlgorathim(dp.creatPermutation(9));
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
	
		NeighborSwitchPermutation nsp = new NeighborSwitchPermutation();
		//scan = new Scanner(System.in);
		//System.out.println("Please input scale of permutation: ");
		//scale = scan.nextInt();
		start = System.currentTimeMillis();
		nsp.permutationAlgorathim(nsp.creatPermutation(9));
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
		**/
		System.out.println("================new method===============");
		
		APermutation aa = new APermutation();
		long start = System.currentTimeMillis();
		//aa.generateAllDummy(9);
		aa.generateAllPermutation(9);
		long end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
		
		DPermutation dd = new DPermutation();
		start = System.currentTimeMillis();
		//dd.generateAllDummy(9);
		dd.generateAllPermutation(9);
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
		
		IPermutation ii = new IPermutation();
		start = System.currentTimeMillis();
		//ii.generateAllDummy(9);
		ii.generateAllPermutation(9);
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
		
		NPermutation pp = new NPermutation();
		start = System.currentTimeMillis();
		//pp.generateAllDummy(9);
		pp.generateAllPermutation(9);
		end = System.currentTimeMillis();
		System.out.println("run time: " + (double)Math.round(end-start)/1000+" second");
	}

}

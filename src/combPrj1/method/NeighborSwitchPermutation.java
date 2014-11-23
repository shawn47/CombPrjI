package combPrj1.method;

public class NeighborSwitchPermutation {
	public int factorial(int n) {
		int sum = 1;
		while (n > 1) {
			sum *= (n--);
		}
		return sum;
	}
	// get initialization permutation of scale is number
	public NeighborDigitInfo[] creatPermutation(int number) {
		NeighborDigitInfo[] permutation = new NeighborDigitInfo[number];
		for (int i = 0; i < number; ++i) {
			// initialization of object
			permutation[i] = new NeighborDigitInfo();
			permutation[i].value = i + 1;
			permutation[i].direction = "left";
		}
		return permutation;
	}					

	// get interNumber of permutation given;
	public int[] getInterNumber(NeighborDigitInfo[] permutation) {
		// initialization for NeighborDigitInfo 2 direction is left
		String NeighborDigitInfoDirection = "left";
		int[] b = new int[permutation.length - 1];
		//find interNumber[permutation.length - 1] to interNumber[2]
		int j;
		for(int i = 0 ; i <  permutation.length - 1 ; ++ i) {
			int NeighborDigitInfo  = i + 2 ,count = 0;
			//next NeighborDigitInfo has same direction with current NeighborDigitInfo
			for(j = 0 ; j < permutation.length ; ++j) {
				if(i > 0) {
					//NeighborDigitInfo is odd then its direction decided by b[i-1]
 					if(NeighborDigitInfo % 2 == 1) {
						if(b[i - 1] % 2 == 1) 
							NeighborDigitInfoDirection = "right";
						else 
							NeighborDigitInfoDirection = "left";
					}
 					//NeighborDigitInfo is even then its direction decided by sum b[i-1]  with b[i-2]
 					if(NeighborDigitInfo % 2 == 0) {
 						if( (b[i - 1] + b[ i - 2]) % 2 == 1) 
 							NeighborDigitInfoDirection = "right";
						else 
							NeighborDigitInfoDirection = "left";
 					}
				}
				if(permutation[j].value == NeighborDigitInfo) {
					if(NeighborDigitInfoDirection.endsWith("left")) {
						for(int k = permutation.length - 1 ; k > j ;-- k ) {
							if(permutation[k].value < NeighborDigitInfo) 
								++count;
						}
					}
					else if(NeighborDigitInfoDirection.endsWith("right")) {
						for(int k = 0 ; k < j ; ++ k) {
							if(permutation[k].value < NeighborDigitInfo) 
								++count;
						}
					}
					b[i] = count;
					break;
				}
			}
		}
		return b;
	}

	// next interNumber
	public int[] nextInterNumber(int[] originalInterNumber) {
		for (int i = originalInterNumber.length - 1; i >= 0; --i) {
			int pow = i + 2;
			if (++originalInterNumber[i] >= pow) {
				originalInterNumber[i] -= pow;
			} else {
				return originalInterNumber;
			}
		}
		return originalInterNumber;
	}

	// get permutation via interNumebr given
	public NeighborDigitInfo[] getPermutation(int[] b) {
		NeighborDigitInfo[] permutation = new NeighborDigitInfo[b.length+1];
		String direction = "";
		for(int i = 0 ; i < b.length + 1 ; ++ i) {
			permutation[i] = new NeighborDigitInfo();
			permutation[i].value = 0;
		}
		//there are b.length+1 NeighborDigitInfo to fill the spaces
		for(int j = b.length - 1  ; j >=0  ; -- j ) {
			int NeighborDigitInfo = j + 2;
			//judge j odd or even
			if(j>=1){
				if(NeighborDigitInfo % 2 == 1){
					if(b[j-1] % 2 == 1) 
						direction = "right";
					else 
						direction = "left";
				}else{
					if((b[j-1] + b [j-2]) % 2 == 1) 
						direction = "right";
					else 
						direction = "left";
				}
			}
			if(NeighborDigitInfo == 2 ) 
				direction = "left";
			//set the NeighborDigitInfo in right position
			int count = b[j];
			if(direction.endsWith("left")) {
				int pos = b.length +1 ;
				while( count>=0 && (--pos)>=0){
					if(permutation[pos].value == 0)
						--count;
					if(count < 0)
						permutation[pos].value = NeighborDigitInfo;
				}
			}
			if(direction.endsWith("right")) {
				int pos = - 1 ;
				while( count>=0 && (++pos) <= b.length){
					if(permutation[pos].value == 0)
						--count;
					if(count < 0)
						permutation[pos].value = NeighborDigitInfo;
				}
			}
		}
		int pos = -1;
		while(permutation[++pos].value!=0);
		permutation[pos].value = 1;
		return permutation;
	}

	//public
	public void permutationAlgorathim(NeighborDigitInfo[] permutation){
			for(int i = 0 ; i < factorial(permutation.length);++i) {
				int[] original = getInterNumber(permutation);
				//for(int j = 0 ; j < permutation.length ; ++ j){
				//	System.out.print(permutation[j].value);
				//}
				//System.out.print("\t");
				//for(int k = 0 ; k < original.length ; ++ k)
				//	System.out.print(original[k]);
				//System.out.println();
				original = nextInterNumber(original);
				permutation = getPermutation(original);
			}
		}
}

class NeighborDigitInfo {
	int value;
	String direction;
	public NeighborDigitInfo(){};
}
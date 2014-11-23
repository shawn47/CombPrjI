package combPrj1.method;

public class DecrePermutation extends BaseFunction {

	@Override
	public String creatPermutation(int number) {
		// TODO Auto-generated method stub
		char[] ch = new char[number];
		for (int i = 1; i <= number; ++i)
			ch[i - 1] = (char) (i + 48);
		return String.valueOf(ch);
	}

	@Override
	public String getMediaNumber(String permutation) {
		// TODO Auto-generated method stub
		char[] ch = permutation.toCharArray();
		char[] save = new char[permutation.length() - 1];
		for(int i = 0 ; i < permutation.length() ; ++i){
			//digit 1 has no interNumber
			if(ch[i]=='1') continue;
			//save is type of char 
			int count = 0 + 48;
			//count interNumber of the digit of position i
			for(int j = i + 1; j < permutation.length() ;++j ) {
				if(ch[i] > ch[j]) ++count;
			}
			//put count to the  array save in correspondence position
			save[ch[i] - 48 - 2] = (char)count;
		}
		return String.valueOf(save);
	}

	@Override
	public String nextMediaNumber(String mediaNumber) {
		// TODO Auto-generated method stub
		char[] ch = mediaNumber.toCharArray();
		for(int i = mediaNumber.length() - 1; i >= 0 ;--i){
			int pow = i + 2;
			ch[i] += 1;
			if(ch[i] >= pow + 48) ch[i] -= pow;
			else break;
		}
		return String.valueOf(ch);
	}

	@Override
	public String getPermutation(String mediaNumber) {
		// TODO Auto-generated method stub
		char[] ch = mediaNumber.toCharArray();
		char[] npm = new char[mediaNumber.length() + 1];// new permutation number
		// initialization of npm
		for (int i = 0; i < mediaNumber.length() + 1; ++i)
			npm[i] = '0';// '0' represents space
		for (int i = mediaNumber.length() - 1; i >= -1; --i) {
			int digit = i + 2; // need to position
			// array index out of bound
			int count = 0;// make sure count = 0 while i = interNumber.length();
			if (i > -1) {
				count = (int) (ch[i] - 48);// char type to int type
//				System.out.println("count = " + count);
			}
			int j = mediaNumber.length();// from right to left traverse
			while (count > 0 && j > 0) {
				if (npm[j--] == '0') {
					--count;
				}
			}
			while (j >= 0) {
				if (npm[j] == '0') {
					npm[j] = (char) (digit + 48);// int to char
					break;
				}
				--j;
			}
		}
		return String.valueOf(npm);
	}

	@Override
	public void permutationAlgorathim(String permutation) {
		// TODO Auto-generated method stub
		int time = 0;
		// control loop stop
		while ((++time) <= factorial(permutation.length())) {
			//char[] ch = permutation.toCharArray();
			//for(int i= 0 ; i< permutation.length() ; ++i){
			//	System.out.print(ch[i] + " ");
			//}
			/** find next permutation */ 
			//original interNumber
			String original = getMediaNumber(permutation);
			//next interNumbera
			String nextInterNumber = nextMediaNumber(original);
			//update permutation with next permutation
			permutation = getPermutation(nextInterNumber);
			//System.out.println("\t" + original);
		}
	}

}

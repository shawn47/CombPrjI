package combPrj1.method;

public class IncrePermutation extends BaseFunction {

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
		// form 2 to str.length() need to search
		for (int i = 0; i < permutation.length(); ++i) {
			if (ch[i] == '1')
				continue;
			// find the quantity of digit which right i is smaller than i
			// save is char type so make count = 48 initialization
			int j = i + 1, count = 48;
			while (j < permutation.length()) {
				if (ch[i] > ch[j]) {
					++count;
				}
				++j;
			}
			int index = permutation.length() - 2 - ((int) ch[i] - 48 - 2);
			save[index] = (char) (count);// make count to char type
		}
		return String.valueOf(save);
	}

	@Override
	public String nextMediaNumber(String mediaNumber) {
		// TODO Auto-generated method stub
		char[] ch = mediaNumber.toCharArray();
		// int carry = 1;//to find the next number so initialization carry
		// equals to one
		for (int j = mediaNumber.length() - 1; j >= 0; --j) {
			// pow is from 2 to str.length()+1
			int pow = mediaNumber.length() - 1 - j + 2;
			ch[j] += 1;// denote next number or exist carry
			if (ch[j] >= pow + 48) {// ch[j] is char type
				// carry
				ch[j] = (char) (ch[j] - pow);
				// value = 1;
			} else {
				// while not exiting carry , stop the loop
				// carry = 0;
				break;
			}
		}
		return String.valueOf(ch);
	}

	@Override
	public String getPermutation(String mediaNumber) {
		// TODO Auto-generated method stub
		char[] ch = mediaNumber.toCharArray();
		char[] npm = new char[mediaNumber.length() + 1];// new permutation
														// number
		// initialization of npm
		for (int i = 0; i < mediaNumber.length() + 1; ++i)
			npm[i] = '0';// '0' represents space
		// find the digit position form interNumber + 1 to 1
		// count spaces form right to left
		for (int i = 0; i < mediaNumber.length() + 1; ++i) {
			int digit = mediaNumber.length() + 1 - i; // need to position

			// array index out of bound
			int count = 0;// make sure count = 0 while i = interNumber.length();
			if (i < mediaNumber.length()) {
				count = (int) (ch[i] - 48);// char type to int type
			}
			// System.out.println("count = " + count);
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
			//print as Media Number sequence of ascend permutation 
			//for (int i = 0; i < permutation.length(); ++i) {
			//	System.out.print(ch[i] - 48+ " ");
			//}
			//System.out.println("\t" + getMediaNumber(permutation));
			permutation = getPermutation(nextMediaNumber(getMediaNumber(permutation)));
		}
	}

}

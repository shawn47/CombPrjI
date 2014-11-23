package combPrj1.method;

public class AlphabetPermutation extends BaseFunction {

	@Override
	public String creatPermutation(int number) {
		// TODO Auto-generated method stub
		char[] ch = new char[number];  
		for(int i = 1 ; i <= number;++i)
			ch[i-1] = (char) (i + 48);
		return String.valueOf(ch);
	}

	@Override
	public String getMediaNumber(String permutation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nextMediaNumber(String mediaNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPermutation(String mediaNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void permutationAlgorathim(String permutation) {
		// TODO Auto-generated method stub
		char[] ch = permutation.toCharArray();
		//for(int i = 0 ; i < permutation.length() ; ++i ){
		//	System.out.print(ch[i]+" ");
		//}
		System.out.println();
		int times = 1;
		while (hasNextPermutation(getPosition(permutation))) {
			permutation = nextPermutation(permutation);
			//ch = permutation.toCharArray();
			//for(int i = 0 ; i < permutation.length() ; ++i ){
			//	System.out.print(ch[i]-48+" ");
			//}
			//System.out.println();
			++times;
		}
		System.out.println("times = " + times);
	}
	
	// find the position need to exchange with minimum number which is larger than it
	public int getPosition(String str) {
		int pos = -1;
		char[] ch = str.toCharArray();
		for (int i = str.length() - 1; i > 0; --i) {
			if (ch[i] > ch[i - 1]) {
				pos = i - 1;
				return pos;
			}
		}
		return pos;
	}
	
	public boolean hasNextPermutation(int pos) {
		if (pos == -1)
			return false;
		return true;
	}
	
	// string reverse
	public String reverseString(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < str.length() / 2; ++i) {
			char temp = ch[i];
			ch[i] = ch[str.length() - 1 - i];
			ch[str.length() - 1 - i] = temp;
		}
		str = String.valueOf(ch);
		return str;
	}
	
	// get next permutation of current number
	public String nextPermutation(String str) {
		// TODO Auto-generated method stub
		char[] ch = str.toCharArray();
		int pos = getPosition(str);
		if (pos >= 0) {
			// exchange the ch[position] with the minimum number which is lager
			// than it in its right.
			for (int i = pos + 1; i < str.length(); ++i) {
				if (i == str.length() - 1 && ch[i] > ch[pos]) {
					char temp = ch[pos];
					ch[pos] = ch[i];
					ch[i] = temp;
				} else if (ch[pos] > ch[i]) {
					char temp = ch[pos];
					ch[pos] = ch[i - 1];
					ch[i - 1] = temp;
					break;
				}
			}
			String substr1 = new String();
			substr1 = String.valueOf(ch, pos + 1, str.length() - pos - 1);
			substr1 = reverseString(substr1);
			return String.valueOf(ch, 0, pos + 1) + substr1;
		}
		return null;
	}
}

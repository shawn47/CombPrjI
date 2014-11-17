package combPrj1.method;

public abstract class BaseFunction {
	// get initialization permutation of scale is number
	public abstract String creatPermutation(int number);

	// get Media Number 0f original permutation number
	public abstract String getMediaNumber(String permutation);

	// next Media Number
	public abstract String nextMediaNumber(String mediaNumber);

	// get permutation via a Media Number
	public abstract String getPermutation(String mediaNumber);

	public abstract void permutationAlgorathim(String permutation);

	public int factorial(int n) {
		int sum = 1;
		while (n > 1) {
			sum *= (n--);
		}
		return sum;
	}
}

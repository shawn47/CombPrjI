package combPrj1.method;

public abstract class Permutation {
	protected int NUMBER = 3628800;
	public abstract int generateAllPermutation(int length);
	public abstract int generateAllDummy(int length);
	public abstract boolean generateNextPermutation(int[] permutation, int[] buffer, int length);
	public abstract void generateNextDummy(int[] a, int[] b, int c);
	public abstract void generateNextDummy(int[] a, int[] b, int[] c, int[] d, int e);
	public abstract boolean generateNextPermutation(int[] permutation, int[] location, int[] agentNumber, int[] buffer, int length);
}

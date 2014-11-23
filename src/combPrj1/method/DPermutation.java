package combPrj1.method;

public class DPermutation extends Permutation {
	@Override
	public int generateAllPermutation(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] agentNumber = new int[length];
		for (int i = 0; i < length; ++i)
			agentNumber[i] = 0;

		int number = 0;
		do
		{
			++number;

			/*OutputManager::outputPermutation(agentNumber, length);
			OutputManager::outputPermutation(permutation, length);
			OutputManager::blankLine();*/
		} while (generateNextPermutation(permutation, agentNumber, length));

		return number;
	}
	@Override
	public int generateAllDummy(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] agentNumber = new int[length];
		for (int i = 0; i < length; ++i)
			agentNumber[i] = 0;

		int number = 0;
		do
		{
			++number;

			generateNextDummy(permutation, agentNumber, length);
		} while (number < NUMBER);
		return number;
	}
	@Override
	public boolean generateNextPermutation(int[] permutation, int[] agentNumber, int length) {
		// 1 �н�����1
		// p�Ĺ���
		// p!*p ����p�Ĵ���; 1 �Ҳ���p�Ĵ���
		int pivot = length - 1; // ��ȡ���ӷ�����ֵ��1|2��
		while (pivot > 0) // ����n-p�Σ�p>0��or����n�Σ��Ҳ���p��|��ȡ���Ƚϡ���ת��2|1��
		{
			if (agentNumber[pivot] < pivot) // ��ȡ����ȡ���ӷ�����ȡ����ȡ���Ƚϡ���ת��3|4��
			{
				agentNumber[pivot] = agentNumber[pivot] + 1; // ��ȡ����ȡ���ӷ�����ȡ���ӷ�����ȡ����ȡ���ӷ�����ֵ��3|6��
				break; // ��ת��1|0��
			}
			else
			{
				agentNumber[pivot] = 0; // ��ȡ����ȡ���ӷ�����ֵ��1|3��
			}

			pivot = pivot - 1; // ��ȡ���ӷ�����ֵ��1|2��
		}

		if (pivot == 0) // ��ȡ���Ƚϡ���ת��2|1��
		{
			return false; // ��ת��1|0��
		}
		else
		{
			// 2 ����P_(n-a_p)��P_(n-a_p-1)��λ��
			int pivotLocation = (int)length - agentNumber[pivot]; // ��ȡ����ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��2|5��
			int pivotLocationMinusOne = pivotLocation - 1; // ��ȡ���ӷ�����ֵ��1|2��
			int temp = permutation[pivotLocation]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			permutation[pivotLocation] = permutation[pivotLocationMinusOne]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
			permutation[pivotLocationMinusOne] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��

			// 3 ��P_0��P_(n-p-2)�������У��ƶ����Ҳ�
			int diff = (int)length - 1 - pivot; // ��ȡ���ӷ�����ȡ���ӷ�����ֵ��2|3��
			for (int i = 0; i <= pivot; ++i) // ����p+1��|��ֵ��0|1��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ��1|2��
			{
				permutation[i] = permutation[(diff + i)]; // ��ȡ����ȡ���ӷ�����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��3|7��
			}
			for (int i = pivot + 1; i < length; ++i) // ����n-p-1��|��ȡ���ӷ�����ֵ��1|2��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ��1|2��
			{
				permutation[i] = i + 1; // ��ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��2|4��
			}

			return true; // ��ת��1|0��
		}
	}
	@Override
	public void generateNextDummy(int[] a, int[] b, int c) {

	}
	@Override
	public void generateNextDummy(int[] a, int[] b, int[] c, int[] d, int e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean generateNextPermutation(int[] permutation, int[] location,
			int[] agentNumber, int[] buffer, int length) {
		// TODO Auto-generated method stub
		return false;
	}

}
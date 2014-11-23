package combPrj1.method;

public class IPermutation extends Permutation {
	@Override
	public int generateAllPermutation(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] location = new int[length];
		for (int i = 0; i < length; ++i)
			location[i] = i;

		int[] agentNumber = new int[length];
		for (int i = 0; i < length; ++i)
			agentNumber[i] = 0;

		int[] buffer = new int[length];
		for (int i = 0; i < length; ++i)
			buffer[i] = 0;

		int number = 0;
		do
		{
			++number;

			/*OutputManager::outputPermutation(agentNumber, length);
			OutputManager::outputPermutation(permutation, length);
			OutputManager::blankLine();*/
		} while (generateNextPermutation(permutation, location, agentNumber, buffer, length));

		return number;
	}
	@Override
	public int generateAllDummy(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] location = new int[length];
		for (int i = 0; i < length; ++i)
			location[i] = i;

		int[] agentNumber = new int[length];
		for (int i = 0; i < length; ++i)
			agentNumber[i] = 0;

		int[] buffer = new int[length];
		for (int i = 0; i < length; ++i)
			buffer[i] = 0;

		int number = 0;
		do
		{
			++number;
			generateNextDummy(permutation, location, agentNumber, buffer, length);
		} while (number < NUMBER);

		return number;
	}
	@Override
	public boolean generateNextPermutation(int[] permutation, int[] location, int[] agentNumber, int[] buffer, int length) {
		// 1 �н�����1
		// p�Ĺ���
		// (n!/(p+1)!)*p ����p�Ĵ���; 1 �Ҳ���p�Ĵ���
		int pivot = 1; // ��ֵ��0|1��
		while (pivot < length) // ����p�Σ�p<n��or����n�Σ��Ҳ���p��|��ȡ����ȡ���Ƚϡ���ת��2|2��
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

			pivot = pivot + 1; // ��ȡ���ӷ�����ֵ��1|2��
		}

		if (pivot == length) // ��ȡ����ȡ���Ƚϡ���ת��2|2��
		{
			return false; // ��ת��1|0��
		}
		else
		{
			// 2 ����p+1��a_p��λ��
			int target = agentNumber[pivot] - 1; // ��ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��2|4��
			int temp = location[target]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			location[target] = location[pivot]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
			location[pivot] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��

			permutation[location[target]] = target + 1; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��3|6��
			permutation[location[pivot]] = pivot + 1; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��3|6��

			// 3 ��1��p��������
			int bufferLength = pivot; // ��ȡ����ֵ��0|2��
			for (int i = 0; i < bufferLength; ++i) // ����p��|��ֵ��0|1��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ��1|2��
			{
				buffer[i] = location[i]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
			}
			for (int i = 0, j = bufferLength - 1; i < bufferLength; ++i, --j) // ����p��|��ֵ����ȡ���ӷ�����ֵ��1|3��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ����ȡ���ӷ�����ֵ��2|4��
			{
				location[j] = buffer[i]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ����ֵ��2|6��
				permutation[location[j]] = j + 1; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��3|6��
			}

			return true; // ��ת��1|0��
		}
	}
	@Override
	public void generateNextDummy(int[] a, int[] b, int[] c, int[] d, int e) {

	}
	@Override
	public boolean generateNextPermutation(int[] permutation, int[] buffer,
			int length) {
		return false;
	}
	@Override
	public void generateNextDummy(int[] a, int[] b, int c) {
		
	}
}

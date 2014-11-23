package combPrj1.method;

public class NPermutation extends Permutation{
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
		while (pivot > 0) // ����n-p��(p>0)or����n��(�Ҳ���p)|��ȡ���Ƚϡ���ת��2|1��
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
			// 2 �ж�p��a_p����ż�ԣ������жϽ�����������ƫ����
			int pivotMod = pivot % 2; // ��ȡ��ȡģ����ֵ��1|2��
			int agentPivotMod = agentNumber[pivot] % 2; // ��ȡ����ȡ���ӷ�����ȡ��ȡģ����ֵ��2|4��

			int leftDisp = 0; // ��ֵ��0|1��
			int toRight = 0; // ��ֵ��0|1��

			if (pivotMod == 1) // ��ȡ���Ƚϡ���ת��2|1��
			{
				if (pivot > 1) // ��ȡ���Ƚϡ���ת��2|1��
				{
					toRight = (agentNumber[(pivot - 1)] + agentNumber[(pivot - 2)]) % 2; // ��ȡ���ӷ�����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ȡ���ӷ���ȡģ����ֵ��6|7��
				}
				else
				{
					toRight = 0; // ��ֵ��0|1��
				}

				if (agentPivotMod == 1) // ��ȡ���Ƚϡ���ת��2|1��
				{
					leftDisp = 2; // ��ֵ��0|1��
				}
			}
			else
			{
				toRight = agentNumber[(pivot - 1)] % 2; // ��ȡ���ӷ�����ȡ���ӷ�����ȡ��ȡģ����ֵ��3|4��

				if (agentPivotMod == 1) // ��ȡ���Ƚϡ���ת��2|1��
				{
					if (toRight == 0) // ��ȡ���Ƚϡ���ת��2|1��
					{
						leftDisp = 1; // ��ֵ��0|1��
					}
				}
				else
				{
					if (toRight == 1) // ��ȡ���Ƚϡ���ת��2|1��
					{
						leftDisp = 1; // ��ֵ��0|1��
					}
				}
			}

			if (pivot + leftDisp >= length) // ��ȡ����ȡ���ӷ�����ȡ���Ƚϡ���ת��3|3��
				leftDisp = (int)length - pivot - 1; // ��ȡ����ȡ���ӷ����ӷ�����ֵ��2|3��

			// 3 ������ҽ���P_((a_p)+l)��P_((a_p)+l-1)��������󽻻�P_(p-(a_p)+l)��P_(p-(a_p)+l+1)
			if (toRight == 1) // ��ȡ���Ƚϡ���ת��2|1��
			{
				int index1 = agentNumber[pivot] + leftDisp; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ֵ��2|5��
				int index2 = index1 - 1; // ��ȡ���ӷ�����ֵ��1|2��

				int temp = permutation[index1]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
				permutation[index1] = permutation[index2]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
				permutation[index2] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			}
			else
			{
				int index1 = pivot - agentNumber[pivot] + leftDisp; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ֵ��3|6��
				int index2 = index1 + 1; // ��ȡ���ӷ�����ֵ��1|2��

				int temp = permutation[index1]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
				permutation[index1] = permutation[index2]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
				permutation[index2] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			}

			return true; // ��ת��1|0��
		}
	}
	@Override
	public void generateNextDummy(int[] a, int[] b, int c) {

	}

	@Override
	public void generateNextDummy(int[] a, int[] b, int[] c, int[] d, int e) {
		
	}

	@Override
	public boolean generateNextPermutation(int[] permutation, int[] location,
			int[] agentNumber, int[] buffer, int length) {
		return false;
	}
}


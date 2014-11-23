package combPrj1.method;

public class APermutation extends Permutation {
	@Override
	public int generateAllPermutation(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] buffer = new int[length];
		for (int i = 0; i < length; ++i)
			buffer[i] = 0;

		int number = 0;
		do 
		{
			++number;
			/*OutputManager::outputPermutation(permutation, length);
			OutputManager::blankLine();*/
		} while (generateNextPermutation(permutation, buffer, length));


		return number;
	}
	@Override
	public int generateAllDummy(int length) {
		int[] permutation = new int[length];
		for (int i = 0; i < length; ++i)
			permutation[i] = i + 1;

		int[] buffer = new int[length];
		for (int i = 0; i < length; ++i)
			buffer[i] = 0;

		int number = 0;
		do 
		{
			++number;
			generateNextDummy(permutation, buffer, length);
		} while (number < NUMBER);

		return number;
	}
	@Override
	public boolean generateNextPermutation(int[] permutation, int[] buffer, int length) {
		// P_0 ~ P_n-1
		// n

		// 1 ��������Ѱ�ҵ�һ���½�����P_p
		// p�Ĺ���
		// (n!/��n-p��!)*(n-p-1) ����p�Ĵ���; 1 �Ҳ���p�Ĵ���
		int pivot = length - 2; // ����1��|��ȡ���ӷ�����ֵ��1|2��
		while (pivot >= 0) // ����n-p-1�Σ�p>=0��or����n�Σ��Ҳ���p��|��ȡ���Ƚϡ���ת��2|1��
		{
			if (permutation[pivot] < permutation[(pivot + 1)]) // ����n-p-1�Σ�p>=0��or����n-1�Σ��Ҳ���p��|��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ���ӷ�����ȡ���Ƚϡ���ת��5|6��
				break; // ����1�Σ�p>=0��or����0�Σ��Ҳ���p��|��ת��1|0��

			pivot = pivot - 1; // ����n-p-2�Σ�p>=0��or����n-1�Σ��Ҳ���p��|��ȡ���ӷ�����ֵ��1|2��
		}

		if (pivot < 0) // ����1��|��ȡ���Ƚϡ���ת��2|1��
		{
			return false; // ����1�Σ��Ҳ���p��or����0�Σ�p>=0��|��ת��1|0��
		}
		else
		{

			// 2 ��P_p+1��P_n-1���۰���ҵ���P_p�����С��P_j
			// ����(n-1)-(p+1)+1=n-p-1
			int head = pivot + 1; // ����1�Σ�p>=0��or����0�Σ��Ҳ���p��|��ȡ���ӷ�����ֵ��1|2��
			int tail = length - 1; // ����1�Σ�p>=0��|��ȡ���ӷ�����ֵ��1|2��
			while (head < tail - 1) // ����log2(n-p-1)�Σ�����ֵ��|��ȡ����ȡ���ӷ����Ƚϡ���ת��3|2��
			{
				int pin = (head + tail) / 2; // ��ȡ����ȡ���ӷ�����������ֵ��2|3��
				if (permutation[pin] < permutation[pivot]) // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ȡ���Ƚϡ���ת��4|6��
				{
					tail = pin - 1; // ��ȡ���ӷ�����ֵ��1|2��
					continue; // ��ת��1|0��
				}
				else
				{
					head = pin; // ��ȡ����ֵ��0|2��
					continue; // ��ת��1|0��
				}
			}

			// 3 ����P_p��P_j��λ��
			if (permutation[tail] > permutation[pivot]) // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ȡ���Ƚϡ���ת��4|6��
			{
				int temp = permutation[tail]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
				permutation[tail] = permutation[pivot]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
				permutation[pivot] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			}
			else
			{
				int temp = permutation[head]; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
				permutation[head] = permutation[pivot]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ����ȡ���ӷ�����ֵ��2|6��
				permutation[pivot] = temp; // ��ȡ����ȡ���ӷ�����ȡ����ֵ��1|4��
			}

			// 4 ��������P_p+1��P_n-1
			int bufferLength = (int)length - pivot - 1; // ��ȡ����ȡ���ӷ����ӷ�����ֵ��2|3��
			for (int i = 0, j = pivot + 1; i < bufferLength; ++i, ++j) // ����n-p-1��|��ֵ����ȡ���ӷ�����ֵ��1|3��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ����ȡ���ӷ�����ֵ��2|4��
			{
				buffer[i] = permutation[j]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ����ֵ��2|6��
			}
			for (int i = 0, j = length - 1; i < bufferLength; ++i, --j) // ����n-p-1��|��ֵ����ȡ���ӷ�����ֵ��1|3��;��ȡ����ȡ���Ƚϡ���ת��2|2��;��ȡ���ӷ�����ֵ����ȡ���ӷ�����ֵ��2|4��
			{
				permutation[j] = buffer[i]; // ��ȡ����ȡ���ӷ�����ȡ����ȡ���ӷ�����ȡ����ֵ��2|6��
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

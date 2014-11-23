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

		// 1 从右向左寻找第一个下降的数P_p
		// p的规律
		// (n!/（n-p）!)*(n-p-1) 出现p的次数; 1 找不到p的次数
		int pivot = length - 2; // 运行1次|读取、加法、赋值（1|2）
		while (pivot >= 0) // 运行n-p-1次（p>=0）or运行n次（找不到p）|读取、比较、跳转（2|1）
		{
			if (permutation[pivot] < permutation[(pivot + 1)]) // 运行n-p-1次（p>=0）or运行n-1次（找不到p）|读取、读取、加法、读取、读取、加法、读取、加法、读取、比较、跳转（5|6）
				break; // 运行1次（p>=0）or运行0次（找不到p）|跳转（1|0）

			pivot = pivot - 1; // 运行n-p-2次（p>=0）or运行n-1次（找不到p）|读取、加法、赋值（1|2）
		}

		if (pivot < 0) // 运行1次|读取、比较、跳转（2|1）
		{
			return false; // 运行1次（找不到p）or运行0次（p>=0）|跳转（1|0）
		}
		else
		{

			// 2 从P_p+1到P_n-1中折半查找到比P_p大的最小数P_j
			// 长度(n-1)-(p+1)+1=n-p-1
			int head = pivot + 1; // 运行1次（p>=0）or运行0次（找不到p）|读取、加法、赋值（1|2）
			int tail = length - 1; // 运行1次（p>=0）|读取、加法、赋值（1|2）
			while (head < tail - 1) // 运行log2(n-p-1)次（粗略值）|读取、读取、加法、比较、跳转（3|2）
			{
				int pin = (head + tail) / 2; // 读取、读取、加法、除法、赋值（2|3）
				if (permutation[pin] < permutation[pivot]) // 读取、读取、加法、读取、读取、读取、加法、读取、比较、跳转（4|6）
				{
					tail = pin - 1; // 读取、加法、赋值（1|2）
					continue; // 跳转（1|0）
				}
				else
				{
					head = pin; // 读取、赋值（0|2）
					continue; // 跳转（1|0）
				}
			}

			// 3 交换P_p与P_j的位置
			if (permutation[tail] > permutation[pivot]) // 读取、读取、加法、读取、读取、读取、加法、读取、比较、跳转（4|6）
			{
				int temp = permutation[tail]; // 读取、读取、加法、读取、赋值（1|4）
				permutation[tail] = permutation[pivot]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
				permutation[pivot] = temp; // 读取、读取、加法、读取、赋值（1|4）
			}
			else
			{
				int temp = permutation[head]; // 读取、读取、加法、读取、赋值（1|4）
				permutation[head] = permutation[pivot]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
				permutation[pivot] = temp; // 读取、读取、加法、读取、赋值（1|4）
			}

			// 4 反向排列P_p+1到P_n-1
			int bufferLength = (int)length - pivot - 1; // 读取、读取、加法、加法、赋值（2|3）
			for (int i = 0, j = pivot + 1; i < bufferLength; ++i, ++j) // 运行n-p-1次|赋值、读取、加法、赋值（1|3）;读取、读取、比较、跳转（2|2）;读取、加法、赋值、读取、加法、赋值（2|4）
			{
				buffer[i] = permutation[j]; // 读取、读取、加法、读取、读取、加法、读取、赋值（2|6）
			}
			for (int i = 0, j = length - 1; i < bufferLength; ++i, --j) // 运行n-p-1次|赋值、读取、加法、赋值（1|3）;读取、读取、比较、跳转（2|2）;读取、加法、赋值、读取、加法、赋值（2|4）
			{
				permutation[j] = buffer[i]; // 读取、读取、加法、读取、读取、加法、读取、赋值（2|6）
			}
			return true; // 跳转（1|0）
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

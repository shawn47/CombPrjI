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
		// 1 中介数加1
		// p的规律
		// (n!/(p+1)!)*p 出现p的次数; 1 找不到p的次数
		int pivot = 1; // 赋值（0|1）
		while (pivot < length) // 运行p次（p<n）or运行n次（找不到p）|读取、读取、比较、跳转（2|2）
		{
			if (agentNumber[pivot] < pivot) // 读取、读取、加法、读取、读取、比较、跳转（3|4）
			{
				agentNumber[pivot] = agentNumber[pivot] + 1; // 读取、读取、加法、读取、加法、读取、读取、加法、赋值（3|6）
				break; // 跳转（1|0）
			}
			else
			{
				agentNumber[pivot] = 0; // 读取、读取、加法、赋值（1|3）
			}

			pivot = pivot + 1; // 读取、加法、赋值（1|2）
		}

		if (pivot == length) // 读取、读取、比较、跳转（2|2）
		{
			return false; // 跳转（1|0）
		}
		else
		{
			// 2 交换p+1和a_p的位置
			int target = agentNumber[pivot] - 1; // 读取、读取、加法、读取、加法、赋值（2|4）
			int temp = location[target]; // 读取、读取、加法、读取、赋值（1|4）
			location[target] = location[pivot]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
			location[pivot] = temp; // 读取、读取、加法、读取、赋值（1|4）

			permutation[location[target]] = target + 1; // 读取、读取、加法、读取、读取、加法、读取、加法、赋值（3|6）
			permutation[location[pivot]] = pivot + 1; // 读取、读取、加法、读取、读取、加法、读取、加法、赋值（3|6）

			// 3 将1到p反向排列
			int bufferLength = pivot; // 读取、赋值（0|2）
			for (int i = 0; i < bufferLength; ++i) // 运行p次|赋值（0|1）;读取、读取、比较、跳转（2|2）;读取、加法、赋值（1|2）
			{
				buffer[i] = location[i]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
			}
			for (int i = 0, j = bufferLength - 1; i < bufferLength; ++i, --j) // 运行p次|赋值、读取、加法、赋值（1|3）;读取、读取、比较、跳转（2|2）;读取、加法、赋值、读取、加法、赋值（2|4）
			{
				location[j] = buffer[i]; // 读取、读取、加法、读取、读取、加法、读取、赋值（2|6）
				permutation[location[j]] = j + 1; // 读取、读取、加法、读取、读取、加法、读取、加法、赋值（3|6）
			}

			return true; // 跳转（1|0）
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

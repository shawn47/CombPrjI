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
		// 1 中介数加1
		// p的规律
		// p!*p 出现p的次数; 1 找不到p的次数
		int pivot = length - 1; // 读取、加法、赋值（1|2）
		while (pivot > 0) // 运行n-p次（p>0）or运行n次（找不到p）|读取、比较、跳转（2|1）
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

			pivot = pivot - 1; // 读取、加法、赋值（1|2）
		}

		if (pivot == 0) // 读取、比较、跳转（2|1）
		{
			return false; // 跳转（1|0）
		}
		else
		{
			// 2 交换P_(n-a_p)和P_(n-a_p-1)的位置
			int pivotLocation = (int)length - agentNumber[pivot]; // 读取、读取、读取、加法、读取、加法、赋值（2|5）
			int pivotLocationMinusOne = pivotLocation - 1; // 读取、加法、赋值（1|2）
			int temp = permutation[pivotLocation]; // 读取、读取、加法、读取、赋值（1|4）
			permutation[pivotLocation] = permutation[pivotLocationMinusOne]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
			permutation[pivotLocationMinusOne] = temp; // 读取、读取、加法、读取、赋值（1|4）

			// 3 将P_0到P_(n-p-2)反向排列，移动到右侧
			int diff = (int)length - 1 - pivot; // 读取、加法、读取、加法、赋值（2|3）
			for (int i = 0; i <= pivot; ++i) // 运行p+1次|赋值（0|1）;读取、读取、比较、跳转（2|2）;读取、加法、赋值（1|2）
			{
				permutation[i] = permutation[(diff + i)]; // 读取、读取、加法、读取、加法、读取、读取、读取、加法、赋值（3|7）
			}
			for (int i = pivot + 1; i < length; ++i) // 运行n-p-1次|读取、加法、赋值（1|2）;读取、读取、比较、跳转（2|2）;读取、加法、赋值（1|2）
			{
				permutation[i] = i + 1; // 读取、读取、加法、读取、加法、赋值（2|4）
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

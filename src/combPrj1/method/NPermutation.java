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
		// 1 中介数加1
		// p的规律
		// p!*p 出现p的次数; 1 找不到p的次数
		int pivot = length - 1; // 读取、加法、赋值（1|2）
		while (pivot > 0) // 运行n-p次(p>0)or运行n次(找不到p)|读取、比较、跳转（2|1）
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
			// 2 判断p和a_p的奇偶性，进而判断交换方向和左侧偏移量
			int pivotMod = pivot % 2; // 读取、取模、赋值（1|2）
			int agentPivotMod = agentNumber[pivot] % 2; // 读取、读取、加法、读取、取模、赋值（2|4）

			int leftDisp = 0; // 赋值（0|1）
			int toRight = 0; // 赋值（0|1）

			if (pivotMod == 1) // 读取、比较、跳转（2|1）
			{
				if (pivot > 1) // 读取、比较、跳转（2|1）
				{
					toRight = (agentNumber[(pivot - 1)] + agentNumber[(pivot - 2)]) % 2; // 读取、加法、读取、加法、读取、读取、加法、读取、加法、读取、加法、取模、赋值（6|7）
				}
				else
				{
					toRight = 0; // 赋值（0|1）
				}

				if (agentPivotMod == 1) // 读取、比较、跳转（2|1）
				{
					leftDisp = 2; // 赋值（0|1）
				}
			}
			else
			{
				toRight = agentNumber[(pivot - 1)] % 2; // 读取、加法、读取、加法、读取、取模、赋值（3|4）

				if (agentPivotMod == 1) // 读取、比较、跳转（2|1）
				{
					if (toRight == 0) // 读取、比较、跳转（2|1）
					{
						leftDisp = 1; // 赋值（0|1）
					}
				}
				else
				{
					if (toRight == 1) // 读取、比较、跳转（2|1）
					{
						leftDisp = 1; // 赋值（0|1）
					}
				}
			}

			if (pivot + leftDisp >= length) // 读取、读取、加法、读取、比较、跳转（3|3）
				leftDisp = (int)length - pivot - 1; // 读取、读取、加法、加法、赋值（2|3）

			// 3 如果向右交换P_((a_p)+l)和P_((a_p)+l-1)，如果向左交换P_(p-(a_p)+l)和P_(p-(a_p)+l+1)
			if (toRight == 1) // 读取、比较、跳转（2|1）
			{
				int index1 = agentNumber[pivot] + leftDisp; // 读取、读取、加法、读取、读取、加法、赋值（2|5）
				int index2 = index1 - 1; // 读取、加法、赋值（1|2）

				int temp = permutation[index1]; // 读取、读取、加法、读取、赋值（1|4）
				permutation[index1] = permutation[index2]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
				permutation[index2] = temp; // 读取、读取、加法、读取、赋值（1|4）
			}
			else
			{
				int index1 = pivot - agentNumber[pivot] + leftDisp; // 读取、读取、加法、读取、读取、加法、读取、加法、赋值（3|6）
				int index2 = index1 + 1; // 读取、加法、赋值（1|2）

				int temp = permutation[index1]; // 读取、读取、加法、读取、赋值（1|4）
				permutation[index1] = permutation[index2]; // 读取、读取、加法、读取、读取、读取、加法、赋值（2|6）
				permutation[index2] = temp; // 读取、读取、加法、读取、赋值（1|4）
			}

			return true; // 跳转（1|0）
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


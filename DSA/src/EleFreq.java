public class EleFreq {

	public static void main(String[] args) {
		int arr[] = {5, 3, 2, 7, 8, 5, 7, 2, 8, 5, 7, 7, 8, 3, 5, 2, 7, 2};
		uArr(arr);

	}
	static void uArr(int[] arr)
	{
		int l = arr.length;
		for(int i = 0; i < l; i++)
		{
			if(!found(i,arr))
			{
				int c = 0;
				for(int j = i + 1;j < l; j++)
				{
					if (arr[i] == arr[j])
						c++;
				}
				System.out.println(arr[i] + "'s frequency is : " + c);
			}
		}
	}
	static boolean found(int ind, int[] arr)
	{
		boolean k = false;
		for(int j = ind - 1; j >= 0; j--)
		{
			if(arr[ind] == arr[j])
			{
				k = true;
				break;
			}
			else
				k = false;
		}
		return k;
	}

}
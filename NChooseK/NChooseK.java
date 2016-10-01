//import java.util.ArrayList; // The ArrayList library
//import java.util.Arrays; // The Arrays Library
//import java.util.concurrent.CopyOnWriteArrayList;

public class NChooseK
{
	NChooseK()
	{
		// empty
	}
//       1
//      1 1	
//     1 2 1	
//    1 3 3 1	
	int nChooseK(int n, int k)
	{
		if(n<2)
			return 1;
		if(k==0 || n == k)
			return 1;
		return nChooseK(n-1, k - 1) + nChooseK(n-1, k);
	}


}

class NChooseKApp
{
	public static void main(String[] args)
	{
		NChooseK nChooseK = new NChooseK();
		System.out.println(nChooseK.nChooseK(5, 2));
		System.out.println(nChooseK.nChooseK(10, 5));
		
	}
}
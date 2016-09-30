public class MakeBranches
{
	String[][] output;
	int currentRow = 0;
	int columns = 1;
	int rows = 1;
	MakeBranches(int rows)
	{
		columns = (int) Math.pow(2.0, (double) rows);
		this.rows = rows;
		output = new String[rows][columns];
		for(int i=0; i<output.length; i++)
		{
			for(int j=0; j<output[0].length; j++)
			{
				output[i][j] = "-";
			}
		}		
	}


	void makeBranches()
	{
		currentRow = 0;
		recMakeBranches(0, 0, columns - 1);
	}

	void recMakeBranches(int curRow, int left, int right)
	{
		if(curRow>rows-1)
			{
				return;
			}
		int midPoint = (right + left) / 2;
		for(int j=left; j<right; j++)
		{
			if(j==midPoint)
				output[curRow][j] = "X";
		}


		recMakeBranches(curRow+1, left, midPoint);
		recMakeBranches(curRow+1, midPoint + 1, right);
	}



	void display()
	{	
		for(int i=0; i<output.length; i++)
		{
			for(int j=0; j<output[0].length; j++)
			{
				System.out.print(output[i][j]);
			}
			System.out.println("");
		}
	}
}

class makeBranchesApp
{
	public static void main(String[] args)
	{
		MakeBranches makeBranches = new MakeBranches(Integer.parseInt(args[0]));
		makeBranches.makeBranches();
		makeBranches.display();
	}
}
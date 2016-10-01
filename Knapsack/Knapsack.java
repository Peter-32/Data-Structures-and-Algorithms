import java.util.ArrayList; // The ArrayList library
import java.util.Arrays; // The Arrays Library
import java.util.concurrent.CopyOnWriteArrayList;

public class Knapsack
{
	Boolean solutionFound = false;
	Knapsack()
	{
		// empty
	}


	public void knapsack(int target, CopyOnWriteArrayList<Integer> remainingChoices)
	{
		CopyOnWriteArrayList<Integer> choicesSoFar = new CopyOnWriteArrayList<Integer>();
		CopyOnWriteArrayList<Integer> startChoices = new CopyOnWriteArrayList<Integer>();
		startChoices.addAll(remainingChoices);
		solutionFound = false;
		recKnapsack(target, remainingChoices, choicesSoFar,
			startChoices, target);
	}

	public void recKnapsack(int target, CopyOnWriteArrayList<Integer> remainingChoices, CopyOnWriteArrayList<Integer> choicesSoFar,
		CopyOnWriteArrayList<Integer> startChoices, int startTarget)
	{
		//System.out.println("Target is: " + target);
		for(int i=0; i<startChoices.size(); i++)
		{
			if(solutionFound)
				return;
			for(int choice : remainingChoices)
			{
				if(choice > target)
				{
					//System.out.println("choice " + choice + " is too high.");
					continue;
				}
					
				if(choice == target)
				{
					solutionFound=true;
					System.out.println("--------------------FOUND ANSWER--------------------");
					choicesSoFar.add(new Integer(choice));
					for(int answer : choicesSoFar)
						System.out.print(answer + " ");
					System.out.println("");
					return;
				}
				if(choice < target)
				{
					//System.out.println("Removing choice " + choice);
					remainingChoices.remove(new Integer(choice));
					//System.out.println("Adding choice " + choice);
					choicesSoFar.add(new Integer(choice));
					//System.out.println("Calling recursion");
					recKnapsack(target - choice, remainingChoices, choicesSoFar, startChoices, startTarget);
				}
			}
			// reset
			remainingChoices = new CopyOnWriteArrayList<Integer>();
			choicesSoFar = new CopyOnWriteArrayList<Integer>();
			target = startTarget;
			remainingChoices.addAll(startChoices);
			for(int j=0; j<=i; j++)
				remainingChoices.remove(0);
		}
		// print out answers
	}

}

class KnapsackApp
{
	public static void main(String[] args)
	{
		Knapsack knapsack = new Knapsack();
		CopyOnWriteArrayList<Integer> choices = new CopyOnWriteArrayList<Integer>(Arrays.asList(11,8,7,6,5,23,62,43,2,325,325,63,3,2,34,6,32,34,23,45,6,32,2,3));
		

		knapsack.knapsack(200, choices);




		// for (int choice : knapsack.choices){
		// 	System.out.println(choice);
		// }
	}
}
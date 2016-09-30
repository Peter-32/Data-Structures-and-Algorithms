public class RaiseNumberPower
{
	RaiseNumberPower()
	{
		// empty
	}


	public double raiseNumberPower(double x, double p)
	{
		if(p==0)
			return 1;
		if(p==1)
			return x;
		if(p%2==0)
			return raiseNumberPower(x*x, p/2);
		else
			return raiseNumberPower(x*x, (p+1)/2)/x;
	}

}

class RaiseNumberPowerApp
{
	public static void main(String[] args)
	{
		RaiseNumberPower raiseNumberPower = new RaiseNumberPower();
		double output = raiseNumberPower.raiseNumberPower(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
		System.out.println("output = " + output);
	}
}
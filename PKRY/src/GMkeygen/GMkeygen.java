import java.math.BigInteger;
import java.util.Random;

public class GMkeygen {
	
	public BigInteger genPrime(int length)
	{
		boolean isPrime=false;
		BigInteger prand = null;
		while(!isPrime)
		{
		prand = new BigInteger(length, 100, new Random());
		BigInteger rand=prand.multiply(new BigInteger("2")).add(new BigInteger("1"));
		AKS primeTest1 = new AKS(prand);
		AKS primeTest2 = new AKS(rand);
		isPrime=(primeTest1.isPrime()&&primeTest2.isPrime());
		if (isPrime){
		System.out.println("Generated prime: " + prand);
		}
		}
		return prand;
		
	}
public BigInteger ngen(int length)
{
	BigInteger p,q;
	
	p=genPrime(length);
	q=genPrime(length);
	BigInteger n=p.multiply(q);
	return n;
	
}
public GMkeygen()
{
	System.out.println(ngen(5));
}
public static void main(String[] args)
{
	GMkeygen m=new GMkeygen();
}
}
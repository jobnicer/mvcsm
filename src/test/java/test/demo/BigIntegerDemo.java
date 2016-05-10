package test.demo;

import java.math.BigInteger;

public class BigIntegerDemo {

public static void main(String[] args) {

	// create a BigInteger object
	BigInteger bi;

	// create 2 boolean objects
	Boolean b1, b2;

	bi = new BigInteger("10"); 

	// perform testbit on bi at index 2 and 3
	b1 = bi.testBit(2);
	b2 = bi.testBit(3);

	String str1 = "Test Bit on " + bi + " at index 2 returns " +b1;
	String str2 = "Test Bit on " + bi + " at index 3 returns " +b2;

	// print b1, b2 values
	System.out.println( str1 );
	System.out.println( str2 );
	
	BigInteger ai = new BigInteger("0"); 
	ai=ai.setBit(4);
//	ai=ai.setBit(2);
	System.out.println(ai);
	String  str = null;
	if(org.apache.commons.lang.StringUtils.isEmpty(str)) {
		System.out.println("OK");
	}
	
   }
}
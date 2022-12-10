package com.ars.overview;

import java.math.BigDecimal;

/**
 * Why not to use floating point variable like float and double in loops to compare for equality
 * @author rksck
 *
 */
public class Question2 {
	
	/*
	 * This method will cause the program to run in infinite loop because floating point data type like
	 * float or double yields long precision value and it will take forever to give result.
	 */
	private static void  floatingPointLoopToCompareEquality() {
		float sum = 0;
        while (sum != 1.0) { // this line causes infinite loop.
            sum += 0.1;
            System.out.println("Sum = "+sum);
        }
        System.out.print("The sum is: "+sum);
	}
	
	private static void fixForAboveMethod() {
		BigDecimal sum = BigDecimal.ZERO;
        while (sum.compareTo(BigDecimal.ONE) != 0) { 
            sum=sum.add(BigDecimal.valueOf(0.1));
            System.out.println("Sum = "+sum);
        }
        System.out.print("The sum is: "+sum);
	}
	
	public static void main(String[] args) {
		//floatingPointLoopToCompareEquality();
		fixForAboveMethod();
	}

}

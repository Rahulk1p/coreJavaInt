package com.ars.overview;

import java.math.BigDecimal;

/**
 * Why Using floating point data types like float or double are not good for monetary calculations ?
 * @author rksck
 *
 */
public class Question1 {
	public static void main(String[] args) {
		/*
		 * Below code will yield 0.6300000000000001 which is not correct usage, because of rounding issue
		 */
		System.out.println(1.05 - 0.42); 
		/*
		 * Below code will yield output as 0.63 which is correct usage because it give correct precision value.
		 */
		System.out.println(new BigDecimal("1.05").subtract(new BigDecimal("0.42")));
		
		/*
		 * Below code will yield output as 0.630000000000000059952043329758453182876110076904296875
		 * which is not correct usage because it give incorrect precision value.
		 */
		System.out.println(new BigDecimal(1.05).subtract(new BigDecimal(0.42)));
		
		/*
		 * Below code will yield output as 0.63
		 * which is correct usage because it give correct precision value.
		 */
		System.out.println(BigDecimal.valueOf(1.05).subtract(BigDecimal.valueOf(0.42)));
		
		/*
		 * Below code will yield output as 63 cents which is correct usage
		 */
		System.out.println(105-42);
	}
}

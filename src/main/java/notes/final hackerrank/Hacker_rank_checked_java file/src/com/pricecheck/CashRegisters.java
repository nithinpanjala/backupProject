package com.pricecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CashRegisters {
	public static int priceCheck(List<String> products,List<Float> productPrices, List<String> productsSold, List<Float> soldPrices) {
		/*
		 * int countOfErrors = 0;
		 * 
		 * Map<String, Float> map = new HashMap<String, Float>(); for (int i = 0; i <
		 * products.length; i++) { map.put(products[i], productPrices[i]); }
		 * 
		 * for (int i = 0; i < productsSold.length; i++) { if(map.get(productsSold[i])
		 * != soldPrices[i] ) { countOfErrors++; } }
		 * 
		 * return countOfErrors;
		 */
		
		int counter = 0;
		for(int i=0;i<productsSold.size();i++){
			String str1 = productsSold.get(i);
			int i1 = products.indexOf(str1);
			
			Float f1 = productPrices.get(i1);
			Float f2 = soldPrices.get(i);
			
			if(f1>f2 || f1<f2){
				counter = counter + 1;
			}

		}
		return counter;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of products array");
		int noOfProducts = scanner.nextInt();
		
		List<String> products = new ArrayList<String>();
		
		System.out.println("Enter elements of an array");
		for (int i = 0; i < noOfProducts; i++) {
			products.add(scanner.next());
		}
		
		System.out.println("Enter size of product prices array");
		int noOfProductPrices = scanner.nextInt();
		
		List<Float> productPrices = new ArrayList<Float>();
		
		System.out.println("Enter elements of an array");
		for (int i = 0; i < noOfProductPrices; i++) {
			productPrices.add(scanner.nextFloat());
		}
		
		
		System.out.println("Enter size of products sold array");
		int noOfProductsSold= scanner.nextInt();
		
		List<String> productsSold = new ArrayList<String>();
		
		System.out.println("Enter elements of an array");
		for (int i = 0; i < noOfProductsSold; i++) {
			productsSold.add(scanner.next());
		}
		
		
		System.out.println("Enter size of sold price array");
		int noOfSoldPrices= scanner.nextInt();
		
		List<Float> soldPrices = new ArrayList<Float>();
		
		System.out.println("Enter elements of an array");
		for (int i = 0; i < noOfSoldPrices; i++) {
			soldPrices.add(scanner.nextFloat());
		}
		
		scanner.close();
		
		System.out.println(priceCheck(products, productPrices, productsSold, soldPrices));
	}
}

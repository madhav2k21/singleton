package com.techleads.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Register {

	private static Register register = null;
	/*
	 * Complete the 'getTotalBill' function below.
	 *
	 * The function is expected to return a STRING. The function accepts MAP
	 * itemDetails as parameter.
	 */
	String APPLE = "apple";
	String ORANGE = "orange";
	String MANGO = "mango";
	String GRAPE = "grape";

	double APPLE_PRICE = 2.0;
	double ORANGE_PRICE = 1.5;
	double MANGO_PRICE = 1.2;
	double GRAPE_PRICE = 1.0;

	private Register() {

	}

	public String getTotalBill(Map<String, Integer> itemDetails) {

		// Write your code here
		double total = 0.0;
		Set<Entry<String, Integer>> entrySet = itemDetails.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			if (APPLE.equals(key)) {
				total = total + (value * APPLE_PRICE);
			} else if (ORANGE.equals(key)) {
				total = total + (value * ORANGE_PRICE);
			} else if (MANGO.equals(key)) {
				total = total + (value * MANGO_PRICE);
			} else if (GRAPE.equals(key)) {
				total = total + (value * GRAPE_PRICE);
			}
		}
		return String.valueOf(total);

	}

	public static Register getInstance() {
		if (register == null) { // 1st NULL check
			synchronized (Register.class) {
				// singleton logic
				if (register == null) // 2nd NULL check
					register = new Register();
			}
		}
		return register;
	} //

	public static void main(String[] args) {
		Register regObj = Register.getInstance();

		Map<String, Integer> map = new HashMap<>();
//		 map.put("orange", 10);
//		 map.put("grape", 52);
//		 map.put("apple", 14);

		map.put("orange", 10);
		map.put("mango", 20);
		map.put("apple", 30);
		System.out.println(regObj.getTotalBill(map));
	}
	
	//To  Stop Cloning
		@Override
		public  Object clone()throws CloneNotSupportedException  {
			throw new CloneNotSupportedException("Cloning not allowed in Singleton Printer classs");
			//return InnerPrinter.INSTANCE;
		}
		
		//To Stop DeSerialization
		private static  final long serialVersionUID=5354353L;
		public  Object readResolve() {
			//return InnerPrinter.INSTANCE;
//			return  register;
			throw  new  IllegalArgumentException("Derailziation is not allowed on singleton class");
		}
		

}
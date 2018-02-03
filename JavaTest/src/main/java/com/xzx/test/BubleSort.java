package com.xzx.test;

public class BubleSort {

	public static <T extends Comparable<? super T>> void bubleSort(T[] arr) {
		T temp = null;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = { 2, 5, 7, 1, 4, 0, 8, 3, 5, 3, 7 };
		System.out.println("Before Sort:");
		for (Integer i : intArr) {
			System.out.print(i + "\t");
		}
		BubleSort.bubleSort(intArr);
		System.out.println("\nAfter Sort:");
		for (Integer i : intArr) {
			System.out.print(i + "\t");
		}
	}
}

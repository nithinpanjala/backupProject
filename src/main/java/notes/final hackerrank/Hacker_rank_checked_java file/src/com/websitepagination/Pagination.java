package com.websitepagination;

import java.util.Arrays;
import java.util.Scanner;

public class Pagination {

	public static String[] fetchItemsToDisplay(String[][] itemsArray, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {
		String[] tempArray = null;
		if ((itemsArray.length) % itemsPerPage != 0) {
			int itemsInLastPage = (itemsArray.length) % itemsPerPage;
			tempArray = new String[itemsInLastPage];
		} else {
			tempArray = new String[itemsPerPage];
		}

		if (sortParameter > 0) {

			if (sortOrder == 0) {
				Arrays.sort(itemsArray, (a, b) -> Integer.compare(Integer.parseInt(a[sortParameter]),
						Integer.parseInt(b[sortParameter])));
			} else {
				Arrays.sort(itemsArray, (a, b) -> Integer.compare(Integer.parseInt(b[sortParameter]),
						Integer.parseInt(a[sortParameter])));
			}
			/*
			Arrays.sort(itemsArray, new Comparator<String[]>() {

				@Override
				public int compare(String[] a, String[] b) {
					if (sortOrder == 0) {
						return Integer.compare(Integer.parseInt(a[sortParameter]), Integer.parseInt(b[sortParameter]));
					}else{
						return Integer.compare(Integer.parseInt(b[sortParameter]), Integer.parseInt(a[sortParameter]));
					}
				}
			});
		*/
		} else {

			if (sortOrder == 0) {
				Arrays.sort(itemsArray, (a, b) -> a[sortParameter].compareTo(b[sortParameter]));
			} else {
				Arrays.sort(itemsArray, (a, b) -> b[sortParameter].compareTo(a[sortParameter]));
			}

		}
		int i = 0;
		for (String[] strings : itemsArray) {
			if (i == 2) {
				break;
			}
			tempArray[i] = itemsArray[(itemsPerPage * pageNumber) + i][0];
			i++;
		}

		/*
		 * for (int i = 0; i < itemsPerPage; i++) { tempArray[i] =
		 * sortedItemsArray[(itemsPerPage * pageNumber) + i][0]; }
		 */

		return tempArray;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of items");
		int numOfItems = scanner.nextInt();
		scanner.nextLine();

		String[][] itemsArray = new String[numOfItems][3];

		for (int i = 0; i < numOfItems; i++) {

			System.out.println("Enter Item" + (i + 1) + " Details");
			String[] item = scanner.nextLine().split(" ");

			itemsArray[i][0] = item[0];
			itemsArray[i][1] = item[1];
			itemsArray[i][2] = item[2];

		}

		System.out.println("Enter index position of the column of the item to sort on");
		int sortParameter = scanner.nextInt();

		System.out.println("Enter sort order");
		int sortOrder = scanner.nextInt();

		System.out.println("Enter items per page");
		int itemsPerPage = scanner.nextInt();

		System.out.println("Enter page number which starts from '0'");
		int pageNumber = scanner.nextInt();

		String[] pageItems = null;
		try {
			pageItems = fetchItemsToDisplay(itemsArray, sortParameter, sortOrder, itemsPerPage, pageNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (String string : pageItems) {
			System.out.println(string);
		}

		scanner.close();
	}

}

package WebsitePagination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Solution {

	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
			int itemsPerPage, int pageNumber) {
		// Write your code here
		List<Item> itemList = new ArrayList<>();
		items.stream().forEach(p -> itemList.add(new Item(p.get(sortParameter))));
		Collections.sort(itemList, sortOrder == 0 ? new itemsAscCompartor() : new itemsDescCompartor());

		List<String> finalList = new ArrayList<>();
		for (int i = itemsPerPage * pageNumber; i < Math.min(itemsPerPage * pageNumber + itemsPerPage,
				items.size()); i++) {
			finalList.add(itemList.get(i).getItemValue());
		}

		List<String> returnList = new ArrayList<>();

		for (String var : finalList) {
			items.stream().forEach(p -> {
				if (p.get(sortParameter).equals(var)) {
					returnList.add(p.get(0));
				}
			});
		}

		return returnList;
	}

	static class itemsAscCompartor implements Comparator<Item> {

		public int compare(Item i1, Item i2) {

			/*
			 * using isNumeric method to verify if itemVlaue is numeric or not. Validating
			 * i1 as we are sorting Ascending, in case of i2 is non numeric it will be
			 * considered as low
			 */

			if (org.apache.commons.lang3.StringUtils.isNumeric(i1.getItemValue())) {
				/*
				 * As we validated i1 -> itemVlaue this always return number which will be used
				 * for sorting.
				 */
				return Integer.parseInt(i1.getItemValue()) - Integer.parseInt(i2.getItemValue());
			}
			return i1.getItemValue().compareTo(i2.getItemValue());
		}
	}

	static class itemsDescCompartor implements Comparator<Item> {
		public int compare(Item i1, Item i2) {
			// using isNumeric method to verify if itemVlaue is numeric or not

			if (org.apache.commons.lang3.StringUtils.isNumeric(i2.getItemValue())) {
				// As we validated i2 -> itemVlaue this always return number which will be used
				// for sorting.
				return Integer.parseInt(i2.getItemValue()) - Integer.parseInt(i1.getItemValue());
			}
			return i2.getItemValue().compareTo(i1.getItemValue());
		}
	}

	static class Item {
		private String value;

		public Item(String itemValue) {
			value = itemValue;
		}

		public String getItemValue() {
			return value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();

		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

}

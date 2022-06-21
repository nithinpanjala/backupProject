package AccountComparison;

public class Solution {

	public static class Account implements OnlineAccount, Comparable<Account> {
		private int noOfRegularMovies;
		private int noOfExclusiveMovies;
		private String ownerName;

		/*
		 * Account parameterized constructor with OwnerName noOfRegularMovies
		 * noOfExclusiveMovies
		 */
		public Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
			this.ownerName = ownerName;
			this.noOfRegularMovies = noOfRegularMovies;
			this.noOfExclusiveMovies = noOfExclusiveMovies;
		}

		/*
		 * monthlyCost method returns the monthly cost for the account.
		 */
		public int monthlyCost() {
			return BASEPRICE + (noOfRegularMovies * REGULARMOVIEPRICE) + (noOfExclusiveMovies * EXCLUSIVEMOVIEPRICE);
		}

		/*
		 * compareTo method of the Comparable interface is overrided. such that two
		 * accounts can be compared based on their monthly cost.
		 */

		@Override
		public int compareTo(Account account) {
			return this.monthlyCost() > account.monthlyCost() ? 1 : -1;
		}

		// 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
		public String toString() {
			return "Owner is " + this.ownerName + " and " + "monthly cost is " + this.monthlyCost() + " USD.";
		}
	}

}

package leetcode;

public class EnumTest {

	enum CoffeeSize {
		BIG(8),
		HUGE(10),
		OVERWHELMING(16){
			public String getLidCode(){
				return "A";
			}
		};

		private int ounces;
		CoffeeSize(int ounces){
			this.ounces = ounces;
		}

		public int getOunces(){
			return ounces;
		}

		public String getLidCode(){
			return "B";
		}
	}

}

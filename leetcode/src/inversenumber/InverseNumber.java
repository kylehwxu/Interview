package inversenumber;

public class InverseNumber {
	public static int inverse(int number) {
		int inversenumber = 0;
		int result = 0;
		int newresult = 0;
		while(number != 0) {
			inversenumber = number % 10;
			newresult = result * 10 + inversenumber;
			if ((newresult - inversenumber)/10 != result) {
				return 0;
			}
			result = newresult;
			number = number/10;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(inverse(123));
	}

}

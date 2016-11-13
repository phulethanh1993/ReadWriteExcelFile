package net.luvina.baitapbuoi1;
/**
 * 
 * @author Lê Thanh Phú
 *
 */
public class PrimeNumber {
    /**
     * Phương thức main, in ra 15 số nguyên tố đầu tiên.
     * 
     * @param args
     *            Tham số đầu vào phương thức main.
     */
    public static void main(String[] args) {
	int count = 0;
	int integer = 0;

	System.out.println("15 số nguyên tố đầu tiên:");

	while (count < 15) {
	    if (isPrimeNumber(integer)) {
		System.out.print(+integer + " ");
		count++;
	    }
	    integer++;
	}

    }

    /**
     * Phương thức kiểm tra 1 số nguyên có phải số nguyên tố hay không.
     * 
     * @param input
     *            Số nguyên cần kiểm tra.
     * @return true nếu số nguyên truyền vào là số nguyên tố, ngược lại trả về
     *         false.
     */
    public static boolean isPrimeNumber(int input) {
	boolean result = true;
	if (input <= 1) {
	    result = false;
	} else {
	    int checkThreshold = (int) (Math.sqrt(input));
	    for (int i = 2; i <= checkThreshold; i++) {
		if ((input % i) == 0) {
		    result = false;
		    break;
		}
	    }
	}
	return result;
    }
}

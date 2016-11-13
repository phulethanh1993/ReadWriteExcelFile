package net.luvina.baitapbuoi1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 
 * @author Lê Thanh Phú
 *
 */
public class LongestIncreasingSubsequence {
    /**
     * Phương thức main cho phép nhập vào chiều dài của một dãy số nguyên, tạo
     * ngẫu nhiên giá trị cho các phần tử, tìm kiếm và in ra một dãy con đơn
     * điệu tăng dài nhất.
     * 
     * @param args
     *            Tham số đầu vào của phương thức main.
     * @throws Exception
     *             Ngoại lệ có thể xảy ra khi người dùng nhập sai kiểu số
     *             nguyên.
     */
    public static void main(String[] args) throws Exception {
	Random random = new Random();
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		System.in));
	int[] result;
	System.out.println("Hãy nhập vào độ dài dãy số:");
	String temp = reader.readLine();
	int sequenceLength = Integer.parseInt(temp);

	int[] arrayNumber = new int[sequenceLength];

	System.out.println("Dãy số ngẫu nhiên:");
	for (int i = 0; i < arrayNumber.length; i++) {
	    arrayNumber[i] = random.nextInt(sequenceLength);
	    System.out.print(arrayNumber[i] + " ");
	}

	System.out.println("\nDãy con dài nhất tìm được:");
	// int[] inputTest = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7,
	// 15 };
	result = findLIS(arrayNumber);
	for (int i = 0; i < result.length; i++) {
	    System.out.print(arrayNumber[result[i]] + " ");
	}
	System.out.println("\nChiều dài dãy con dài nhất: " + result.length);

    }

    /**
     * <p>
     * Phương thức tìm kiếm dãy con đơn điệu tăng dài nhất trong một mảng các số
     * nguyên đầu vào.
     * </p>
     * 
     * Trong phương thức này: <br />
     * Dãy con là dãy có được khi loại bỏ 0 hoặc nhiều phần tử của dãy cha và
     * giữ nguyên thứ tự phần còn lại.(Dãy con có số phần tử nhỏ nhất = 1) <br />
     * 
     * Dãy con đơn điệu tăng là dãy con có phần tử sau lớn hơn phần tử trước nó. <br />
     * 
     * <b>Note:</b> Phương thức chỉ tìm được một dãy con dài nhất, không phải
     * tất cả.
     * 
     * @param arrayInput
     *            Dãy số đầu vào dưới dạng mảng số nguyên.
     * @return <b>Mảng số nguyên</b> chứa vị trí của các phần tử trong dãy con
     *         dài nhất.<br />
     *         <b>null</b> nếu dãy số có chiều dài bằng 0 hoặc null.<br />
     * 
     */
    public static int[] findLIS(int[] arrayInput) {
	int arrayLength = arrayInput.length;
	int[] arrayCount = new int[arrayLength];
	int[] trace = new int[arrayLength];
	int[] result = null;
	if (arrayLength == 0 || arrayInput == null) {
	    return result;
	}

	for (int i = 0; i < arrayLength; i++) {
	    arrayCount[i] = 1;
	    trace[i] = -1;
	}

	// Tìm dãy con dài nhất và vị trí của các phần từ trong dãy con đó.
	for (int i = 1; i < arrayLength; i++) {
	    for (int j = 0; j < i; j++) {
		if ((arrayInput[i] > arrayInput[j])
			&& (arrayCount[j] + 1 > arrayCount[i])) {
		    arrayCount[i] = arrayCount[j] + 1;
		    trace[i] = j;
		}
	    }
	}

	// Tìm vị trí chứa phần tử cuối cùng của dãy con dài nhất.
	int maxIndex = 0;
	for (int i = 0; i < arrayLength; i++) {
	    if (arrayCount[i] > arrayCount[maxIndex]) {
		maxIndex = i;
	    }
	}

	// Tìm lại vị trí dãy con từ mảng trace.
	result = new int[arrayCount[maxIndex]];
	int index = maxIndex;
	int temp = arrayCount[maxIndex];
	while (index != -1) {
	    result[temp - 1] = index;
	    index = trace[index];
	    // System.out.print(result[temp - 1] + " ");
	    temp--;
	}

	return result;
    }

}

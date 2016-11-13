package net.luvina.baitapbuoi1;

import java.util.Random;

/**
 * Class mô phỏng lại thuật toán sắp xếp chèn dựa trên việc sắp xếp các số
 * nguyên.
 * 
 * @author Lê Thanh Phú
 *
 */
public class InsertionSort {
    /**
     * Phương thức main khởi tạo 2 mảng và gán giá trị cho từng phần tử, sau đó
     * sắp xếp lại các phần tử trong mảng.
     * 
     * @param args
     *            Tham số đầu vào của phương thức main.
     */
    public static void main(String[] args) {
	Random random = new Random();
	int[] array = new int[10];
	int length = array.length;

	System.out.println("Mảng trước khi sắp xếp: ");
	for (int i = 0; i < length; i++) {
	    array[i] = random.nextInt(15);
	    System.out.print(+array[i] + " ");
	}
	System.out.println("\nMảng sau khi sắp xếp: ");
	insertionSort(array);
	for (int i = 0; i < array.length; i++) {
	    System.out.print(+array[i] + " ");
	}

    }

    /**
     * Phương thức sắp xếp 1 mảng số nguyên theo thứ tự tăng dần, sử dụng thuật
     * toán sắp xếp chèn (Insertion Sort).
     * 
     * @param arrayInput
     *            Mảng số nguyên cần sắp xếp.
     * @return Mảng số nguyên sau khi sắp xếp.
     */
    public static int[] insertionSort(int[] arrayInput) {
	int i, j, temp;
	int length = arrayInput.length;
	for (i = 1; i < length; i++) {
	    temp = arrayInput[i];
	    for (j = i - 1; (j >= 0) && (arrayInput[j] > temp); j--) {
		arrayInput[j + 1] = arrayInput[j];
	    }
	    arrayInput[j + 1] = temp;
	}
	return arrayInput;
    }
}

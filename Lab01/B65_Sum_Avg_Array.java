import java.util.Scanner;

public class B65_Sum_Avg_Array {
	public static void sort_asc(Double[] a1, int n) {
		double temp;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(a1[i] > a1[j]) {
					temp = a1[i];
					a1[i] = a1[j];
					a1[j] = temp;
				}
			}
		}
	}
	public static double sum(Double A[], int n) {
		double sum = 0;
		for(int i = 0; i < n; i++) {
			sum += A[i];
		}
		return sum;
	}
	public static double average(Double A[], int n) {
		if(n==0) return 0;
		else return sum(A,n)/n;
	}
	public static void print(Double A[], int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(A[i] + " ");
		}
	}
	public static void main(String[] args) {
		Double A1[] = {2.4, 9.8, 5.2, 9.8, 3.0};
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Double A2[] = new Double[n];
		for(int i = 0; i < n; i++) {
			A2[i] = sc.nextDouble();
		}
		sort_asc(A1, 5);
		System.out.println("Sap xep mang A1 tang dan: ");
		print(A1, 5);
		System.out.println("Tong phan tu mang A1: " + sum(A1,5));
		System.out.println("Trung binh phan tu mang A1: " + average(A1,5));
		
		sort_asc(A2, n);
		System.out.println("Sap xep mang A2 tang dan: ");
		print(A2, n);
		System.out.println("Tong phan tu mang A2: " + sum(A2,n));
		System.out.println("Trung binh phan tu mang A1: " + average(A2,n));
	}
}

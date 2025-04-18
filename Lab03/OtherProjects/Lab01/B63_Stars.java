import java.util.Scanner;

public class B63_Stars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for(int k = i; k <= n-1; k++) {
				System.out.print(" ");
			}
			for(int h = 1; h <= 2*i - 1; h++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		sc.close();
	}
}

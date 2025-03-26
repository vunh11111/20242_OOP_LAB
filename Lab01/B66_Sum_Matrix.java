import java.util.Scanner;

public class B66_Sum_Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so hang: ");
        int hang = sc.nextInt();
        System.out.print("Nhap so cot: ");
        int cot = sc.nextInt();

        int[][] maTran1 = new int[hang][cot];
        int[][] maTran2 = new int[hang][cot];
        int[][] tongMaTran = new int[hang][cot];

        System.out.println("Nhap ma tran thu nhat:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                maTran1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Nhap ma tran thu hai:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                maTran2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                tongMaTran[i][j] = maTran1[i][j] + maTran2[i][j];
            }
        }

        System.out.println("Tong hai ma tran:");
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                System.out.print(tongMaTran[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

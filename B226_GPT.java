import javax.swing.JOptionPane;

public class B226_GPT {
    public static void main(String[] args) {
        String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
        String str = "";
        String choice;
        String strNotification = "Result finding roots of your equation: ";

        try {
            choice = JOptionPane.showInputDialog(null, "Please input your choice: \n 1. Linear equation \n 2. Linear system with 2 variables \n 3. Second-degree equation", "Input choice", JOptionPane.INFORMATION_MESSAGE);
            Double ch = Double.parseDouble(choice);

            if (ch == 1.0) { // Giải phương trình bậc nhất: ax + b = 0
                strNum1 = JOptionPane.showInputDialog(null, "Please input a:", "Input a", JOptionPane.INFORMATION_MESSAGE);
                strNum2 = JOptionPane.showInputDialog(null, "Please input b:", "Input b", JOptionPane.INFORMATION_MESSAGE);

                double a = Double.parseDouble(strNum1);
                double b = Double.parseDouble(strNum2);

                str = "Your equation is: " + a + "x + " + b + " = 0";

                if (a == 0) {
                    strNotification += (b == 0) ? " Infinity" : " No solution";
                } else {
                    strNotification += " x = " + (-b / a);
                }
            } else if (ch == 2.0) { // Giải hệ phương trình bậc nhất hai ẩn
                strNum1 = JOptionPane.showInputDialog(null, "Please input a11:", "Input a11", JOptionPane.INFORMATION_MESSAGE);
                strNum2 = JOptionPane.showInputDialog(null, "Please input a12:", "Input a12", JOptionPane.INFORMATION_MESSAGE);
                strNum3 = JOptionPane.showInputDialog(null, "Please input b1:", "Input b1", JOptionPane.INFORMATION_MESSAGE);
                strNum4 = JOptionPane.showInputDialog(null, "Please input a21:", "Input a21", JOptionPane.INFORMATION_MESSAGE);
                strNum5 = JOptionPane.showInputDialog(null, "Please input a22:", "Input a22", JOptionPane.INFORMATION_MESSAGE);
                strNum6 = JOptionPane.showInputDialog(null, "Please input b2:", "Input b2", JOptionPane.INFORMATION_MESSAGE);

                double a11 = Double.parseDouble(strNum1);
                double a12 = Double.parseDouble(strNum2);
                double b1 = Double.parseDouble(strNum3);
                double a21 = Double.parseDouble(strNum4);
                double a22 = Double.parseDouble(strNum5);
                double b2 = Double.parseDouble(strNum6);

                str = "Your system is: " +
                      a11 + "x + " + a12 + "y = " + b1 + " and " +
                      a21 + "x + " + a22 + "y = " + b2;

                double delta = a11 * a22 - a12 * a21;
                double deltaX = b1 * a22 - b2 * a12;
                double deltaY = a11 * b2 - a21 * b1;

                if (delta != 0) {
                    double x = deltaX / delta;
                    double y = deltaY / delta;
                    strNotification += " x = " + x + ", y = " + y;
                } else {
                    if (deltaX == 0 && deltaY == 0) {
                        strNotification += " Infinity (infinitely many solutions)";
                    } else {
                        strNotification += " No solution";
                    }
                }
            } else if (ch == 3.0) { // Giải phương trình bậc hai: ax^2 + bx + c = 0
                strNum1 = JOptionPane.showInputDialog(null, "Please input a:", "Input a", JOptionPane.INFORMATION_MESSAGE);
                strNum2 = JOptionPane.showInputDialog(null, "Please input b:", "Input b", JOptionPane.INFORMATION_MESSAGE);
                strNum3 = JOptionPane.showInputDialog(null, "Please input c:", "Input c", JOptionPane.INFORMATION_MESSAGE);

                double a = Double.parseDouble(strNum1);
                double b = Double.parseDouble(strNum2);
                double c = Double.parseDouble(strNum3);

                str = "Your equation is: " + a + "x² + " + b + "x + " + c + " = 0";

                if (a == 0) { // Nếu a = 0 thì quay lại phương trình bậc nhất
                    if (b == 0) {
                        strNotification += (c == 0) ? " Infinity" : " No solution";
                    } else {
                        strNotification += " x = " + (-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        strNotification += " x1 = " + x1 + ", x2 = " + x2;
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        strNotification += " x = " + x;
                    } else {
                        strNotification += " No real solution";
                    }
                }
            } else {
                strNotification = "Invalid choice!";
            }
        } catch (NumberFormatException e) {
            strNotification = "Invalid input! Please enter numerical values.";
        } catch (Exception e) {
            strNotification = "An error occurred: " + e.getMessage();
        }

        JOptionPane.showMessageDialog(null, strNotification, str, JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}

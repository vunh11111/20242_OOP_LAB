import javax.swing.JOptionPane;

public class B225_Double {
    public static void main(String[] args) {
        String strNum1, strNum2;

        String strNotification1 = "Sum: ";
        String strNotification2 = "Difference: ";
        String strNotification3 = "Product: ";
        String strNotification4 = "Quotient: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number:", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        if (strNum1 == null || strNum1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input for the first number.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number:", "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        if (strNum2 == null || strNum2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input for the second number.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            strNotification1 += (num1 + num2);
            strNotification2 += (num1 - num2);
            strNotification3 += (num1 * num2);

            if (num2 != 0) strNotification4 += (num1 / num2);
            else strNotification4 = "ERROR! Can't divide 0 !!";

            JOptionPane.showMessageDialog(null, strNotification1, "Result", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, strNotification2, "Result", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, strNotification3, "Result", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, strNotification4, "Result", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }
}

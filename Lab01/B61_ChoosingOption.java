import javax.swing.JOptionPane;
public class B61_ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
	//Neu chon Cancel, chuong trinh se hien "You've chosen: No"
	//Chuong trinh chi co 2 option Yes hoac No
//	import javax.swing.JOptionPane;
//
//	public class ChoosingOption {
//	    public static void main(String[] args) {
//	        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first-class ticket?", 
//	                                                   "Ticket Confirmation", JOptionPane.YES_NO_OPTION);
//	        
//	        if (option == JOptionPane.YES_OPTION) {
//	            JOptionPane.showMessageDialog(null, "You've chosen: Yes");
//	        } else {
//	            JOptionPane.showMessageDialog(null, "You've chosen: No");
//	        }
//
//	        System.exit(0);
//	    }
//	}

}

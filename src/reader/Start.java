package reader;

import java.time.format.DateTimeFormatter;

//import javax.swing.SwingUtilities;
//import Daemon;

public class Start {
	
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	
	public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
		//Daemon daemon = new Daemon(5000);
		//daemon.run();
/*		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
*/
		
/////////////////////////////
//////// TESTABFRAGE ////////
/////////////////////////////
		
//		Screenbot screenbot = new Screenbot();screenbot.solveCode(false);
	
	}
	
    public static void log(String input) {
    	System.out.print(java.time.LocalTime.now().format(dtf)+" - ");
		System.out.println(input);
    }

    public static void err(String input) {
    	System.out.print(java.time.LocalTime.now().format(dtf)+" - ");
		System.err.println(input);
    }

}

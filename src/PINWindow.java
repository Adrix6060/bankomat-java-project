import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PINWindow extends JFrame {
    private JPanel panel1;
    private JTextField PINfield;
    private JButton potwierdzButton;
    private JButton closeButton;
    private JLabel resultLabel;

    public PINWindow() {
        super("PIN Enter Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setSize(600,400);

        potwierdzButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.PIN = PINfield.getText();

                int i=0, index=0;
                for(i=0;i<Main.kody.length;i++) {
                    if (Main.karta.equals(Main.kody[i][0])) {
                        index=i;
                        break;
                    }
                }

                if(Main.PIN.equals(Main.kody[index][1])) {
                    resultLabel.setText("");
                    dispose();
                    MenuWindow.main();
                }
                else resultLabel.setText("Wprowadziłeś zły PIN.");
            }
        });


        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main() {
        PINWindow window = new PINWindow();
        window.setVisible(true);
    }

}

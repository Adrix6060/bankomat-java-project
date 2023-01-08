import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceWindow extends JFrame {

    private JPanel panel;
    private JButton closeButton;
    private JButton backButton;
    private JLabel valueLabel;

    public BalanceWindow() {
        super("Acount Balance Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(600,400);

        int i=0, index=0;
        for(i=0;i<Main.kody.length;i++) {
            if (Main.karta.equals(Main.kody[i][0])) {
                index=i;
                break;
            }
        }

        valueLabel.setText(String.format("%.2f", Main.stanyKonta[index]) + " zł");

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                MenuWindow.main();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main() {
        BalanceWindow frame = new BalanceWindow();
        frame.setVisible(true);
    }
}

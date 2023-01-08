import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    private JPanel panel2;
    private JButton closeButton;
    private JButton wplataButton;
    private JButton wyplataButton;
    private JButton stanButton;
    private JButton historiaButton;

    public MenuWindow() {
        super("Menu Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel2);
        this.setSize(600,400);

        stanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                BalanceWindow.main();
            }
        });

        wyplataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaycheckWindow.main();
            }
        });

        wplataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaymentWindow.main();
            }
        });

        historiaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                HistoryWindow.main();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main() {
        MenuWindow frame = new MenuWindow();
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardEnterWindow extends JFrame{
    private JPanel panel;
    private JComboBox comboBox1;
    private JButton wlozKarteButton;
    private JButton zamknijButton;

    public CardEnterWindow() {
        super("Card Enter Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(600,400);

        wlozKarteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.karta = comboBox1.getSelectedItem().toString();
                dispose();
                PINWindow.main();
            }
        });

        zamknijButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main() {
        CardEnterWindow window = new CardEnterWindow();
        window.setVisible(true);
    }
}

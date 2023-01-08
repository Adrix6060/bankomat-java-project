import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryWindow extends JFrame {

    private JPanel panel;
    private JButton closeButton;
    private JButton backButton;
    private JTable historia;
    private JLabel valueLabel;

    public HistoryWindow() {
        super("Paycheck Window");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel);
        this.setSize(600,400);

        int iloscWierszy = Main.wierszeHistoriiTransakcji.size();
        String[][] wiersze = new String[iloscWierszy][5];
        for (int i=0;i<iloscWierszy;i++) {
            wiersze[i][0] = Main.wierszeHistoriiTransakcji.get(i)[0];
            wiersze[i][1] = Main.wierszeHistoriiTransakcji.get(i)[1];
            wiersze[i][2] = Main.wierszeHistoriiTransakcji.get(i)[2];
            wiersze[i][3] = Main.wierszeHistoriiTransakcji.get(i)[3];
            wiersze[i][4] = Main.wierszeHistoriiTransakcji.get(i)[4];
        }


        DefaultTableModel model = new DefaultTableModel(wiersze, Main.kolumnyHistoriiTransakcji);
        historia.setModel(model);

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
        HistoryWindow frame = new HistoryWindow();
        frame.setVisible(true);
    }
}

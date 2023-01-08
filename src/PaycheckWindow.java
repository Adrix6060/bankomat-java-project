import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class PaycheckWindow extends JFrame{
    private JPanel panel;
    private JButton closeButton;
    private JButton backButton;
    private JButton wplacButton;
    private JLabel resultLabel;
    private JTextField moneyField;
    private JLabel valueLabel;

    public PaycheckWindow() {
        super("Paycheck Window");
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

        valueLabel.setText("Saldo: " + String.format("%.2f", Main.stanyKonta[index]) + " zł");

        int finalIndex = index;
        wplacButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pole = moneyField.getText();

                int wyplata;
                if (!pole.equals("")) wyplata = Integer.parseInt(pole);
                else wyplata = -1;

                if (wyplata<=0) resultLabel.setText("Wprowadź poprawną kwotę.");
                else if (wyplata%10!=0) resultLabel.setText("W bankomacie nie można wypłacać monet.");
                else if (wyplata > Main.stanyKonta[finalIndex]) resultLabel.setText("Nie masz tyle na koncie.");
                else {
                    Main.stanyKonta[finalIndex] -= wyplata;
                    valueLabel.setText("Saldo: " + String.format("%.2f", Main.stanyKonta[finalIndex]) + " zł");
                    resultLabel.setText("Wypłata dokonana pomyślnie.");
                    moneyField.setText("");

                    String[] wiersz = new String[5];
                    wiersz[0] = Main.licznikTransakcji + ".";
                    Main.licznikTransakcji++;
                    wiersz[1] = Main.kody[finalIndex][0];
                    wiersz[2] = "Wypłata";
                    wiersz[3] = wyplata + ".00";

                    LocalDateTime data = LocalDateTime.now();
                    String dataDoTablicy = data.getDayOfMonth() + "." + data.getMonthValue() + "." + data.getYear() + " " + data.getHour() + ":" + data.getMinute() + ":" + data.getSecond();

                    wiersz[4] = dataDoTablicy;

                    Main.wierszeHistoriiTransakcji.add(wiersz);
                }
            }
        });



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
        PaycheckWindow frame = new PaycheckWindow();
        frame.setVisible(true);
    }
}

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Testeaza extends JFrame implements ActionListener {

    private JTextArea ta;

    public static void main(String[] args) {
        Testeaza tst = new Testeaza();
        tst.initComponents();
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        ta = new JTextArea(50, 50);
        JScrollPane sp = new JScrollPane(ta);

        this.add(sp);

        JButton butTest = new JButton("Test");
        butTest.addActionListener(this);
        this.add(butTest);

        JButton butTestKml = new JButton("TestKML");
        butTestKml.addActionListener(this);
        this.add(butTestKml);

        JButton butIesire = new JButton("Iesire");
        butIesire.addActionListener(this);
        this.add(butIesire);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Test tst = new Test();
        switch (ae.getActionCommand()) {
            case "Test":
                //JOptionPane.showMessageDialog(this, tst.testeaza());
                ta.setText(tst.testeaza());
                break;
            case "TestKML":
                //JOptionPane.showMessageDialog(this, tst.testeaza());
                ta.setText(tst.testKml());
                break;
            case "Iesire":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Comandfa necunoscuta:" + ae.getActionCommand());
                break;

        }
    }
}

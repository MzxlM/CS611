import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
/**
*@ClassName:MonitorWindow
*@Description:MonitorWindow File contains MonitorWindow class and form.
 * It prompts detailed information of Daily report/account/loans
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class MonitorWindow extends JFrame implements Window {
    private JPanel MonitorWindow;
    private JLabel ruleLabel;
    private JScrollPane managerMonitor;
    private JPanel monitorPanel;
    private JButton addStock;
    private ATM atmsystem;
    private int type;

    public MonitorWindow(ManagerWindow managerWindow, ATM atm, int monitorType) {
        WindowSetter.windowConfig2(this, MonitorWindow);
        this.atmsystem = atm;
        this.type = monitorType;

        if (monitorType == 1) {
            ruleLabel.setText("Next is the daily report: ");
        } else if (monitorType == 2) {
            ruleLabel.setText("Next follows the list of all customers' accounts");
        } else if (monitorType == 3) {
            ruleLabel.setText("Next follows the list of all loans");
        } else if (monitorType == 4) {
            ruleLabel.setText("Next follows the List of all stocks");
        }
        addStock.setVisible(false);
        reFresh();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                managerWindow.setVisible(true);
            }
        });

        addStock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new AddStockDialog(atmsystem);
                reFresh();
            }
        });
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MonitorWindow = new JPanel();
        MonitorWindow.setLayout(new GridLayoutManager(2, 1, new Insets(20, 20, 20, 20), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        MonitorWindow.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ruleLabel = new JLabel();
        ruleLabel.setText("Label");
        panel1.add(ruleLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        addStock = new JButton();
        addStock.setText("Add Stock");
        panel1.add(addStock, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        managerMonitor = new JScrollPane();
        MonitorWindow.add(managerMonitor, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        monitorPanel = new JPanel();
        monitorPanel.setLayout(new GridLayoutManager(1, 1, new Insets(20, 20, 20, 20), -1, -1));
        managerMonitor.setViewportView(monitorPanel);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MonitorWindow;
    }

    @Override
    public void reFresh() {
        monitorPanel.setLayout(new BoxLayout(monitorPanel, BoxLayout.Y_AXIS));
        monitorPanel.removeAll();
        if (type == 1) {
            List<Transaction> ts = ((Manager) atmsystem.getUser()).getAllTransactions();
            for (Transaction t : ts) {
                TransactionElement e = new TransactionElement(atmsystem, t);
                monitorPanel.add(e.$$$getRootComponent$$$());
            }
        } else if (type == 2) {
            List<BankAccount> bs = ((Manager) atmsystem.getUser()).getAllAccounts();
            for (BankAccount b : bs) {
                AccountElement e = new AccountElement(atmsystem, b, this);
                monitorPanel.add(e.$$$getRootComponent$$$());
            }
        } else if (type == 3) {
            List<Loan> ls = ((Manager) atmsystem.getUser()).getAllLoans();
            for (Loan l : ls) {
                LoanElement e = new LoanElement(atmsystem, l, this);
                monitorPanel.add(e.$$$getRootComponent$$$());
            }
        } else {
            addStock.setVisible(true);
            List<Stock> ss = atmsystem.getAllStocks();
            for (Stock s : ss) {
                StockElement e = new StockElement(atmsystem, s, "Manager", this);
                monitorPanel.add(e.$$$getRootComponent$$$());
            }
        }
        monitorPanel.revalidate();
        monitorPanel.repaint();
    }
}

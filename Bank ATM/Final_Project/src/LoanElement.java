import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
*@ClassName:LoanElement
*@Description:LoanElement File contains LoanElement class and form.
 * It prompts a window to direct customers to pay their loan.
 * In the case of a manager, the window prompts the info regarding collateral, currency, amount and userid.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class LoanElement extends JFrame implements Deal {
    private JPanel loanElement;
    private JButton payButton;
    private JLabel collateralLabel;
    private JLabel currencyLabel;
    private JLabel amountLabel;
    private JLabel useridLabel;
    private ATM atmsystem;

    public LoanElement(ATM atm, Loan loan, Window window) {


        this.atmsystem = atm;
        setLabel(loan);
        payButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new PayLoanDialog(atm, loan);
                window.reFresh();
            }
        });
    }

    public void setLabel(Loan loan) {
        if (atmsystem.getUser() instanceof Manager) {
            payButton.setVisible(false);
        }
        collateralLabel.setText(loan.getCollateral());
        currencyLabel.setText((loan.getCurrency().getCode()));
        amountLabel.setText(String.valueOf(loan.getAmount()));
        useridLabel.setText(String.valueOf(loan.getUID()));
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
        loanElement = new JPanel();
        loanElement.setLayout(new GridLayoutManager(2, 6, new Insets(10, 10, 10, 10), -1, -1));
        loanElement.setMaximumSize(new Dimension(2147483647, 90));
        loanElement.setMinimumSize(new Dimension(500, 91));
        loanElement.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setText("Collateral: ");
        loanElement.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Currency: ");
        loanElement.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        collateralLabel = new JLabel();
        collateralLabel.setText("Label");
        loanElement.add(collateralLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        currencyLabel = new JLabel();
        currencyLabel.setText("Label");
        loanElement.add(currencyLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Amount: ");
        loanElement.add(label3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        amountLabel = new JLabel();
        amountLabel.setText("Label");
        loanElement.add(amountLabel, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(38, 16), null, 0, false));
        payButton = new JButton();
        payButton.setText("Pay Loan");
        loanElement.add(payButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        loanElement.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("UserID: ");
        loanElement.add(label4, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        useridLabel = new JLabel();
        useridLabel.setText("Label");
        loanElement.add(useridLabel, new GridConstraints(1, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return loanElement;
    }

    @Override
    public int getUID() {
        return atmsystem.getUser().getUID();
    }
}

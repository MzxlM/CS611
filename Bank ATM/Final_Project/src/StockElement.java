import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
*@ClassName:StockElement
*@Description:StockElement File contains StockElement class and form.
 * It prompts a window for users to see the info of the stocks.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class StockElement extends JFrame implements Deal {
    private JPanel panel1;
    private JPanel stockPanel;
    private JLabel nameLabel;
    private JLabel tickerLabel;
    private JLabel priceLabel;
    private JLabel ownNumberLabel;
    private JButton changePriceButton;
    private JButton buyButton;
    private JButton sellButton;
    private JLabel avgLabel;
    private JLabel AVGLabel;
    private JLabel OWNLabel;
    private JButton deleteButton;
    private ATM atmsystem;
    private String showType;

    public StockElement(ATM atm, Object object, String showType, Window window) {

        this.atmsystem = atm;
        this.showType = showType;
        setLabel(object);

        changePriceButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ChangePriceDialog(atmsystem, (Stock) object);
                window.reFresh();
            }
        });
        buyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new BuySellStockDialog(atm, (Stock) object, null, "Buy");
                window.reFresh();
            }
        });
        sellButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new BuySellStockDialog(atm, null, (StockUserDTO) object, "Sell");
                window.reFresh();
            }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                atmsystem.deleteStock(((Stock) object).getId());
                window.reFresh();
            }
        });
    }

    public void setLabel(Object object) {

        if (!showType.equals("Customer")) {
            Stock s = (Stock) object;
            sellButton.setVisible(false);
            AVGLabel.setVisible(false);
            avgLabel.setVisible(false);
            OWNLabel.setVisible(false);
            ownNumberLabel.setVisible(false);
            nameLabel.setText(s.getName());
            priceLabel.setText(Helper.getRoundTwoDigits(s.getCurrentPrice()));
            tickerLabel.setText(s.getTicker());
            if (showType.equals("Manager")) {
                buyButton.setVisible(false);
            } else if (showType.equals("StockPool")) {
                deleteButton.setVisible(false);
                changePriceButton.setVisible(false);
            }
        } else {
            deleteButton.setVisible(false);
            buyButton.setVisible(false);
            changePriceButton.setVisible(false);
            StockUserDTO dto = (StockUserDTO) object;
            avgLabel.setText(Helper.getRoundTwoDigits(dto.getAvgPrice()));
            ownNumberLabel.setText(String.valueOf(dto.getAmountHold()));
            nameLabel.setText(dto.getStockName());
            priceLabel.setText(String.valueOf(dto.getStockPrice()));
            tickerLabel.setText(dto.getStockTicker());
        }

    }

    @Override
    public int getUID() {
        return atmsystem.getUser().getUID();
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
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(5, 5, 5, 5), -1, -1));
        panel1.setMaximumSize(new Dimension(2147483647, 90));
        panel1.setMinimumSize(new Dimension(500, 100));
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        stockPanel = new JPanel();
        stockPanel.setLayout(new GridLayoutManager(3, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(stockPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Name: ");
        stockPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Ticker: ");
        stockPanel.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nameLabel = new JLabel();
        nameLabel.setText("Label");
        stockPanel.add(nameLabel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tickerLabel = new JLabel();
        tickerLabel.setText("Label");
        stockPanel.add(tickerLabel, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Price: ");
        stockPanel.add(label3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 16), null, 0, false));
        priceLabel = new JLabel();
        priceLabel.setText("Label");
        stockPanel.add(priceLabel, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(136, 16), null, 0, false));
        OWNLabel = new JLabel();
        OWNLabel.setText("Own #: ");
        stockPanel.add(OWNLabel, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(60, 16), null, 0, false));
        ownNumberLabel = new JLabel();
        ownNumberLabel.setText("Label");
        stockPanel.add(ownNumberLabel, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(136, 16), null, 0, false));
        buyButton = new JButton();
        buyButton.setText("Buy");
        stockPanel.add(buyButton, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sellButton = new JButton();
        sellButton.setText("Sell");
        stockPanel.add(sellButton, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        stockPanel.add(spacer1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        AVGLabel = new JLabel();
        AVGLabel.setText("Avg Cost: ");
        stockPanel.add(AVGLabel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        avgLabel = new JLabel();
        avgLabel.setText("Label");
        stockPanel.add(avgLabel, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        changePriceButton = new JButton();
        changePriceButton.setText("Change Price");
        stockPanel.add(changePriceButton, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        stockPanel.add(deleteButton, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}

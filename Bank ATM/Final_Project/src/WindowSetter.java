import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
*@ClassName:WindowSetter
*@Description:A WindowSetter object. It contains helper functions for windows setting.
*@Author:Yuesi Liu, Zhaoyu Yin, Xinlong Zhang
*@Date:12/14/2021
*@Version: Final
*
*/

public class WindowSetter {

    public static void setTimer(JLabel time) {
        final JLabel varTime = time;
        Timer timeAction = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long timemillis = System.currentTimeMillis();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                varTime.setText(df.format(new Date(timemillis)));
            }
        });
        timeAction.start();
    }

    public static void windowConfig1(JFrame frameObject, JPanel panelObejct) {
        frameObject.setContentPane(panelObejct);
        frameObject.setSize(500, 500);
        frameObject.setVisible(true);
        frameObject.setLocationRelativeTo(null);
    }

    public static void windowConfig2(JFrame frameObject, JPanel panelObejct) {
        frameObject.setContentPane(panelObejct);
        frameObject.setSize(700, 700);
        frameObject.setVisible(true);
        frameObject.setLocationRelativeTo(null);
    }


}

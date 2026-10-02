package pharmise;

import pharmise.ui.LoginFrame;
import javax.swing.*;

public class PharmacyApp {
    public static void main(String[] args) {
        // تفعيل مظهر النظام الأساسي لنظام التشغيل ليكون أجمل
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        SwingUtilities.invokeLater(() -> new LoginFrame());
    }
}
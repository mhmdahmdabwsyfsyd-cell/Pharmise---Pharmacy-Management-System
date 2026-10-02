package pharmise.ui;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {
    
    public MainDashboard(String userRole) {
        setTitle("نظام إدارة الصيدلية المتكامل - Pharmacy Pro");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // تنسيق التبويبات
        JTabbedPane tabs = new JTabbedPane();
        tabs.setFont(StyleTheme.FONT_BOLD);
        
        // إضافة الصفحات
        tabs.addTab("نقطة البيع (الكاشير)", new SalesPanel());
        
        if (userRole.equalsIgnoreCase("Admin")) {
            tabs.addTab("إدارة الأدوية والمخزون", new MedicinePanel());
            // يمكن إضافة UserPanel بنفس الطريقة (تم اختصارها للتركيز)
            tabs.addTab("التقارير والنواقص", new AnalysisPanel());
        }

        // إضافة تزييل بسيط
        JPanel footer = new JPanel();
        footer.setBackground(StyleTheme.TEXT_DARK);
        JLabel lblUser = new JLabel("المستخدم الحالي: " + userRole);
        lblUser.setForeground(Color.WHITE);
        footer.add(lblUser);

        add(tabs, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

        setVisible(true);
    }
}
package pharmise.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class StyleTheme {
    // الألوان الحديثة (Flat Colors)
    public static final Color PRIMARY = new Color(41, 128, 185);    // أزرق احترافي
    public static final Color SECONDARY = new Color(52, 152, 219);  // أزرق فاتح
    public static final Color ACCENT = new Color(46, 204, 113);     // أخضر للعمليات الناجحة
    public static final Color DANGER = new Color(231, 76, 60);      // أحمر للحذف
    public static final Color BG_COLOR = new Color(236, 240, 241);  // رمادي فاتح للخلفية
    public static final Color TEXT_DARK = new Color(44, 62, 80);    // كحلي غامق للنصوص

    public static final Font FONT_TITLE = new Font("Segoe UI", Font.BOLD, 18);
    public static final Font FONT_NORMAL = new Font("Segoe UI", Font.PLAIN, 14);
    public static final Font FONT_BOLD = new Font("Segoe UI", Font.BOLD, 14);

    public static void styleButton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(FONT_BOLD);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void styleTable(JTable table) {
        table.setRowHeight(30);
        table.setFont(FONT_NORMAL);
        table.getTableHeader().setFont(FONT_BOLD);
        table.getTableHeader().setBackground(TEXT_DARK);
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(SECONDARY);
        table.setSelectionForeground(Color.WHITE);
        
        // توسيط النصوص في الجدول
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public static void styleField(JTextField txt) {
        txt.setFont(FONT_NORMAL);
        txt.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    }
}
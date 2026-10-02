package pharmise.ui;

import pharmise.DataStore;
import pharmise.model.Medicine;
import pharmise.model.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AnalysisPanel extends JPanel {
    JLabel lblTotal = new JLabel();
    DefaultTableModel model = new DefaultTableModel(new String[]{"الدواء الناقص", "الكمية المتبقية"}, 0);
    JTable table = new JTable(model);
    JButton btnRefresh = new JButton("تحديث التقرير");

    public AnalysisPanel() {
        setLayout(new BorderLayout(20, 20));
        setBackground(StyleTheme.BG_COLOR);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // كارت إجمالي المبيعات
        JPanel pnlCard = new JPanel(new BorderLayout());
        pnlCard.setBackground(Color.WHITE);
        pnlCard.setBorder(BorderFactory.createLineBorder(StyleTheme.SECONDARY, 2, true));
        lblTotal.setFont(new Font("Arial", Font.BOLD, 24));
        lblTotal.setForeground(StyleTheme.TEXT_DARK);
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        pnlCard.add(lblTotal, BorderLayout.CENTER);

        StyleTheme.styleButton(btnRefresh, StyleTheme.PRIMARY);
        pnlCard.add(btnRefresh, BorderLayout.SOUTH);

        add(pnlCard, BorderLayout.NORTH);

        // جدول النواقص
        JPanel pnlTable = new JPanel(new BorderLayout());
        pnlTable.setBorder(BorderFactory.createTitledBorder("تنبيهات النواقص (أقل من 10 قطع)"));
        pnlTable.setBackground(StyleTheme.BG_COLOR);
        
        StyleTheme.styleTable(table);
        pnlTable.add(new JScrollPane(table));
        add(pnlTable, BorderLayout.CENTER);

        btnRefresh.addActionListener(e -> calculate());
        calculate();
    }

    void calculate() {
        // 1. حساب المبيعات
        double totalSales = 0;
        for (Sale s : DataStore.sales) {
            totalSales += s.getTotalPrice();
        }
        lblTotal.setText("إجمالي المبيعات الكلية: " + totalSales + " جنيه");

        // 2. حساب النواقص
        model.setRowCount(0);
        for (Medicine m : DataStore.medicines) {
            if (m.getQuantity() < 10) {
                model.addRow(new Object[]{m.getName(), m.getQuantity()});
            }
        }
    }
}
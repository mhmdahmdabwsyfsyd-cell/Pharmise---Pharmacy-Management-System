package pharmise.ui;

import pharmise.DataStore;
import pharmise.model.Medicine;
import pharmise.model.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalesPanel extends JPanel {
    JTextField tSearch = new JTextField(20);
    JButton btnSearch = new JButton("بحث");
    
    // تفاصيل الدواء المختار
    JLabel lblMedInfo = new JLabel("اختر دواء...");
    JTextField tQtySell = new JTextField("1", 5);
    JButton btnAddToCart = new JButton("بيع / إضافة للفاتورة");
    
    Medicine selectedMedicine = null;

    DefaultTableModel salesModel = new DefaultTableModel(new String[]{"الصنف", "الكمية", "الإجمالي"}, 0);
    JTable salesTable = new JTable(salesModel);

    public SalesPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(StyleTheme.BG_COLOR);
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- الجزء العلوي: البحث ---
        JPanel pnlTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlTop.setBackground(StyleTheme.BG_COLOR);
        pnlTop.add(new JLabel("بحث عن دواء:"));
        StyleTheme.styleField(tSearch);
        StyleTheme.styleButton(btnSearch, StyleTheme.SECONDARY);
        pnlTop.add(tSearch);
        pnlTop.add(btnSearch);

        // --- منطقة العمليات ---
        JPanel pnlAction = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlAction.setBackground(Color.WHITE);
        pnlAction.setBorder(BorderFactory.createTitledBorder("عملية البيع"));
        
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.setBackground(Color.WHITE);
        lblMedInfo.setFont(StyleTheme.FONT_BOLD);
        lblMedInfo.setForeground(StyleTheme.PRIMARY);
        infoPanel.add(lblMedInfo);

        JPanel sellPanel = new JPanel(new FlowLayout());
        sellPanel.setBackground(Color.WHITE);
        sellPanel.add(new JLabel("الكمية المطلوبة:"));
        StyleTheme.styleField(tQtySell);
        sellPanel.add(tQtySell);
        StyleTheme.styleButton(btnAddToCart, StyleTheme.ACCENT);
        sellPanel.add(btnAddToCart);

        pnlAction.add(infoPanel);
        pnlAction.add(sellPanel);

        // --- تجميع الواجهة ---
        JPanel pnlNorth = new JPanel(new BorderLayout());
        pnlNorth.add(pnlTop, BorderLayout.NORTH);
        pnlNorth.add(pnlAction, BorderLayout.CENTER);
        
        add(pnlNorth, BorderLayout.NORTH);
        
        StyleTheme.styleTable(salesTable);
        add(new JScrollPane(salesTable), BorderLayout.CENTER);

        // --- البرمجة ---
        btnSearch.addActionListener(e -> searchMedicine());
        btnAddToCart.addActionListener(e -> performSale());
    }

    private void searchMedicine() {
        String keyword = tSearch.getText().toLowerCase();
        selectedMedicine = null;
        lblMedInfo.setText("غير موجود!");
        lblMedInfo.setForeground(StyleTheme.DANGER);

        for (Medicine m : DataStore.medicines) {
            if (m.getName().toLowerCase().contains(keyword)) {
                selectedMedicine = m;
                lblMedInfo.setText("تم التحديد: " + m.getName() + " | السعر: " + m.getPrice() + " | المخزون: " + m.getQuantity());
                lblMedInfo.setForeground(StyleTheme.PRIMARY);
                break;
            }
        }
    }

    private void performSale() {
        if (selectedMedicine == null) {
            JOptionPane.showMessageDialog(this, "يرجى البحث واختيار دواء أولاً");
            return;
        }

        try {
            int qty = Integer.parseInt(tQtySell.getText());
            if (qty > selectedMedicine.getQuantity()) {
                JOptionPane.showMessageDialog(this, "الكمية المطلوبة أكبر من المخزون!", "تنبيه", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // تحديث المخزون
            selectedMedicine.setQuantity(selectedMedicine.getQuantity() - qty);
            
            // تسجيل البيع
            double total = qty * selectedMedicine.getPrice();
            Sale sale = new Sale(selectedMedicine.getName(), qty, total);
            DataStore.sales.add(sale);
            
            // الحفظ وتحديث الجدول
            DataStore.saveAll();
            salesModel.addRow(new Object[]{sale.getMedicineName(), sale.getQuantity(), sale.getTotalPrice()});
            
            // تحديث واجهة البحث بالبيانات الجديدة
            searchMedicine(); 
            JOptionPane.showMessageDialog(this, "تمت عملية البيع بنجاح");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "الكمية يجب أن تكون رقماً");
        }
    }
}
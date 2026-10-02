package pharmise.ui;

import pharmise.DataStore;
import pharmise.model.User;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    JTextField txtUser = new JTextField(15);
    JPasswordField txtPass = new JPasswordField(15);
    JButton btnLogin = new JButton("تسجيل الدخول");

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(StyleTheme.BG_COLOR);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // عنوان
        JLabel title = new JLabel("Pharmacy System", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(StyleTheme.PRIMARY);
        panel.add(title);

        StyleTheme.styleField(txtUser);
        StyleTheme.styleField(txtPass);
        StyleTheme.styleButton(btnLogin, StyleTheme.PRIMARY);

        panel.add(txtUser);
        panel.add(txtPass);
        panel.add(btnLogin);

        add(panel);

        btnLogin.addActionListener(e -> checkLogin());
        setVisible(true);
    }

    private void checkLogin() {
        String u = txtUser.getText();
        String p = new String(txtPass.getPassword());

        for (User user : DataStore.users) {
            if (user.getUsername().equals(u) && user.getPassword().equals(p)) {
                new MainDashboard(user.getRole());
                this.dispose();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "بيانات الدخول غير صحيحة", "خطأ", JOptionPane.ERROR_MESSAGE);
    }
}
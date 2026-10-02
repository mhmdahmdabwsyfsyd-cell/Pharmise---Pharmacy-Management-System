package pharmise;

import pharmise.model.*;
import java.io.*;
import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Medicine> medicines = new ArrayList<>();
    public static ArrayList<Sale> sales = new ArrayList<>();

    static {
        // طباعة مسار العمل الحالي لمعرفة مكان الملفات
        System.out.println(">> Working Directory: " + System.getProperty("user.dir"));

        loadData();

        // إذا لم توجد بيانات (أول تشغيل)، قم بتوليد الداتا الكبيرة وحفظها
        if (users.isEmpty() || medicines.isEmpty()) {
            System.out.println(">> No data found. Generating BIG DATA...");
            initBigData();
        } else {
            System.out.println(">> Data loaded successfully.");
        }
    }

    private static void initBigData() {
        // --- 1. إضافة المستخدمين ---
        users.clear();
        users.add(new User("admin", "1234", "Admin"));           // مدير النظام
        users.add(new User("dr_ahmed", "1111", "Pharmacist"));   // صيدلي فترة صباحية
        users.add(new User("dr_sara", "2222", "Pharmacist"));    // صيدلي فترة مسائية
        users.add(new User("manager", "admin", "Admin"));        // مدير فرع

        // --- 2. إضافة الأدوية (قاعدة بيانات ضخمة) ---
        medicines.clear();

        // >> مسكنات وخافض حرارة
        addMed("Panadol Extra", 35.0, 150);
        addMed("Panadol Advance", 25.0, 200);
        addMed("Panadol Cold+Flu", 45.0, 80);
        addMed("Cataflam 50mg", 42.0, 100);
        addMed("Brufen 400mg", 28.5, 120);
        addMed("Brufen 600mg", 35.0, 90);
        addMed("Ketolac Amp", 18.0, 50);
        addMed("Voltaren 100mg", 55.0, 60);
        addMed("Aspirin Protect 100", 15.0, 300);
        addMed("Ezmol 500", 20.0, 100);

        // >> مضادات حيوية
        addMed("Augmentin 1g", 98.0, 40);
        addMed("Augmentin 625mg", 65.0, 50);
        addMed("Hibiotic 1g", 95.0, 35);
        addMed("Curam 1g", 90.0, 30);
        addMed("Zithromax 500", 60.0, 20);
        addMed("Flumox 1g", 52.0, 45);
        addMed("Ciprofar 500", 40.0, 60);
        addMed("Unictam 1500 vial", 35.0, 100);

        // >> أدوية برد وحساسية
        addMed("Congestal Tabs", 32.0, 150);
        addMed("1,2,3 Tabs", 28.0, 120);
        addMed("Comtrex", 30.0, 100);
        addMed("Zyrtec", 45.0, 60);
        addMed("Mosapride", 58.0, 40);
        addMed("Clara", 50.0, 50);
        addMed("Telfast 120", 48.0, 70);
        addMed("Telfast 180", 65.0, 60);
        addMed("Otrivin Adult Drops", 22.0, 80);
        addMed("Otrivin Baby Saline", 18.0, 50);

        // >> معدة وهضم
        addMed("Antinal Caps", 25.0, 100);
        addMed("Streptoquin", 18.0, 80);
        addMed("Nanazoxic", 35.0, 60);
        addMed("Visceralgine", 22.0, 90);
        addMed("Buscopan", 16.0, 120);
        addMed("Spasmo-Digestin", 30.0, 70);
        addMed("Controloc 40", 110.0, 40);
        addMed("Nexium 40", 140.0, 30);
        addMed("Zurcal 40", 95.0, 40);
        addMed("Gaviscon Syrup", 120.0, 25);
        addMed("Rennie", 10.0, 200);

        // >> فيتامينات ومكملات
        addMed("Omega 3 Plus", 125.0, 50);
        addMed("Vitacid C", 22.0, 150);
        addMed("C-Retard 500", 28.0, 100);
        addMed("Neuroton", 45.0, 80);
        addMed("Milga Advance", 70.0, 90);
        addMed("Kerovit", 65.0, 60);
        addMed("Royal Jelly 1000", 85.0, 40);
        addMed("Feroglobin Caps", 60.0, 55);
        addMed("Osteocare", 75.0, 50);

        // >> أمراض مزمنة (ضغط/سكر/قلب)
        addMed("Concor 5mg", 45.0, 100);
        addMed("Concor 10mg", 65.0, 80);
        addMed("Bisocard 5", 35.0, 90);
        addMed("Plavix 75", 220.0, 30);
        addMed("Ator 10", 60.0, 60);
        addMed("Crestor 10", 180.0, 25);
        addMed("Glucophage 1000", 35.0, 120);
        addMed("Amaryl 3mg", 25.0, 100);
        addMed("Lantus Insulin", 350.0, 15);
        addMed("Galvus Met", 140.0, 40);
        addMed("Capoten 25", 20.0, 100);
        addMed("Tritace 5", 40.0, 80);

        // >> مستلزمات وعناية
        addMed("Betadine Solution", 35.0, 60);
        addMed("Alcohol Spray 70%", 25.0, 200);
        addMed("Face Mask Box", 50.0, 100);
        addMed("Thermometer Digital", 80.0, 30);
        addMed("Pampers Size 3", 220.0, 20);
        addMed("Pampers Size 4", 240.0, 20);
        addMed("Fucidin Cream", 45.0, 50);
        addMed("Voltaren Gel", 60.0, 40);
        addMed("Panthenol Cream", 30.0, 80);

        System.out.println(">> Initializing Data Complete. Saving files...");
        saveAll();
    }

    // دالة مساعدة لاختصار كود الإضافة
    private static void addMed(String name, double price, int qty) {
        medicines.add(new Medicine(name, price, qty));
    }

    // --- دوال الحفظ التقليدية (المضمونة) ---

    public static void saveUsers() {
        try {
            // استخدام FileWriter مباشرة لإنشاء الملف
            PrintWriter w = new PrintWriter(new FileWriter("users.txt"));
            for (User u : users) {
                w.println(u.getUsername() + "," + u.getPassword() + "," + u.getRole());
            }
            w.close();
            System.out.println(">> users.txt saved successfully.");
        } catch (IOException e) {
            System.err.println("!! Error saving users.txt: " + e.getMessage());
        }
    }

    public static void saveMeds() {
        try {
            PrintWriter w = new PrintWriter(new FileWriter("meds.txt"));
            for (Medicine m : medicines) {
                w.println(m.getName() + "," + m.getPrice() + "," + m.getQuantity());
            }
            w.close();
            System.out.println(">> meds.txt saved successfully.");
        } catch (IOException e) {
            System.err.println("!! Error saving meds.txt: " + e.getMessage());
        }
    }

    public static void saveSales() {
        try {
            PrintWriter w = new PrintWriter(new FileWriter("sales.txt"));
            for (Sale s : sales) {
                w.println(s.getMedicineName() + "," + s.getQuantity() + "," + s.getTotalPrice());
            }
            w.close();
            System.out.println(">> sales.txt saved successfully.");
        } catch (IOException e) {
            System.err.println("!! Error saving sales.txt: " + e.getMessage());
        }
    }

    public static void saveAll() {
        saveUsers();
        saveMeds();
        saveSales();
    }

    // --- دوال التحميل ---

    public static void loadData() {
        loadUsers();
        loadMeds();
        loadSales();
    }

    private static void loadUsers() {
        try {
            File f = new File("users.txt");
            if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    if(p.length == 3) users.add(new User(p[0], p[1], p[2]));
                }
                br.close();
            }
        } catch (Exception e) {}
    }

    private static void loadMeds() {
        try {
            File f = new File("meds.txt");
            if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    if(p.length == 3) medicines.add(new Medicine(p[0], Double.parseDouble(p[1]), Integer.parseInt(p[2])));
                }
                br.close();
            }
        } catch (Exception e) {}
    }

    private static void loadSales() {
        try {
            File f = new File("sales.txt");
            if (f.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    if(p.length == 3) sales.add(new Sale(p[0], Integer.parseInt(p[1]), Double.parseDouble(p[2])));
                }
                br.close();
            }
        } catch (Exception e) {}
    }
}
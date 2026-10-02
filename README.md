# 💊 Pharmise - Pharmacy Management System

**Pharmise** is a lightweight, desktop-based Pharmacy Management System built with **Java** and **Java Swing**. It provides a clean, user-friendly interface for managing inventory, handling point-of-sale (POS) transactions, tracking low-stock items, and generating sales reports.

---

## ✨ Features

- **🔐 Authentication & Role-Based Access Control**
  - **Admin**: Full access to inventory management, system analytics, and reports.
  - **Pharmacist**: Access to the cashier and POS system.
- **🛒 Point of Sale (POS)**
  - Real-time medicine search.
  - Auto-calculation of total prices and instant stock updates.
  - Interactive billing table.
- **📦 Inventory & Stock Management**
  - Built-in dataset pre-loaded with medical products and categories.
  - Low-stock alerts for items with quantities below threshold (e.g., < 10 units).
- **📊 Sales Analytics & Reporting**
  - Total revenue computation.
  - Dynamic inventory deficit tracking.
- **💾 Local Data Persistence**
  - Lightweight file-based storage (`users.txt`, `meds.txt`, `sales.txt`).
  - Automated initial data seeding.

---

## 🛠️ Tech Stack & Architecture

- **Language:** Java (JDK 8+)
- **UI Framework:** Java Swing with System LookAndFeel & Custom Modern Flat Design Theme (`StyleTheme`)
- **Architecture:** Object-Oriented Programming (OOP) with Model-View Separation
- **Data Persistence:** I/O Stream File Handling (CSV format)

---

## 📁 Project Structure

```text
pharmise/
├── model/
│   ├── User.java          # User entity (Admin/Pharmacist)
│   ├── Medicine.java      # Medicine item model
│   └── Sale.java          # Sales transaction model
├── ui/
│   ├── StyleTheme.java    # Custom UI palette & typography
│   ├── LoginFrame.java    # Login GUI component
│   ├── MainDashboard.java # Main tabbed navigation layout
│   ├── SalesPanel.java    # POS and checkout UI
│   └── AnalysisPanel.java # Reports and stock alerts UI
├── DataStore.java         # Centralized data loader and file logger
└── PharmacyApp.java       # Application entry point

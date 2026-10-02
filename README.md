# 💊 Pharmise — Pharmacy Management System

> A lightweight desktop-based Pharmacy Management System built with **Java** and **Java Swing**, designed to simplify pharmacy operations through inventory management, point-of-sale transactions, stock monitoring, and sales analytics.

---

## 📌 Overview

**Pharmise** is a desktop pharmacy management application developed using **Java Swing** with a clean and modern user interface.

The system is designed to help pharmacy staff manage daily operations efficiently, including:

- Managing medicines and inventory.
- Processing sales through a Point-of-Sale (POS) system.
- Monitoring low-stock medicines.
- Tracking sales and revenue.
- Managing users based on their roles.
- Persisting application data using lightweight CSV-based files.

The project focuses on applying **Object-Oriented Programming (OOP)** principles, GUI development with **Java Swing**, and practical file-based data persistence.

---

## ✨ Features

### 🔐 Authentication & Role-Based Access

The system provides role-based access for different types of users:

**Admin**
- Full access to inventory management.
- Access to analytics and reports.
- View stock information and system statistics.

**Pharmacist**
- Access to the cashier.
- Process medicine sales.
- Search medicines and complete transactions.

---

### 🛒 Point of Sale (POS)

The POS module provides a simple and interactive checkout experience:

- 🔎 Real-time medicine search.
- 💰 Automatic price calculation.
- 🧮 Automatic total calculation.
- 📋 Interactive billing table.
- 📦 Instant inventory updates after successful sales.
- ✅ Simple and efficient checkout workflow.

---

### 📦 Inventory & Stock Management

Pharmise provides basic inventory management capabilities:

- Pre-loaded medicine dataset.
- Medicine categorization.
- Stock quantity tracking.
- Automatic stock updates after sales.
- ⚠️ Low-stock alerts for medicines below the configured threshold.

> Example: Medicines with quantities below **10 units** can be flagged as low stock.

---

### 📊 Sales Analytics & Reporting

The application provides useful information about pharmacy performance:

- 💵 Total revenue calculation.
- 📈 Sales tracking.
- 📦 Inventory deficit monitoring.
- ⚠️ Low-stock medicine identification.
- 📊 Basic system analytics.

---

### 💾 Local Data Persistence

Pharmise uses lightweight file-based storage instead of an external database.

Application data is stored using CSV/text files such as:

```text
users.txt
meds.txt
sales.txt

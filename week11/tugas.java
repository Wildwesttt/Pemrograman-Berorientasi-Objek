/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week11;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Alfian Ade Pratama
 */
public class tugas {

    /**
     * @param args the command line arguments
     */
    
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            System.out.print("Pilihan Menu: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    insert(scanner);
                break;
                case 2:
                    update(scanner);
                break;
                case 3:
                    delete(scanner);
                break;
                case 4:
                    show();
                break;
                case 5:
                    System.out.println("Exiting...");
                break;
                default:
                    System.out.println("Pilihan Menu Invalid, coba lagi.");
            }
        } while (choice != 5);

        scanner.close();
    }
    
    public static void showMenu() {
        
        System.out.println("Menu:");
        System.out.println("1. Insert Data");
        System.out.println("2. Update Data");
        System.out.println("3. Delete Data");
        System.out.println("4. Show Data");
        System.out.println("5. Exit");
    }
    
    public static void insert(Scanner scanner) {
        
        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Judul Buku: ");
        String judul_buku = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit Buku: ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan Jumlah Stok Buku: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Jumlah Penulis: ");
        int penulis = scanner.nextInt();
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO buku (id, judul_buku, tahun_terbit, stok, penulis) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, judul_buku);
            ps.setInt(3, tahun_terbit);
            ps.setInt(4, stok);
            ps.setInt(5, penulis);

            ps.execute();

            stmt.close();
            conn.close();
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update(Scanner scanner) {
        
        System.out.print("Masukkan ID untuk Update Buku: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        if (!exists(id)) {
                System.out.println("Data Buku tidak ada!");
            return;
        }
        System.out.print("Masukkan Judul Buku Baru: ");
        String judul_buku = scanner.nextLine();
        System.out.print("Masukkan Tahun Terbit Buku Baru: ");
        int tahun_terbit = scanner.nextInt();
        System.out.print("Masukkan Stok Buku Baru: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Jumlah Penulis Baru: ");
        int penulis = scanner.nextInt();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "UPDATE buku SET judul_buku = ?, tahun_terbit = ?, stok = ?, penulis = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, judul_buku);
            ps.setInt(2, tahun_terbit);
            ps.setInt(3, stok);
            ps.setInt(4, penulis);
            ps.setInt(5, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(Scanner scanner) {
        
        System.out.print("Masukkan ID Buku untuk di Delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (!exists(id)) {
                System.out.println("Data Buku tidak ada!");
            return;
        }

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM buku WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void show() {
    
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM buku");
            
            int i = 1;
            while(rs.next()) {
                System.out.println("========Selamat Datang di Perpustakaan========");
                System.out.println("Data ke-" + i);
		System.out.println("ID: " + rs.getString("id"));
		System.out.println("Judul Buku: " + rs.getString("judul_buku"));
		System.out.println("Tahun Terbit: " + rs.getString("tahun_terbit"));
		System.out.println("Stok: " + rs.getString("stok"));
		System.out.println("Penulis: " + rs.getString("penulis"));
                System.out.println("==============================================");
		i++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
	}
        
	catch(Exception e) {
            e.printStackTrace();
	}
    }
    
    public static boolean exists(int id) {
        
        boolean found = false;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT id FROM buku WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            found = rs.next();

            rs.close();
            ps.close();
            conn.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }

        return found;
    }
   }
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Categories;
import model.Customers;
import model.Item;
import model.Pagination;
import model.Products;

/**
 *
 * @author Adim
 */
public class DAO extends DBContext {

    public static DAO INSTANCE = new DAO();
    private Connection con;
    private String status = "OK";

    public DAO() {
        try {
            con = new DBContext().getConnection();
        } catch (Exception e) {
            status = "Error at connection" + e.getMessage();
        }
    }

    public static DAO getINSTANCE() {
        return INSTANCE;
    }

    public static void setINSTANCE(DAO INSTANCE) {
        DAO.INSTANCE = INSTANCE;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Account
    public Customers checkAcc(String user, String password) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[FullName]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Address]\n"
                + "      ,[Role]\n"
                + "  FROM [dbo].[Customers_HE176091]\n"
                + "  WHERE Username = ? and Password = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customers c = new Customers(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8)
                );
                return c;
            }
        } catch (SQLException e) {
            status = "Error at checkAcc " + e.getMessage();
        }
        return null;
    }

    // register
    public void register(Customers c) {
        String sql = "INSERT INTO [dbo].[Customers_HE176091]\n"
                + "           ([FullName]\n"
                + "           ,[Email]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Username]\n"
                + "           ,[Password]\n"
                + "           ,[Address]\n"
                + "           ,[Role])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, 0)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getFullName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhoneNumber());
            ps.setString(4, c.getUser());
            ps.setString(5, c.getPass());
            ps.setString(6, c.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at register " + e.getMessage();
        }
    }

    public boolean existedAcc(String username) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[FullName]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Address]\n"
                + "      ,[Role]\n"
                + "  FROM [dbo].[Customers_HE176091] WHERE Username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            status = "Error at existedAcc " + e.getMessage();
        }
        return false;
    }

    public List<Customers> sortByCustomer() {
        List<Customers> c = new ArrayList<>();
        String sql = "select * from Customers_HE176091\n"
                + "order by role desc";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Customers(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8)
                ));
            }
            return c;
        } catch (SQLException e) {
            status = "Error at sortByCustomer " + e.getMessage();
        }
        return c;
    }

    public boolean existedEmail(String email) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[FullName]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Address]\n"
                + "      ,[Role]\n"
                + "  FROM [dbo].[Customers_HE176091] WHERE Email = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            status = "Error at existedEmail " + e.getMessage();
        }
        return false;
    }

    public boolean existedPhoneNum(String phoneNum) {
        String sql = "SELECT [CustomerID]\n"
                + "      ,[FullName]\n"
                + "      ,[Email]\n"
                + "      ,[PhoneNumber]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Address]\n"
                + "      ,[Role]\n"
                + "  FROM [dbo].[Customers_HE176091] WHERE PhoneNumber = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, phoneNum);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            status = "Error at existedPhoneNum " + e.getMessage();
        }
        return false;
    }

    // List of -----
    public List<Products> manageProductsByAddmin() {
        List<Products> p = new ArrayList<>();
        String sql = "SELECT * FROM Products_HE176091";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new Products(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(7),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getLong(5))
                );
            }
        } catch (SQLException e) {
            status = "Error at getAllProducts " + e.getMessage();
        }
        return p;
    }

    public List<Products> getAllProducts() {
        List<Products> p = new ArrayList<>();
        String sql = "SELECT * FROM Products_HE176091 where isContinue <> 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new Products(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(7),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getLong(5))
                );
            }
        } catch (SQLException e) {
            status = "Error at getAllProducts " + e.getMessage();
        }
        return p;
    }

    public Products getProductById(int id) {
        String sql = "SELECT * FROM Products_HE176091 WHERE ProductID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Products(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(7),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getLong(5));
            }
        } catch (SQLException e) {
            status = "Error at getProductById " + e.getMessage();
        }
        return null;
    }

    public List<Products> getProductByCategories(int cid) {
        List<Products> p = new ArrayList<>();
        String sql = "SELECT * FROM Products_HE176091 where CategoryID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new Products(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(7),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getLong(5))
                );
            }
        } catch (SQLException e) {
            status = "Error at getProductByCategories " + e.getMessage();
        }
        return p;
    }

    public List<Categories> getAllCategories() {
        List<Categories> c = new ArrayList<>();
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories_HE176091]";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Categories(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
            status = "Error at getProductByCategories " + e.getMessage();
        }
        return c;
    }

    public List<Categories> getCategoryById(int id) {
        List<Categories> c = new ArrayList<>();
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories_HE176091] where CategoryID = ? ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.add(new Categories(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
            status = "Error at getProductByCategories " + e.getMessage();
        }
        return c;
    }

    public List<Products> searchProduct(String key) {
        List<Products> p = new ArrayList<>();
        String sql = "SELECT * FROM Products_HE176091 WHERE [ProductName] LIKE '%" + key + "%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.add(new Products(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(7),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(6),
                        rs.getLong(5))
                );
            }
        } catch (SQLException e) {
            status = "Error at searchProduct " + e.getMessage();
        }
        return p;
    }

    public void addOrder(Customers c, Cart cart) {
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try {
            String sql = "INSERT INTO [dbo].[Orders_HE176091]\n"
                    + "           ([CustomerID]\n"
                    + "           ,[date]\n"
                    + "           ,[totalmoney])\n"
                    + "     VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setString(2, date);
            ps.setDouble(3, cart.getTotalMoney());
            ps.executeUpdate();
            String sql1 = "select top 1 OrderID from Orders_HE176091 order by OrderID desc";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[OrderDetails_HE176091]\n"
                            + "           ([OrderID]\n"
                            + "           ,[ProductID]\n"
                            + "           ,[quantity]\n"
                            + "           ,[price])\n"
                            + "     VALUES(?,?,?,?)";
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, i.getProduct().getId());
                    ps2.setInt(3, i.getQuantity());
                    ps2.setDouble(4, i.getPrice());
                    ps2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            status = "Error at addOrder " + e.getMessage();
        }
    }

    // update - insert - detele
    public void updateProduct(int id, long price, int quantity, int cateID, int statusProduct) {
        String sql = "UPDATE [dbo].[Products_HE176091]\n"
                + "   SET [Price] = ? ,[Quantity] = ?, [CategoryID] = ?, [isContinue] = ?"
                + " WHERE ProductID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, price);
            ps.setInt(2, quantity);
            ps.setInt(3, cateID);
            ps.setInt(4, statusProduct);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at updateProduct " + e.getMessage();
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM [dbo].[Products_HE176091]\n"
                + "      WHERE ProductID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at deleteProduct " + e.getMessage();
        }
    }

    public void addNewProduct(String name, int cateID, String des, long price, String image, int quantity) {
        String sql = "INSERT INTO [dbo].[Products_HE176091]\n"
                + "           ([ProductName]\n"
                + "           ,[CategoryID]\n"
                + "           ,[Description]\n"
                + "           ,[Price]\n"
                + "           ,[Image]\n"
                + "           ,[Quantity])\n"
                + "     VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, cateID);
            ps.setString(3, des);
            ps.setLong(4, price);
            ps.setString(5, image);
            ps.setInt(6, quantity);
            ps.execute();
        } catch (SQLException e) {
            status = "Error at addNewProduct " + e.getMessage();
        }
    }

    public void deleteCustomers(int id) {
        String sql = "DELETE FROM [dbo].[Customers_HE176091]\n"
                + "      WHERE CustomerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at deleteCustomers " + e.getMessage();
        }
    }

    public Customers getCustomersById(int id) {
        String sql = "SELECT * FROM [dbo].[Customers_HE176091]\n"
                + "      WHERE CustomerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Customers(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getBoolean(8)
                );
            }
        } catch (SQLException e) {
            status = "Error at getCustomersById " + e.getMessage();
        }
        return null;
    }

    public void updateCustomer(int id, String name, String email, String phone, String address, String user, String pass) {
        String sql = "UPDATE [dbo].[Customers_HE176091]\n"
                + "   SET [FullName] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Username] = ?\n"
                + "      ,[Password] = ?\n"
                + "      ,[Address] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, user);
            ps.setString(5, pass);
            ps.setString(6, address);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at updateCustomer " + e.getMessage();
        }
    }

    public void updateProfile(Customers c) {
        String sql = "UPDATE [dbo].[Customers_HE176091]\n"
                + "   SET [FullName] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[PhoneNumber] = ?\n"
                + "      ,[Address] = ?\n"
                + " WHERE CustomerID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getFullName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhoneNumber());
            ps.setString(4, c.getAddress());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at updateProfile " + e.getMessage();
        }
    }

    public void changePass(Customers c) {
        String sql = "UPDATE [dbo].[Customers_HE176091]\n"
                + "   SET [Password] = ?\n"
                + "   WHERE [Username] = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getPass());
            ps.setString(2, c.getUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            status = "Error at changePass " + e.getMessage();
        }
    }

    public List<Products> getProductsByPage(int currentPage, int pageLimit, List<Products> allProducts) {
        Pagination pagination = new Pagination(allProducts.size(), pageLimit, currentPage);
        List<Products> productsOnPage = new ArrayList<>();

        for (int i = pagination.getStartItem(); i <= pagination.getLastItem() && i < allProducts.size(); i++) {
            productsOnPage.add(allProducts.get(i));
        }

        return productsOnPage;
    }

}

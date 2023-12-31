/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Comment;

/**
 *
 * @author Admin
 */
public class CommentDBcontext extends DBContext {

    public ArrayList<Comment> getAllCommentByIDAccount(int id) {
        ArrayList<Comment> Comments = new ArrayList<>();
        try {

            String sql = "SELECT  * FROM Comments where EntryID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Comment a = new Comment(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5));
                Comments.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Comments;
    }

    public void delete(int id) {

        try {

            String sql = "DELETE FROM [Comments]\n"
                    + "      WHERE CommentID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public static void main(String[] args) {
        CommentDBcontext a = new CommentDBcontext();
        ArrayList<Comment> entries = a.getAllCommentByIDAccount(2);
        for (Comment entry : entries) {
            System.out.println(entry.getDateModified());
        }
    }
}

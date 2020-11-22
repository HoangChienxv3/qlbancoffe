/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.Utils;
import Helper.shareHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.TaiKhoan;

/**
 *
 * @author CHIEN
 */
public class DangNhapDao {

    static Connection con = Utils.myConnection();
    public static boolean VaiTro = false;

    public synchronized static int DangNhap(TaiKhoan TK) {
        String sql = "select * from TaiKhoan\n"
                + "where TenTaiKhoan = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, TK.getTenTaiKhoan());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                if (rs.getString(2).equals(TK.getMatKhau())) {
                    VaiTro = rs.getBoolean(5);
                    TK.setVaiTro(VaiTro);
                    shareHelper.User = TK;           
                    //System.out.println(VaiTro);
                    return 1;//1 là đăng nhập đúng thông tin
                } else {
                    return 0;//sai mật khẩu
                }
            } else {
                return -1;//không tồn tại tài khoản
            }
        } catch (Exception e) {
            return -2;
        }

    }

}

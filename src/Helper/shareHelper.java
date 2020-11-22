/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.Image;
import javax.swing.ImageIcon;
import model.TaiKhoan;

/**
 *
 * @author CHIEN
 */
public class shareHelper {

    public static TaiKhoan User = null;
    public static boolean vaitro = false;
    //icon bàn
    ImageIcon img = new ImageIcon("src\\Icon\\ban.png");
    Image im = img.getImage();
    ImageIcon icon = new ImageIcon(im.getScaledInstance(80, 40, im.SCALE_SMOOTH));
    //xóa thông tin người xử dụng khi đăng xuất
    public synchronized static void logOff() {
        shareHelper.User = null;
    }

    //kiểm tra đã đăng nhập hay chưa
    public synchronized static boolean checkDangNhap() {
        return shareHelper.User != null;
    }
}

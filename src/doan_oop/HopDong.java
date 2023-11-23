package DOANOOP;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HopDong{
    String idHD;
    String loaiHD;
    String tenPB;
    String ngayKy;
    int thoiHan;
    static Scanner sc= new Scanner(System.in);
    

    public HopDong() {
    }

    public HopDong(String idHD, String loaiHD, String tenPB, String ngayKy, int thoiHan) {
        this.idHD = idHD;
        this.loaiHD = loaiHD;
        this.tenPB = tenPB;
        this.ngayKy = ngayKy;
        this.thoiHan = thoiHan;
    }

    public String getIdHD() {
        return idHD;
    }

    public void setIdHD(String idHD) {
        
        this.idHD = idHD;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        
        this.loaiHD = loaiHD;
    }

    public String getTenPB() {
        return tenPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        
        this.thoiHan = thoiHan;
    }
    
    @Override
    public String toString() {
        return  " idHD= " + idHD + ", loaiHD=" + loaiHD + ", tenPB=" + tenPB + ", ngayKy=" + ngayKy + ", thoiHan=" + thoiHan+ "thang" ;
    }
    public void inputHopDong(){
        System.out.println("Mời nhập mã hợp đồng");
        String id=sc.nextLine();
        setIdHD(id);
        System.out.println("Mời nhập loại hợp đồng");
        String loai=sc.nextLine();
        setLoaiHD(loai);
        System.out.println("Mời nhập phòng ban");
        String ten=sc.nextLine();
        setTenPB(ten);
        System.out.println("Mời nhập ngay ky hợp đồng");
        String ngayky=sc.nextLine();
        setNgayKy(ngayky);
        System.out.println("Mời nhập thòi hạn hợp đồng");
        int thoihan=sc.nextInt();
        setThoiHan(thoihan);
    }
   public void outputHopDong(){
       System.out.println(toString());
   }

   
}

package doan_oop;

public class KeToan extends PhongBan {
    private double heSoLuong = 2.3;
    private double luongCoBan = 2000000;
    public KeToan(){

    }
 
    public KeToan(String maPhongBan){
        super(maPhongBan);
    }

    public KeToan(String maPhongBan,String tenPhongBan){
        super(maPhongBan,tenPhongBan);  
    }    


    public double getHeSoLuong() {
        return heSoLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    @Override 
    public double tinhLuong(){
        return getHeSoLuong() * getLuongCoBan();
    }
}

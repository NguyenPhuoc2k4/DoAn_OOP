package DOANOOP;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ListHopDong implements ThaoTac{

    public  HopDong[] listHopDong ;   
    private int numberOfContracts;
    static Scanner sc = new Scanner(System.in);

    public int getNumberOfContracts(){
        return numberOfContracts;
    }

    public ListHopDong() {
        listHopDong = new HopDong[15];        
        numberOfContracts = 0;
    }
     
    public void xemDsHopDong() {
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println(listHopDong[i]);
        }
    }
    
    public void themHopDong() {
        if (numberOfContracts < listHopDong.length) {
            HopDong HD=new HopDong();
            HD.inputHopDong();
            listHopDong[numberOfContracts++]=HD;
        } else {
            System.out.println("Danh sách hop dong đã đầy, không thể thêm mới.");
        }
    }
    
    public void xoaHopDong() {
        System.out.println("Nhap id hop dong can xoa:");
        String id= sc.nextLine();
        boolean found =false;
        for (int i = 0; i < numberOfContracts; i++) {
            if (listHopDong[i].getIdHD().equalsIgnoreCase(id)) {
                found=true;
                 System.out.println("Bạn có chắc chắn muốn xóa hợp đồng này? (yes/no)");
                 String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("yes")) {
                    for (int j = i; j < numberOfContracts - 1; j++) {
                    listHopDong[j] = listHopDong[j + 1];
                    }
                     listHopDong[numberOfContracts - 1] = null;
                     numberOfContracts--;
                     System.out.println("Đã xóa hợp đồng có ID " + id);
                }else {
                     System.out.println("Hủy bỏ việc xóa hợp đồng.");
                }
                break;
            }
        }
        System.out.println("Không tìm thấy hop dong có ID " + id);
    }
    
    public void timKiemHopDong() {
        System.out.println("Nhap id hop dong can tim:");
        String id= sc.nextLine();
        for (int i = 0; i < numberOfContracts; i++) {
            if (listHopDong[i].getIdHD().equalsIgnoreCase(id)) {
                System.out.println("Đã tìm thấy hợp đồng:");
                System.out.println(listHopDong[i]);
                return;
            }
        }
        System.out.println("Không tìm thấy hợp đồng có ID " + id);
    }
    
    public void suaHopDong() {
    System.out.println("Nhập mã hợp đồng cần sửa:");
    String id = sc.nextLine();
    boolean found = false;
    for (int i = 0; i < numberOfContracts; i++) {
        if (listHopDong[i].getIdHD().equalsIgnoreCase(id)) {
            found = true;
            System.out.println("Nhập thông tin mới cho hợp đồng:");
            listHopDong[i].inputHopDong();
            System.out.println("Thông tin hợp đồng sau khi sửa:");
            System.out.println(listHopDong[i]);
            break;
        }
    }
    System.out.println("Không tìm thấy hợp đồng có ID " + id);
}
   
    public void addHopDong(HopDong HD) {
        if (numberOfContracts < 100) {
            listHopDong[numberOfContracts++] = HD;
        } else {
            System.out.println("Danh sach day");
        }
    }

    
    public void ghiFile() {
        try {
            FileWriter filew =new FileWriter("hopDong.txt");
            BufferedWriter writer= new BufferedWriter(filew);
            for(int i=0; i<numberOfContracts;i++){
                writer.write(listHopDong[i].getIdHD() + "," + listHopDong[i].getLoaiHD() + "," + listHopDong[i].getTenPB() + ","
                        + listHopDong[i].getNgayKy() + "," + listHopDong[i].getThoiHan() + "\n");
            }
            System.out.println("Đã ghi danh sách hợp đồng vào file " + filew);
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }
    
    
    public void docFile() {
        try {
            FileReader filer=new FileReader("hopDong.txt");
            BufferedReader reader = new BufferedReader(filer);
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(",");
                HopDong HD = new HopDong();
                    HD.setIdHD(parts[0]);
                    HD.setLoaiHD(parts[1]);
                    HD.setTenPB(parts[2]);
                    HD.setNgayKy(parts[3]);
                    HD.setThoiHan(Integer.parseInt(parts[4]));

                    addHopDong(HD);

            }
            System.out.println("Đã đọc danh sách hợp đồng từ file " + filer);
        } catch (IOException e) {
            System.out.println("Loi");
        }
    }
    
    public void xuat() {
        xemDsHopDong();
    }

    public void menu() {
        docFile();
        int choice = 0;
        do {
            System.out.println("||============ Chon thao tac ===============||");
            System.out.println("||1. Them hop dong moi                      ||");
            System.out.println("||2. Xuat danh sach hop dong                ||");
            System.out.println("||3. Xoa hop dong                           ||");
            System.out.println("||4. Sua hop dong                           ||");
            System.out.println("||5. Tim hop dong                           ||");
            System.out.println("||0. Quay lai                               ||");
            System.out.println("||==========================================||");
            System.out.print("Nhap thao tac: ");

            choice = Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1: {
                    themHopDong();
                    break;
                }
                case 2: {
                    xuat();
                    break;
                }
                case 3: {
                    xoaHopDong();
                    break;
                }
                case 4: {
                    suaHopDong();
                    break;
                }
                case 5: {
                    timKiemHopDong();
                    break;
                }
                case 0:{
                    ghiFile();
                    break;
                }
                default:
                    System.out.println("Nhap sai thao tac, xin nhap lai !!!");
            }
        } while (choice != 0);
    }
    
}

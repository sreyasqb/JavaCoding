import java.time.LocalDate;
import java.util.Date;

public class CitizenAadhar{
    String aadharNo;
    String name;
    LocalDate dob;
    String gender;
    String address;
    String phoneNo;

    public CitizenAadhar(String aadharNo,String name,LocalDate dob,String gender,String address,String phoneNo){
        this.aadharNo=aadharNo;
        this.name=name;
        this.dob=dob;
        this.gender=gender;
        this.address=address;
        this.phoneNo=phoneNo;
    }
    public void updateAddress(String address){
        this.address=address;
        System.out.println("Address has been updated to\n"+address);
    }
    public void updatePhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
        System.out.println("phone number has been updated to\n"+phoneNo);
    }
    @Override
    public String toString(){
        return "Name : "+this.name+"\nDob : "+dob+"\nGender : "+gender+"\nAddress : "+address+"\nPhoneNo"+phoneNo+"\nAadhar No : "+aadharNo;
    }
    public String toCsv(){
        String splitBy=", ";
        return this.aadharNo+splitBy+this.name+splitBy+dob+splitBy+gender+splitBy+address+splitBy+phoneNo;
    }
}

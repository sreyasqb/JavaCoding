import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class GUI extends JFrame implements ActionListener{
    static JTextField t;
    static JTextField aadharNoTF;
    static JTextField nameTF;
    static JTextField genderTF;
    static JTextField addressTF;
    static JTextField phoneNoTF;
    static JTextField yearTF;
    static JTextField monthTF;
    static JTextField dayTF;

    // JFrame
    static JFrame f;

    // JButton
    static JButton submit;
    static JButton update;

    // label to display text
    static JLabel l;
    public GUI(){}
    public static void main(String[] args){
        f = new JFrame("aadhar");

        submit = new JButton("submit");
        update = new JButton("update");

        GUI gui = new GUI();
        l= new JLabel("");
        submit.addActionListener(gui);
        update.addActionListener(gui);

        aadharNoTF = new JTextField("",16);
        nameTF = new JTextField("",16);
        genderTF=new JTextField("",16);
        yearTF=new JTextField("",4);
        monthTF=new JTextField("",2);
        dayTF=new JTextField("",2);
        addressTF = new JTextField("",16);
        phoneNoTF = new JTextField("",16);
        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(new JLabel("Enter Aadhar no"));
        p.add(aadharNoTF);
        p.add(new JLabel("Enter Name"));
        p.add(nameTF);
        p.add(new JLabel("Enter Gender"));
        p.add(genderTF);
        p.add(new JLabel("Enter dob\n"));
        p.add(new JLabel("year"));
        p.add(yearTF);
        p.add(new JLabel("Month"));
        p.add(monthTF);
        p.add(new JLabel("Day"));
        p.add(dayTF);
        p.add(new JLabel("Address"));
        p.add(addressTF);
        p.add(new JLabel("phoneNo"));
        p.add(phoneNoTF);
        p.add(submit);
        p.add(update);
        p.add(l);



        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.setVisible(true);
        //CitizenAadhar sreyas=new CitizenAadhar("Sreyas",LocalDate.of(2002,6,25),"M","303 laxmi classic homes","+91 9886444150");
        //System.out.println(sreyas);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        if (s.equals("submit")) {
            // set the text of the label to the text of the field

            String aaNo=aadharNoTF.getText();
            if (aaNo.length()==12){
                boolean exists=false;
                try {
                    String line = "";
                    String splitBy = ",";
                    BufferedReader br = new BufferedReader(new FileReader("Z:\\sem5\\javaFinal\\cafinal\\src\\aadharDetails.csv"));
                    while ((line = br.readLine()) != null)   //returns a Boolean value
                    {
                        String[] person = line.split(splitBy);    // use comma as separator
                        if (Objects.equals(person[0].strip(), aaNo.strip())){
                            exists=true;
                            break;
                        }
                    }
                    if (exists){
                        l.setText("Aadhar no already exists!");
                    }
                    else{
                        CitizenAadhar person= new CitizenAadhar(aadharNoTF.getText(),nameTF.getText(),LocalDate.of(Integer.parseInt(yearTF.getText()),Integer.parseInt(monthTF.getText()),Integer.parseInt(dayTF.getText())),genderTF.getText(),addressTF.getText(),phoneNoTF.getText());
                        FileWriter outputfile = new FileWriter("Z:\\sem5\\javaFinal\\cafinal\\src\\aadharDetails.csv",true);
                        outputfile.write(person.toCsv()+"\n");
                        outputfile.close();
                        l.setText("Successfully added!");
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

//                l.setText("SUCCESS");
//                System.out.println(person);
            }
            else{
                l.setText("Aadhar No is invalid");
            }


            // set the text of field to blank
//            t.setText("  ");
        }
        else if(s.equals("update")){
            FileWriter outputfile = null;
            boolean exists=false;
            String aaNo=aadharNoTF.getText();
            try {
                String line = "";
                String splitBy = ",";
                BufferedReader br = new BufferedReader(new FileReader("Z:\\sem5\\javaFinal\\cafinal\\src\\aadharDetails.csv"));
                while ((line = br.readLine()) != null)   //returns a Boolean value
                {
                    String[] person = line.split(splitBy);    // use comma as separator
                    if (Objects.equals(person[0].strip(), aaNo.strip())){
                        exists=true;
                        break;
                    }
                }
                if (!exists){
                    l.setText("Aadhar no doesnt exists to update");
                }
                else{
                    splitBy = ", ";
                    String updatedString = aadharNoTF.getText()+splitBy+ LocalDateTime.now()+splitBy+addressTF.getText()+splitBy+phoneNoTF.getText();
                    outputfile = new FileWriter("Z:\\sem5\\javaFinal\\cafinal\\src\\aadharUpdate.csv",true);
                    outputfile.write(updatedString+"\n");
                    outputfile.close();
                    l.setText("Updated succesfully!");
                }


            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}

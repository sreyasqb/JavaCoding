/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 20pt33
 */
abstract class PassengerTicket {

    int seatNo;
    boolean seatAvailable;
    String seatStatus, passengerName, passengerGender;
    String departure, destination, departureDateTime, issueDateTime;
    double totalPrice;

    PassengerTicket() {
        seatNo = 0;
        seatAvailable = true;
        seatStatus = null;
        passengerName = null;
        passengerGender = null;
        departure = null;
        destination = null;
        departureDateTime = "yyyy/mm/dd HH:mm:ss";
        issueDateTime = "yyyy/mm/dd HH:mm:ss";
        totalPrice = 0;
    }

    PassengerTicket(int sNo, boolean sA, String sStatus, String pName, String pGender, String dep, String des, String depTime, String iTime, double price) {
        seatNo = sNo;
        seatAvailable = sA;
        seatStatus = sStatus;
        passengerName = pName;
        passengerGender = pGender;
        departure = dep;
        destination = des;
        departureDateTime = depTime;
        issueDateTime = iTime;
        totalPrice = price;
    }

    abstract void setTotalPrice();

    @Override
    public String toString() {
        return "seatNo : " + seatNo + "\nseatAvailable : " + seatAvailable + "\nseatStatus : " + seatStatus + "\npassengerName : " + passengerName + "\ndeparture : " + departure + "\ndepartureTime : " + departureDateTime + "\nissueDateTime : " + issueDateTime + "\ntotalPrice : " + totalPrice;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int x) {
        seatNo = x;
    }

    public boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(boolean x) {
        seatAvailable = x;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String x) {
        seatStatus = x;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String x) {
        passengerName = x;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String x) {
        passengerGender = x;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String x) {
        departure = x;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String x) {
        destination = x;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String x) {
        departureDateTime = x;
    }

    public String getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(String x) {
        issueDateTime = x;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

}

class BusTicket extends PassengerTicket {

    int distance;
    double serviceCharge;

    BusTicket() {
        distance = 250;
        serviceCharge = 2.5;
    }

    BusTicket(int d, double s) {
        distance = d;
        serviceCharge = s;
    }

    void setTotalPrice() {
        totalPrice = distance * 0.08 + serviceCharge;
    }
}

interface TicketOperations {

    public boolean makeReservation(BusTicket ticket, String name, String gender);

    public boolean cancelReservation(BusTicket ticket);

    public boolean buyTicket(BusTicket ticket, String name, String gender);

    public boolean cancelTicketSold(BusTicket ticket);
}

class Officer implements TicketOperations {

    String name, address;

    Officer() {
        name = "unknown";
        address = "unknown";
    }

    Officer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    String getName() {
        return name;
    }

    void setName(String s) {
        name = s;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String s) {
        address = s;
    }

    public boolean makeReservation(BusTicket ticket, String name, String gender) {
        ticket.setPassengerName(name);
        ticket.setPassengerGender(gender);
        ticket.setSeatAvailable(false);
        ticket.setSeatStatus("Reserved");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setIssueDateTime(now.toString());
        return true;
    }

    public boolean buyTicket(BusTicket ticket, String name, String gender) {
        ticket.setPassengerName(name);
        ticket.setPassengerGender(gender);
        ticket.setSeatAvailable(false);
        ticket.setSeatStatus("SOLD");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setIssueDateTime(now.toString());
        return true;
    }
    public boolean cancelReservation(BusTicket ticket){
        ticket.setPassengerName("");
        ticket.setPassengerGender("");
        ticket.setSeatAvailable(true);
        ticket.setSeatStatus("AVAILABLE");
        ticket.setIssueDateTime("yyyy/MM/dd HH:mm:ss");
        return true;
    }
    public boolean cancelTicketSold(BusTicket ticket){
        ticket.setPassengerName("");
        ticket.setPassengerGender("");
        ticket.setSeatAvailable(true);
        ticket.setSeatStatus("AVAILABLE");
        ticket.setIssueDateTime("yyyy/MM/dd HH:mm:ss");
        return true;
    }

}

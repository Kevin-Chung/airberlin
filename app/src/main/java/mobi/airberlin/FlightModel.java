package mobi.airberlin;

import java.util.Calendar;

/**
 * Created by Jessica Bao on 11/9/2016.
 */

public class FlightModel {
    /*__fake__Flight time
    ____Point A to B
    ____flight number
    _____Prices
    _____Seat Class
    _____Type of plane
    _____Date
*/

    int flightNumber;
    double totalFlightPrice, fuelPrice, netPrice, taxPrice;
    String destinationA, destingationB, seatClass, typeOfPlane;

    Calendar flightDate, flightTime;

    public FlightModel(int flightNumber,  double fuelPrice, double netPrice, double taxPrice, String destinationA, String destingationB, String seatClass, String typeOfPlane, Calendar flightDate, Calendar flightTime) {
        this.flightNumber = flightNumber;
        this.fuelPrice = fuelPrice;
        this.netPrice = netPrice;
        this.taxPrice = taxPrice;
        this.destinationA = destinationA;
        this.destingationB = destingationB;
        this.seatClass = seatClass;
        this.typeOfPlane = typeOfPlane;
        this.flightDate = flightDate;
        this.flightTime = flightTime;

        this.totalFlightPrice = this.fuelPrice + this.taxPrice + this.netPrice;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public double getTotalFlightPrice() {
        return totalFlightPrice;
    }

    public void setTotalFlightPrice(double totalFlightPrice) {
        this.totalFlightPrice = totalFlightPrice;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(double taxPrice) {
        this.taxPrice = taxPrice;
    }

    public String getDestinationA() {
        return destinationA;
    }

    public void setDestinationA(String destinationA) {
        this.destinationA = destinationA;
    }

    public String getDestingationB() {
        return destingationB;
    }

    public void setDestingationB(String destingationB) {
        this.destingationB = destingationB;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getTypeOfPlane() {
        return typeOfPlane;
    }

    public void setTypeOfPlane(String typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Calendar flightDate) {
        this.flightDate = flightDate;
    }

    public Calendar getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Calendar flightTime) {
        this.flightTime = flightTime;
    }
}

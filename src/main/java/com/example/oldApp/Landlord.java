package com.example.oldApp;

public class Landlord
{
    private Address address;
    private Payment payment;
    private long id;

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Payment getPayment() { return payment; }

    public void setPayment(Payment payment) { this.payment = payment; }

    public long getId()
    {
        return id;
    }

    public void setId(long landlordID)
    {
        this.id = landlordID;
    }

}

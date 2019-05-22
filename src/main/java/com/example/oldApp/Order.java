package com.example.oldApp;

public class Order
{
    private long id;
    private String name;

    private Deposit deposit;
    private Price price;
    private Payment payment;


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Deposit getDeposit()
    {
        return deposit;
    }

    public void setDeposit(Deposit deposit) { this.deposit = deposit; }

    public Price getPrice()
    {
        return price;
    }

    public void setPrice(Price price)
    {
        this.price = price;
    }

    public Payment getPayment()
    {
        return payment;
    }

    public void setPayment(Payment payment)
    {
        this.payment = payment;
    }
}

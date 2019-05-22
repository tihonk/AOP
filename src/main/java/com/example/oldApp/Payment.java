package com.example.oldApp;

public class Payment
{
    private int id;
    private String saleStatus;

    public String getSaleStatus()
    {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus)
    {
        this.saleStatus = saleStatus;
    }

    public long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}

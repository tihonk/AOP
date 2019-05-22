package com.example.oldApp;

public class Deposit
{
    private int id;
    private Landlord landlord;
    private Tenant tenant;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Landlord getLandlord()
    {
        return landlord;
    }

    public void setLandlord(Landlord landlord)
    {
        this.landlord = landlord;
    }

    public Tenant getTenant()
    {
        return tenant;
    }

    public void setTenant(Tenant tenant)
    {
        this.tenant = tenant;
    }
}

package com.example.controller;

import com.example.dao.AddressDao;
import com.example.dao.DepositDao;
import com.example.dao.LandlordDao;
import com.example.dao.OrderDao;
import com.example.dao.PaymentDao;
import com.example.dao.PriceDao;
import com.example.dao.TenantDao;
import com.example.oldApp.Address;
import com.example.oldApp.Deposit;
import com.example.oldApp.Landlord;
import com.example.oldApp.Order;
import com.example.oldApp.Payment;
import com.example.oldApp.Price;
import com.example.oldApp.Tenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.annotation.Resource;

@Controller
public class GreetingController
{
    @Resource
    private OrderDao orderDao;

    @Resource
    private PaymentDao paymentDao;

    @Resource
    private AddressDao addressDao;

    @Resource
    private LandlordDao landlordDao;

    @Resource
    private TenantDao tenantDao;

    @Resource
    private PriceDao priceDao;

    @Resource
    private DepositDao depositDao;

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public String getPayment(@PathVariable Long id, Model model)
    {
        Payment payment = paymentDao.get(id);

        model.addAttribute("name", Payment.class.getSimpleName());
        model.addAttribute("value", payment.getId());
        model.addAttribute("paramm", payment.getSaleStatus());

        return "mycatalog";
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String getPayment(Model model)
    {
        List<Payment> payments = paymentDao.getAll();
        model.addAttribute("name", "payment");
        model.addAttribute("values", payments);
        return "mycatalog";
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public String getAddress(@PathVariable Long id, Model model)
    {
        Address address = addressDao.get(id);

        model.addAttribute("name", Address.class.getSimpleName());
        model.addAttribute("value", address.getId());
        model.addAttribute("paramm", address.getAddress());

        return "mycatalog";
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String getAddress(Model model)
    {
        List<Address> addresses = addressDao.getAll();
        model.addAttribute("name", "address");
        model.addAttribute("values", addresses);
        return "mycatalog";
    }

    @RequestMapping(value = "/landlord/{id}", method = RequestMethod.GET)
    public String getLandlord(@PathVariable Long id, Model model)
    {
        Landlord landlord = landlordDao.get(id);

        model.addAttribute("name", Landlord.class.getSimpleName());
        model.addAttribute("value", landlord.getId());
        model.addAttribute("paramm", getAddress(landlord.getAddress().getId()));
        model.addAttribute("paramm2", getSaleStatus(landlord.getPayment().getId()));

        return "mycatalog";
    }

    @RequestMapping(value = "/landlord", method = RequestMethod.GET)
    public String getLandlord(Model model)
    {
        List<Landlord> landlords = landlordDao.getAll();
        model.addAttribute("name", "landlord");
        model.addAttribute("values", landlords);
        return "mycatalog";
    }

    @RequestMapping(value = "/tenant/{id}", method = RequestMethod.GET)
    public String getTenant(@PathVariable Long id, Model model)
    {
        Tenant tenant = tenantDao.get(id);

        model.addAttribute("name", Tenant.class.getSimpleName());
        model.addAttribute("value", tenant.getId());
        model.addAttribute("paramm", getAddress(tenant.getAddress().getId()));
        model.addAttribute("paramm2", getSaleStatus(tenant.getPayment().getId()));

        return "mycatalog";
    }

    @RequestMapping(value = "/tenant", method = RequestMethod.GET)
    public String getTenant(Model model)
    {
        List<Tenant> tenants = tenantDao.getAll();
        model.addAttribute("name", "tenant");
        model.addAttribute("values", tenants);
        return "mycatalog";
    }

    @RequestMapping(value = "/price/{id}", method = RequestMethod.GET)
    public String getPrice(@PathVariable Long id, Model model)
    {
        Price price = priceDao.get(id);
        model.addAttribute("name", Price.class.getSimpleName());
        model.addAttribute("value", price.getId());
        model.addAttribute("paramm", price.getTotalPrice() + " $");
        return "mycatalog";
    }

    @RequestMapping(value = "/price", method = RequestMethod.GET)
    public String getPrice(Model model)
    {
        List<Price> prices = priceDao.getAll();
        model.addAttribute("name", "price");
        model.addAttribute("values", prices);
        return "mycatalog";
    }

    @RequestMapping(value = "/deposit/{id}", method = RequestMethod.GET)
    public String getDeposit(@PathVariable Long id, Model model)
    {
        Deposit deposit = depositDao.get(id);
        model.addAttribute("name", Deposit.class.getSimpleName());
        model.addAttribute("value", deposit.getId());
        model.addAttribute("paramm", "From: " + getLandlordAddress(deposit.getLandlord().getId()));
        model.addAttribute("paramm2", "To: " + getTenantdAddress(deposit.getTenant().getId()));
        model.addAttribute("paramm3", "Status: " + getTenantStatus(deposit.getTenant().getId()));
        model.addAttribute("paramm4", " --> " + getLandlordStatus(deposit.getLandlord().getId()));

        return "mycatalog";
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String getDeposit(Model model)
    {
        List<Deposit> deposits = depositDao.getAll();
        model.addAttribute("name", "deposit");
        model.addAttribute("values", deposits);
        return "mycatalog";
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String hello(@PathVariable Long id, Model model)
    {
        Order order = orderDao.get(id);
        Deposit deposit = depositDao.get((long) order.getDeposit().getId());
        model.addAttribute("name", Order.class.getSimpleName());
        model.addAttribute("value", order.getId());
        model.addAttribute("orderName", order.getName());
        model.addAttribute("orderPrice", getOrderPrice(order.getPrice().getId()) + "$");
        model.addAttribute("orderPayment", "--->" + getOrderPayment(order.getPayment().getId()));
        model.addAttribute("landlordAddress", getLandlordAddress(deposit.getLandlord().getId()));
        model.addAttribute("landlordStatus", getLandlordStatus(deposit.getLandlord().getId()));
        model.addAttribute("tenantAddress", getTenantdAddress(deposit.getTenant().getId()));
        model.addAttribute("tenantStatus", getTenantStatus(deposit.getTenant().getId()));
        return "example";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String getOrder(Model model)
    {
        List<Order> orders = orderDao.getAll();
        model.addAttribute("name", "order");
        model.addAttribute("values", orders);
        return "mycatalog";
    }

    private String getAddress(long addressId)
    {
        Address address = addressDao.get(addressId);
        return address.getAddress();
    }

    private String getSaleStatus(long paymentId)
    {
        Payment payment = paymentDao.get(paymentId);
        return payment.getSaleStatus();
    }

    private String getLandlordAddress(long landlordId)
    {
        Landlord landlord = landlordDao.get(landlordId);
        return getAddress(landlord.getAddress().getId());
    }

    private String getTenantdAddress(long tenantId)
    {
        Tenant tenant = tenantDao.get(tenantId);
        return getAddress(tenant.getAddress().getId());
    }

    private String getLandlordStatus(long landlordId)
    {
        Landlord landlord = landlordDao.get(landlordId);
        return getSaleStatus(landlord.getPayment().getId());
    }

    private String getTenantStatus(long tenantId)
    {
        Tenant tenant = tenantDao.get(tenantId);
        return getSaleStatus(tenant.getPayment().getId());
    }

    private double getOrderPrice(long priceId)
    {
        Price price = priceDao.get(priceId);
        return price.getTotalPrice();
    }

    private String getOrderPayment(long paymentId)
    {
        Payment payment = paymentDao.get(paymentId);
        return payment.getSaleStatus();
    }
}
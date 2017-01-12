package com.craft.livingcraft.dao;

import com.craft.livingcraft.model.BillingAddress;
import com.craft.livingcraft.model.ShippingAddress;
import com.craft.livingcraft.model.UserDetails;

public interface UserDetailsDAO 
{
    public void addUserDetails(UserDetails userDetails);
    
    public void saveBillingAddress(BillingAddress billingAddress);
    
    public void saveShippingAddress(ShippingAddress shippingAddress);
} 

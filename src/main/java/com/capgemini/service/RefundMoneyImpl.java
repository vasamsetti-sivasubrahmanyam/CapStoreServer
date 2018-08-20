package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Customer;
import com.capgemini.model.OrderDetails;
import com.capgemini.repository.OrderDetailsRepository;
import com.capgemini.repository.RefundMoneyRepository;

@Service
public class RefundMoneyImpl implements RefundMoney{
	@Autowired
	RefundMoneyRepository repo;
	@Override
	public String refundDisplay(int id) {
		OrderDetails o= repo.refundDisplay(id);
		
		
		String status=o.getStatus().substring(0,8);
		
		
		
		 if(o.getStatus().length()>9)
		{
			return "Refund Successful for partial order with "+o.getStatus();
		}
		 
		 else if(status.equalsIgnoreCase("RETURNED"))	{
				
				return "Refund Successful for whole order";
				
			}	
		
		else if(o.getStatus().equalsIgnoreCase("Delivered")) {
			return "Order Delivered Successfully, But NotReturned yet";
		}
			
		else return "Sorry,Product is not Delivered. You are not Eligible for Refund";

	}

}

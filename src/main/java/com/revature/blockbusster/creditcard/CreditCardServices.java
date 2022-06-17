package com.revature.blockbusster.creditcard;

import com.revature.blockbusster.customer.Customer;
import com.revature.blockbusster.customer.CustomerDao;
import com.revature.blockbusster.order.Order;
import com.revature.blockbusster.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CreditCardServices implements Serviceable<CreditCard> {

    private final CreditCardDao creditCardDao;

    private final CustomerDao customerDao;

    @Autowired
    public CreditCardServices(CreditCardDao creditCardDao, CustomerDao customerDao) {
        this.creditCardDao = creditCardDao;
        this.customerDao = customerDao;
    }

    @Override
    public CreditCard create(CreditCard newCreditCard) {
        return creditCardDao.save(newCreditCard);
    }

    @Override
    public CreditCard update(CreditCard updatedCreditCard) {return creditCardDao.save(updatedCreditCard);}

    @Override
    public CreditCard readById(String ccNumber) {return null;}

    public List<CreditCard> readByEmail(Customer customerEmail) {return  creditCardDao.creditCardHistory(customerEmail);}

    @Override
    public boolean delete(String ccNumber) {
        creditCardDao.deleteById(ccNumber);
        return true;
    }
}

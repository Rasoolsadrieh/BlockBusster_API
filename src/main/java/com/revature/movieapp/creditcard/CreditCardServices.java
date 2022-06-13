package com.revature.movieapp.creditcard;

import com.revature.movieapp.customer.CustomerDao;
import com.revature.movieapp.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<CreditCard> readAll() {
        return (List<CreditCard>) creditCardDao.findAll();}

    @Override
    public CreditCard readById(String cc_number) {return creditCardDao.findById(cc_number).get();}

    @Override
    public CreditCard update(CreditCard updatedCreditCard) {
        return creditCardDao.save(updatedCreditCard);
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(CreditCard object) {
        return false;
    }
}

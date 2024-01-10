package lk.ijse.posbackend.service.custom.Impl;

import lk.ijse.posbackend.entity.Customer;
import lk.ijse.posbackend.service.custom.CustomerService;
import org.hibernate.Session;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public boolean save(Customer customer, Session session) throws Exception {
        session.persist(customer);
        return true;
    }

    @Override
    public boolean Update(Customer customer, Session session) throws Exception {
        session.update(customer);
        return true;
    }

    @Override
    public boolean delete(String id, Session session) throws Exception {

       session.remove(session.get(Customer.class, id));
        return true;
    }
}

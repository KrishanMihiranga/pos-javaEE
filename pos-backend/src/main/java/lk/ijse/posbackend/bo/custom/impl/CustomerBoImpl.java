package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.service.ServiceFactory;
import lk.ijse.posbackend.service.custom.CustomerService;
import lk.ijse.posbackend.service.custom.Impl.CustomerServiceImpl;
import lk.ijse.posbackend.utill.Convert;
import lk.ijse.posbackend.utill.HibernateFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerBoImpl implements CustomerBO {
    private CustomerService customerService= (CustomerServiceImpl) ServiceFactory.getInstance().getService(ServiceFactory.Servicetypes.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        if (customerService.save(Convert.customerDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        if (customerService.Update(Convert.customerDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        if (customerService.delete(id, session)){
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}

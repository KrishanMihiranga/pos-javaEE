package lk.ijse.posbackend.service;

import lk.ijse.posbackend.entity.Customer;
import org.hibernate.Session;

public interface Crud<T> extends SuperService{

    boolean save(T t , Session session) throws Exception;
    boolean Update(T t, Session session) throws Exception;
    boolean delete(String id, Session session) throws Exception;
}

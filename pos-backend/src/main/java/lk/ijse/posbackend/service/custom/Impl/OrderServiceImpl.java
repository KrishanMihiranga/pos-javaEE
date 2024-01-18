package lk.ijse.posbackend.service.custom.Impl;

import lk.ijse.posbackend.entity.Item;
import lk.ijse.posbackend.entity.OrderEntity;
import lk.ijse.posbackend.service.custom.OrderService;
import org.hibernate.Session;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderEntity> getAll(Session session) throws Exception {
        return session.createQuery("FROM OrderEntity", OrderEntity.class).getResultList();
    }

    @Override
    public boolean save(OrderEntity orderEntity, Session session) throws Exception {
        session.persist(orderEntity);
        return true;
    }

    @Override
    public boolean Update(OrderEntity orderEntity, Session session) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id, Session session) throws Exception {
        return false;
    }
}

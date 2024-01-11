package lk.ijse.posbackend.service.custom.Impl;

import lk.ijse.posbackend.entity.Item;
import lk.ijse.posbackend.service.custom.ItemService;
import org.hibernate.Session;

public class ItemServiceImpl implements ItemService {

    @Override
    public boolean save(Item item, Session session) throws Exception {
        session.persist(item);
        return true;
    }

    @Override
    public boolean Update(Item item, Session session) throws Exception {
        session.update(item);
        return true;
    }

    @Override
    public boolean delete(String id, Session session) throws Exception {
        session.remove(session.get(Item.class, id));
        return true;
    }
}

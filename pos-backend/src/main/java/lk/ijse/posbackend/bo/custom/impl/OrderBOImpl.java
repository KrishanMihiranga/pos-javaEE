package lk.ijse.posbackend.bo.custom.impl;

import lk.ijse.posbackend.bo.custom.OrderBO;
import lk.ijse.posbackend.dto.OrderDTO;
import lk.ijse.posbackend.service.ServiceFactory;
import lk.ijse.posbackend.service.custom.OrderService;
import lk.ijse.posbackend.utill.Convert;
import lk.ijse.posbackend.utill.HibernateFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderBOImpl implements OrderBO {
    private OrderService orderService = (OrderService) ServiceFactory.getInstance().getService(ServiceFactory.Servicetypes.ORDER);

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        Session session = HibernateFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        if (orderService.save(Convert.orderDetailDTOToEntity(dto), session)){
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }
}

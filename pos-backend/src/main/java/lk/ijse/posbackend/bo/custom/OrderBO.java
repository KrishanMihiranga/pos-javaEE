package lk.ijse.posbackend.bo.custom;

import lk.ijse.posbackend.bo.SuperBO;
import lk.ijse.posbackend.dto.OrderDTO;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDTO dto) throws Exception;
}

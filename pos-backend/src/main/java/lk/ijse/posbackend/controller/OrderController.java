package lk.ijse.posbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.BOFactory;
import lk.ijse.posbackend.bo.custom.OrderBO;
import lk.ijse.posbackend.dto.OrderDTO;

import java.io.IOException;

@WebServlet(name = "Order", urlPatterns = "/order", loadOnStartup = 3)
public class OrderController extends HttpServlet {
    private OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBo(BOFactory.BOTypes.ORDER);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        OrderDTO orderDTO = mapper.readValue(req.getInputStream(), OrderDTO.class);
        System.out.println(orderDTO);
        System.out.println(orderDTO.getId());

        try {
            if(orderBO.saveOrder(orderDTO)){
                resp.getWriter().write("Order Saved");
            }else{
                resp.getWriter().write("Error while saving order");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init order");


    }
}

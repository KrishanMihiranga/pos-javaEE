package lk.ijse.posbackend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.posbackend.bo.BOFactory;
import lk.ijse.posbackend.bo.custom.CustomerBO;
import lk.ijse.posbackend.bo.custom.impl.CustomerBoImpl;
import lk.ijse.posbackend.dto.CustomerDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Customer", urlPatterns = "/customer", loadOnStartup = 4)
public class CustomerController extends HttpServlet {

    private CustomerBO customerBO = (CustomerBoImpl) BOFactory.getInstance().getBo(BOFactory.BOTypes.CUSTOMER);

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init Customer Controller");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do Get");
        try{
            List<CustomerDTO> customers = customerBO.getAllCustomers();
            System.out.println(customers);
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonCustomers = objectMapper.writeValueAsString(customers);

            resp.setContentType("application/json");
            resp.getWriter().write(jsonCustomers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDTO customer = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        System.out.println(customer);

        try {
            if (customerBO.saveCustomer(customer)){
                resp.getWriter().write("Customer Saved");
            }else{
                resp.getWriter().write("Error while saving Customer");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        CustomerDTO customer = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        System.out.println(customer);

        try {
            if (customerBO.updateCustomer(customer)){
                resp.getWriter().write("Customer Updated");
            }else{
                resp.getWriter().write("Error while updating Customer");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(req.getReader());

            String id = jsonNode.get("id").asText();

            if (customerBO.deleteCustomer(id)) {
                resp.getWriter().write("Customer Deleted");
            } else {
                resp.getWriter().write("Error while deleting Customer");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }


}

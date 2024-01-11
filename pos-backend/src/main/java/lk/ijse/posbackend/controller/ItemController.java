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
import lk.ijse.posbackend.bo.custom.ItemBO;
import lk.ijse.posbackend.bo.custom.impl.ItemBoImpl;
import lk.ijse.posbackend.dto.ItemDTO;

import java.io.IOException;

@WebServlet(name = "Item", urlPatterns = "/item", loadOnStartup = 3)
public class ItemController extends HttpServlet {
    private ItemBO itemBO = (ItemBoImpl) BOFactory.getInstance().getBo(BOFactory.BOTypes.ITEM);

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init Item Controller");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ItemDTO item = mapper.readValue(req.getInputStream(), ItemDTO.class);
        System.out.println(item);

        try {
            if (itemBO.updateItem(item)){
                resp.getWriter().write("Item Updated");
            }else{
                resp.getWriter().write("Error while updating Item");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        ItemDTO item = mapper.readValue(req.getInputStream(), ItemDTO.class);
        System.out.println(item);

        try {
            if (itemBO.saveItem(item)){
                resp.getWriter().write("Item Saved");
            }else{
                resp.getWriter().write("Error while saving Item");
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

            if (itemBO.deleteItem(id)) {
                resp.getWriter().write("Item Deleted");
            } else {
                resp.getWriter().write("Error while deleting Item");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error");
        }
    }
}

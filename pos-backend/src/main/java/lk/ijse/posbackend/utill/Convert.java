package lk.ijse.posbackend.utill;

import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.dto.ItemDTO;
import lk.ijse.posbackend.entity.Customer;
import lk.ijse.posbackend.entity.Item;


public class Convert {

    public static Customer customerDTOToEntity(CustomerDTO dto){
        return new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
    }
    public static CustomerDTO customerEntityToDto(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }
    public static Item itemDTOToEntity(ItemDTO dto){
        return new Item(dto.getId(), dto.getName(), dto.getPrice(), dto.getQty());
    }
    public static ItemDTO itemEntityToDto(Item item){
        return new ItemDTO(item.getId(), item.getName(), item.getPrice(), item.getQty());
    }
}

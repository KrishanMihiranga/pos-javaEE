package lk.ijse.posbackend.utill;

import lk.ijse.posbackend.dto.CustomerDTO;
import lk.ijse.posbackend.entity.Customer;


public class Convert {

    public static Customer customerDTOToEntity(CustomerDTO dto){
        return new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary());
    }
    public static CustomerDTO customerEntityToDto(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

}

package lk.ijse.posbackend.dto;

import jakarta.persistence.*;
import lk.ijse.posbackend.entity.Customer;
import lk.ijse.posbackend.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String id;
    private LocalDate date;
    private CustomerDTO customer;
    private List<ItemDTO> items;
    private double discount;
    private double total;
}

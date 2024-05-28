package gityeong.financeProject.customer.dao;

import gityeong.financeProject.customer.dto.CustomerDTO;
import gityeong.financeProject.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "customers")
public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    default CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setAccNo(customer.getAccNo());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setAddress(customer.getAddress());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNo(customer.getPhoneNo());
        return dto;
    }
}

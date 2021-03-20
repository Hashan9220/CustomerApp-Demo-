package lk.Demo.src.bo.custom.impl;

import lk.Demo.src.bo.custom.CustomerBO;
import lk.Demo.src.dao.DAOFactory;
import lk.Demo.src.dao.custom.CustomerDAO;
import lk.Demo.src.dto.CustomerDTO;
import lk.Demo.src.entity.customer;

import java.util.ArrayList;

public class CustomerBOimpl implements CustomerBO {
    CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws Exception {
        return dao.add(new customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getContact(),customerDTO.getEmail(),customerDTO.getAddress()));
      }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return dao.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO c) throws Exception {
        return dao.update(new customer(c.getId(),c.getName(),c.getContact(),c.getEmail(),c.getAddress()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        customer search = dao.search(id);
        return new CustomerDTO(search.getCutomer_id(),search.getName(),search.getContact(),search.getEmail(),search.getAddress());
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws Exception {
        ArrayList<customer> all = dao.getAll();
        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        for (customer customer : all) {
            customerList.add(new CustomerDTO(customer.getCutomer_id(),customer.getName(),customer.getContact(),customer.getEmail(),customer.getAddress()));
        }
        return customerList;
    }
}

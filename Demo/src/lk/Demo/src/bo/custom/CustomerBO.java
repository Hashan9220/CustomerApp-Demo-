package lk.Demo.src.bo.custom;

import lk.Demo.src.bo.SuperBO;
import lk.Demo.src.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {

    public boolean addCustomer(CustomerDTO customerDTO)throws Exception;

    public boolean deleteCustomer(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO dto)throws Exception;

    public CustomerDTO searchCustomer(String id)throws Exception;

    public ArrayList<CustomerDTO>getAllCustomer()throws Exception;


}

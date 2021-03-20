package lk.Demo.src.dao.custom.impl;

import lk.Demo.src.dao.CrudUtil;
import lk.Demo.src.dao.custom.CustomerDAO;
import lk.Demo.src.entity.customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {


    @Override
    public boolean add(customer customer) throws Exception {
        String sql = "insert into customer values (?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, customer.getCutomer_id(), customer.getName(), customer.getContact(), customer.getEmail(), customer.getAddress());

    }

    @Override
    public boolean delete(String s) throws Exception {
        String sql = "delete from customer where cutomer_id=?";
        return CrudUtil.executeUpdate(sql, s);
    }

    @Override
    public boolean update(customer customer) throws Exception {
        String sql = "Update customer set name=?,contact=?,email=?,address=? where cutomer_id=?";
        return CrudUtil.executeUpdate(sql, customer.getName(), customer.getContact(), customer.getEmail(), customer.getAddress(), customer.getCutomer_id());
    }

    @Override
    public customer search(String s) throws Exception {
        String sql = "SELECT * FROM customer WHERE cutomer_id=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, s);
        if (resultSet.next()) {
            return new customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;
    }

    @Override
    public ArrayList<customer> getAll() throws Exception {
        String sql = "SELECT * FROM customer";
        ResultSet resultSet = CrudUtil.executeQuery(sql);
        ArrayList<customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            customerList.add(
                    new customer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    ));
        }
        return customerList;
    }
}

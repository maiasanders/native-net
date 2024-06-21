package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class JdbcCustomerDao implements CustomerDao {

    private final JdbcTemplate template;
    private final String SQL_SELECT = "SELECT * FROM customer ";

    public JdbcCustomerDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> getCustomers() {
        return template.query(SQL_SELECT, this:: mapRowToCustomer);
    }

    @Override
    public Customer getCustomerById(int id) {
        try {
            return template.queryForObject(SQL_SELECT + "WHERE id = ?;", this::mapRowToCustomer, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Customer createCustomer(Customer customer) {
        // TODO
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO
        return null;
    }

    private Customer mapRowToCustomer(ResultSet row, int rowNum) throws SQLException {
        Customer customer =new Customer();
        // TODO mapping function
        customer.setCustomerId(row.getInt("customer_id"));
        customer.setName(row.getString("name"));
        customer.setPhone(row.getString("phone"));
        customer.setEmail(row.getString("email"));
        customer.setAddress1(row.getString("address_1"));
        customer.setAddress2(row.getString("address_2"));
        customer.setCity(row.getString("city"));
        customer.setState(row.getString("state"));
        customer.setZip(row.getString("zip"));
        return customer;
    }
}

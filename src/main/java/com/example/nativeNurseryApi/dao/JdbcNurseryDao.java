package com.example.nativeNurseryApi.dao;

import com.example.nativeNurseryApi.model.Nursery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Component
public class JdbcNurseryDao implements NurseryDao {
    private JdbcTemplate template;
    private final String SQL_SELECT = "SELECT * FROM nursery ";
    public JdbcNurseryDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Nursery> getNurseriesWithStoreFrontAndShippingByName(String name) {
        return template.query(SQL_SELECT +
                "WHERE has_storefront AND has_shipping AND name ILIKE ?;",
                this::mapToNursery, wildcard(name));
    }

    @Override
    public List<Nursery> getNurseriesWithStorefrontAndShipping() {
        return template.query(SQL_SELECT + "WHERE has_storefront AND has_shipping;",
                this::mapToNursery);
    }

    @Override
    public List<Nursery> getNurseriesWithStorefrontByName(String name) {
        return template.query(SQL_SELECT + "WHERE has_storefront AND nursery_name ILIKE ?",
                this::mapToNursery, wildcard(name));
    }

    @Override
    public List<Nursery> getNurseriesShipByName(String name) {
        return template.query(SQL_SELECT + "WHERE has_shipping AND name ILIKE ?;",
                this::mapToNursery, wildcard(name));
    }

    @Override
    public List<Nursery> getNurseriesWithStorefront() {
        return template.query(SQL_SELECT + "WHERE has_storefront;", this::mapToNursery);
    }

    @Override
    public List<Nursery> getNurseriesShips() {
        return template.query(SQL_SELECT + "WHERE has_shipping;", this::mapToNursery);
    }

    @Override
    public List<Nursery> getNurseriesByName(String name) {
        return template.query(SQL_SELECT + "WHERE name ILIKE ?;",
                this::mapToNursery, wildcard(name));
    }

    @Override
    public List<Nursery> getNurseries() {
        return template.query(SQL_SELECT, this::mapToNursery);
    }

    @Override
    public Nursery getNurseryById(int id) {
        try {
            return template.queryForObject(SQL_SELECT + "WHERE nursery_id = ?",
                    this::mapToNursery, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Nursery createNursery(Nursery nursery) {
        // TODO
        return null;
    }

    @Override
    public Nursery updateNursery(Nursery nursery) {
        // TODO
        return null;
    }

    @Override
    public void deleteNurseryById(int id) {
        // TODO
    }
    private String wildcard(String query) {
        return "%" + query + "%";
    }

    private Nursery mapToNursery(ResultSet set, int rowNum) throws SQLException {
        Nursery nursery = new Nursery();
        nursery.setNurseryId(set.getInt("nursery_id"));
        nursery.setName(set.getString("nursery_name"));
        nursery.setWebsite(set.getString("website"));
        nursery.setPhoneNumber(set.getString("phone"));
        nursery.setPrimaryContact(set.getString("primary_contact"));
        nursery.setHasStorefront(set.getBoolean("has_storefront"));
        nursery.setShips(set.getBoolean("has_shipping"));
        return nursery;
    }
}

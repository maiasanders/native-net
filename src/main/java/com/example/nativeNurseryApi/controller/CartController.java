package com.example.nativeNurseryApi.controller;

import com.example.nativeNurseryApi.dao.SaleDao;
import com.example.nativeNurseryApi.model.Sale;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/carts/")
public class CartController {

    // TODO create class(es) and implement controller handler methods
    private SaleDao dao;

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Sale get(@PathVariable int id) {
        return dao.getCartById(id);
    }

    @RequestMapping(path = "nurseries/{id}", method = RequestMethod.GET)
    public List<Sale> listSalesByNursery(@PathVariable int id) {
        return dao.getOrdersByNursery(id);
    }

    @RequestMapping(path = "customers/{id}", method = RequestMethod.GET)
    public List<Sale> listSalesForCustomer(@PathVariable int id) {
        return dao.getOrderByCustomer(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Sale add(@Valid @RequestBody Sale sale) {
        return dao.createOrder(sale);
    }
    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Sale update(@PathVariable int id, @Valid @RequestBody Sale sale) {
        return dao.updateOrder(sale);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        dao.deleteOrderById(id);
    }
}
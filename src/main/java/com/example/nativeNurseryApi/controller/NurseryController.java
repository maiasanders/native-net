package com.example.nativeNurseryApi.controller;

import com.example.nativeNurseryApi.dao.NurseryDao;
import com.example.nativeNurseryApi.exception.DaoException;
import com.example.nativeNurseryApi.model.Nursery;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController("/nurseries/")
public class NurseryController {

    private NurseryDao dao;

    public NurseryController(NurseryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Nursery> list(@RequestParam(required = false) boolean hasStorefront,
                              @RequestParam(required = false) boolean ships,
                              @RequestParam(defaultValue = "") String name) {
        if (hasStorefront && ships && !name.isEmpty()) {
            return dao.getNurseriesWithStoreFrontAndShippingByName(name);
        } else if (hasStorefront && ships) {
            return dao.getNurseriesWithStorefrontAndShipping();
        } else if (hasStorefront && !name.isEmpty()) {
            return dao.getNurseriesWithStorefrontByName(name);
        } else if (ships && !name.isEmpty()) {
            return dao.getNurseriesShipByName(name);
        } else if (hasStorefront) {
            return dao.getNurseriesWithStorefront();
        } else if (ships) {
            return dao.getNurseriesShips();
        } else if (!name.isEmpty()) {
            return dao.getNurseriesByName(name);
        } else {
            return dao.getNurseries();
        }
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Nursery get(@PathVariable int id) {
        return dao.getNurseryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public Nursery add(@Valid @RequestBody Nursery nursery) {
        return dao.createNursery(nursery);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Nursery update(@PathVariable int id, @Valid @RequestBody Nursery nursery) {
        try {
            return dao.updateNursery(nursery);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nursery not found");
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        try {
            dao.deleteNurseryById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nursery not found");
        }
    }
}

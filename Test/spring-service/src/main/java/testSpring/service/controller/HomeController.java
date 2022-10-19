package testSpring.service.controller;

import org.springframework.web.bind.annotation.RequestParam;
import testSpring.service.dao.DerivativeDAO;
import testSpring.service.model.Data;
import testSpring.service.model.Derivative;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private static Logger lg = Logger.getLogger(HomeController.class);

    @Autowired
    DerivativeDAO derivativeDAO;


    @RequestMapping(value = "/hai/derivative", method = RequestMethod.GET)
    public Data list(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
            @RequestParam(value = "sort", required = false)String sort,
            @RequestParam(value = "q",required = false)String q
    ) {
        Data data = new Data();
        data.setCurrentPage(page);
        data.setSize(size);
        data.setData(derivativeDAO.list(page,size,sort,q));
        return data;
    }
}

package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.Sale;
import com.example.demo.mvc.service.SaleService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Transactional
    @PostMapping (value = "")
    public void add (@RequestBody Sale sale ) throws Exception {
        saleService.add(sale);
    }

    @GetMapping (value = "/{id}")
    public Sale view (@PathVariable int id) throws Exception {
        return saleService.view(id);
    }

    @GetMapping ( value = "" )
    public List<Sale> viewAll () throws Exception {
        return saleService.viewAll();
    }
}

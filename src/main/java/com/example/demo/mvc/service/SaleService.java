package com.example.demo.mvc.service;

import com.example.demo.mvc.model.Sale;
import com.example.demo.mvc.repository.SaleRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final Logger LOGGER =  LoggerFactory.getLogger(this.getClass());

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Transactional
//    @Loggable
    public void add (Sale sale) throws Exception {

        Optional<Sale> oldSale = saleRepository.findById(sale.getId());
        if (oldSale.isPresent()) {
            LOGGER.info("throwing exception");
            throw new Exception("already there my friend");
        }
        else {
            saleRepository.saveAndFlush(sale);
            LOGGER.info("successful adding");
        }

    }

    public Sale view (int id) throws Exception {
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent())
            return sale.get();
        else
            throw new NotFoundException("No Such sale in our Database");
    }

    public List<Sale> viewAll() throws Exception {
        return saleRepository.findAll();
    }
}

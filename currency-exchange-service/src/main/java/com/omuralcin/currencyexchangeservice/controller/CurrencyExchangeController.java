package com.omuralcin.currencyexchangeservice.controller;

import com.omuralcin.currencyexchangeservice.bean.CurrencyExchange;
import com.omuralcin.currencyexchangeservice.repository.CurrnecyExchangeRepository;
import com.omuralcin.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController
{
    private final CurrencyExchangeService currencyExchangeService;
    private final Environment environment;
    private final CurrnecyExchangeRepository currnecyExchangeRepository;
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService, Environment environment, CurrnecyExchangeRepository currnecyExchangeRepository) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
        this.currnecyExchangeRepository = currnecyExchangeRepository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to){
        //CurrencyExchange currencyExchange =  new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));

        CurrencyExchange currencyExchange =  currnecyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange ==null){
            throw new RuntimeException("Unable to find data for "+from+" to "+to);
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}

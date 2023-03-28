package com.omuralcin.currencyexchangeservice.repository;

import com.omuralcin.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrnecyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

   CurrencyExchange findByFromAndTo(String from,String to);
}

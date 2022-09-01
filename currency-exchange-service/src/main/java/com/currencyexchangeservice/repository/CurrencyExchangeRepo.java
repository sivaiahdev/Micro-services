package com.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currencyexchangeservice.model.CurrencyExchange;
@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}

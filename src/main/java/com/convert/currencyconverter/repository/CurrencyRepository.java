package com.convert.currencyconverter.repository;

import com.convert.currencyconverter.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {
    //@Override
    List<Currency> findAllByOrderByNameAsc();
}

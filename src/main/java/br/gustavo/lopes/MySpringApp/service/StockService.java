package br.gustavo.lopes.MySpringApp.service;

import br.gustavo.lopes.MySpringApp.model.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    Stock findById(long id);
    List<Stock> findAll();
    List<Stock> findAllByUserId(long id);
    Stock edit(Stock stock);
    Stock editById(long id, Stock stock);
    void delete(long id);
}

package br.gustavo.lopes.MySpringApp.service.impl;

import br.gustavo.lopes.MySpringApp.model.Stock;
import br.gustavo.lopes.MySpringApp.repository.StockRepository;
import br.gustavo.lopes.MySpringApp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock findById(long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public List<Stock> findAllByUserId(long id) {
        return stockRepository.findAllByUserId(id);
    }

    @Override
    public Stock edit(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock editById(long id, Stock user) {
        Stock stockToEdit = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
        stockToEdit.setName(user.getName());
        stockToEdit.setPrice(user.getPrice());
        stockToEdit.setDescription(user.getDescription());
        stockToEdit.setQuantity(user.getQuantity());
        return stockRepository.save(stockToEdit);
    }

    @Override
    public void delete(long id) {
        stockRepository.deleteById(id);
    }
}

package br.gustavo.lopes.MySpringApp.repository;

import br.gustavo.lopes.MySpringApp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT s FROM Stock s WHERE s.user.id = ?1")
    List<Stock> findAllByUserId(long id);
}

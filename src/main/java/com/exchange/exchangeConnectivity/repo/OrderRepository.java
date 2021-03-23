package com.exchange.exchangeConnectivity.repo;

import com.exchange.exchangeConnectivity.model.OrderInfo;
import com.exchange.exchangeConnectivity.model.clientOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<clientOrder, Integer> {



}
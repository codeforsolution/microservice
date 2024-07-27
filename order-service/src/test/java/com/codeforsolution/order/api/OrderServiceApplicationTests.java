package com.codeforsolution.order.api;

import com.codeforsolution.order.api.model.Order;
import com.codeforsolution.order.api.repository.OrderRepository;
import com.codeforsolution.order.api.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceApplicationTests {

	@Autowired
	private OrderService orderService;

	@MockBean
	private OrderRepository orderRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void getOrdersTest(){
		when(orderRepository.findAll()).thenReturn(Stream.of(new Order(1L, "order1",2,123.00),
				new Order(2L, "order2",2,128.00)).collect(Collectors.toList()));
		assertEquals(2,orderService.getOrders().size());
	}

	@Test
	public void getOrderById(){
		Long orderId = 2L;
		when(orderRepository.findById(orderId)).thenReturn(Optional.ofNullable(Stream.of(new Order(1L, "Spring in Action", 12, 123.00)).collect(Collectors.toList()).getFirst()));
		assertEquals(1, orderService.getOrdersById(orderId).stream().count());
	}
}

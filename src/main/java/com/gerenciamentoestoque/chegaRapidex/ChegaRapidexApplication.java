package com.gerenciamentoestoque.chegaRapidex;

import com.gerenciamentoestoque.chegaRapidex.entities.*;
import com.gerenciamentoestoque.chegaRapidex.repositories.*;
import com.gerenciamentoestoque.chegaRapidex.service.SequenceGeneratorService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class ChegaRapidexApplication implements CommandLineRunner
{
	@Autowired
	UserRepository userRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	RecipientRepository recipientRepository;

	@Autowired
	SenderRepository senderRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SequenceGeneratorService service;



	@Autowired
	public static void main(String[] args)
	{
		SpringApplication.run(ChegaRapidexApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception
	{
		createUserSystem();

		Order order = new Order();
		order.setOrderId(1L);
		order.setOrderDate(new Date());
		order.setOrderTotalValue(100F);
		order.setOrderTotalWeight(100);
		order.setRecipient(createRecipientSystem());
		order.setProducts(List.of(createProductSystem()));
		order.setSender(createSenderSystem());
		order.setOrderStatus(createOrderStatusSystem());

		orderRepository.save(order);
	}

	private OrderStatus createOrderStatusSystem()
	{
		OrderStatus status = new OrderStatus();
		status.setOrderStatusId(1L);
		status.setDescriptionStatus("TESTE");

		return status;
	}

	private Product createProductSystem()
	{
		Product product = new Product();
		product.setProductId(1l);
		product.setProductName("Iphone");
		product.setProductValue(200f);
		product.setProductWeight(20);

		productRepository.save(product);

		return product;
	}

	private Recipient createRecipientSystem()
	{
		Recipient recipient = new Recipient();
		recipient.setRecipientId(1L);
		recipient.setCpf("12456747909");
		recipient.setRg("123456");
		recipient.setRecipientName("Eduardo");
		recipient.setAddressRecipient(createAddressSystem());

		recipientRepository.save(recipient);

		return recipient;
	}

	private Address createAddressSystem()
	{
		Address address = new Address();
		address.setAddressId(1L);
		address.setCity("Joinville");
		address.setRoad("Rua Teste");
		address.setNumber(202);

		return address;
	}

	private Sender createSenderSystem()
	{
		Sender sender = new Sender();
		sender.setSenderId(1L);
		sender.setCpf("12456747909");
		sender.setRg("123456");
		sender.setSenderName("Matheus");
		sender.setAddressSender(createAddressSystem());

		senderRepository.save(sender);

		return sender;
	}


	private void createUserSystem()
	{
		User user = new User();
		user.setUserId(1L);
		user.setFullname("Administrador");
		user.setUsername("admin");
		user.setPassword("123");

		userRepository.save(user);

		Optional<User> storedUsers = userRepository.findById(1L);
		System.out.println(storedUsers.get().getUserId());
	}
}

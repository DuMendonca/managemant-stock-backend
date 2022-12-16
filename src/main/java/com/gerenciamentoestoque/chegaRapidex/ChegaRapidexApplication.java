package com.gerenciamentoestoque.chegaRapidex;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import com.gerenciamentoestoque.chegaRapidex.entities.ProductsRequests;
import com.gerenciamentoestoque.chegaRapidex.entities.Request;
import com.gerenciamentoestoque.chegaRapidex.repositories.*;
import com.gerenciamentoestoque.chegaRapidex.repositories.DAL.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ChegaRapidexApplication implements CommandLineRunner {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private RecipientRepository recipientRepository;
	@Autowired
	private RequestStatusRepository requestStatusRepository;
	@Autowired
	private SenderRepository senderRepository;
	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private ProductsRequestsRepository productsRequestsRepository;


	//DAL
	@Autowired
	private ProductDAL productDAL;
	@Autowired
	private RequestDAL requestDAL;
	@Autowired
	private RequestStatusDAL requestStatusDAL;
	@Autowired
	private SenderDAL senderDAL;
	@Autowired
	private RecipientDAL recipientDAL;
	@Autowired
	private AddressDAL addressDAL;


	private Scanner sc = new Scanner(System.in);
	private int opcaoMenu = 0;

    @Autowired

	public static void main(String[] args) {
		SpringApplication.run(ChegaRapidexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{


		while (opcaoMenu != 9)
		{
			System.out.println("-------------------------------------------");
			System.out.println("1 - Gerenciamento de Pedidos");
			System.out.println("2 - Gerenciamento de Produtos");
			System.out.println("3 - Visualização de Destinatario");
			System.out.println("4 - Visualização de Endereço");
			System.out.println("5 - Visualização de Rementente");
			System.out.println("6 - Visualização de Status do Pedido");
			System.out.println("7 - Relatório de Pedidos");
			System.out.println("8 - Relatório de Produtos ");
			System.out.println("9 - Sair");
			System.out.println("-------------------------------------------");
			System.out.print("Selecione a opção desejada: ");
			opcaoMenu = sc.nextInt();

			if (opcaoMenu > 0  && opcaoMenu <= 2)
			{
				System.out.println("---------------------");
				System.out.println("1 - Inserir");
				System.out.println("2 - Alterar");
				System.out.println("3 - Deletar");
				System.out.println("---------------------");
				System.out.print("Selecione a opção desejada: ");
				int opcao = sc.nextInt();

				switch (opcao)
				{
					case 1:
						insertValue();
						break;
					case 2:
						updateValue();
						break;
					case 3:
						deleteValue();
						break;
					default:
						System.out.println("Opção inválida! Selecione uma opção valida!");
						break;
				}
			}

			if (opcaoMenu > 2 && opcaoMenu < 9)
			{
				switch (opcaoMenu)
				{
					case 3:
						findAllRecipeient();
						break;
					case 4:
						findAllAddress();
						break;
					case 5:
						findAllSender();
						break;
					case 6:
						findAllRequestStatus();
						break;
					case 7:
						findAllRequest();
						break;
					case 8:
						findAllProduct();
						break;
					default:
						System.out.println("Opção inválida! Selecione uma opção valida!");
						break;
				}
			}

			if (opcaoMenu < 0 && opcaoMenu > 9)
			{
				System.out.println("Opção inválida! Selecione uma opção valida!");
			}
		}

		System.out.println("Operação encerrada!");
	}

	private void deleteValue()
	{
		System.out.println("Digite um Id para ser deletado: ");
		long idToDelete = sc.nextLong();

		switch (opcaoMenu)
		{
			case 1:
				requestDAL.deleteRequestById(idToDelete);
				break;
			case 2:
				productDAL.deleteProductById(idToDelete);
				break;
			default:
				System.out.println("Opção inválida! Selecione uma opção valida!");
				break;
		}

		System.out.println("ID deletado com sucesso!");
	}

	private void updateValue()
	{
		System.out.println("Digite um Id para ser alterado: ");
		long idtoUpdate = sc.nextLong();

		switch (opcaoMenu)
		{
			case 1:
				updateRequest(idtoUpdate);
				break;
			case 2:
				updateProduct(idtoUpdate);
				break;
			default:
				System.out.println("Opção inválida! Selecione uma opção valida!");
				break;
		}

		System.out.println("ID alterado com sucesso!");
	}

	private void insertValue()
	{
		switch (opcaoMenu)
		{
			case 1:
				insertRequest();
				System.out.println("Pedido inserido com sucesso!");
				break;
			case 2:
				insertProduct();
				System.out.println("Produto inserido com sucesso!");
				break;
			default:
				System.out.println("Opção inválida! Selecione uma opção valida!");
				break;
		}
	}

	// Insert Values
	private void insertRequest()
	{
		Request request = new Request();

		System.out.println("Insira o ID do pedido: ");
		request.setRequestId(sc.nextLong());
		System.out.println("Insira o valor total do pedido: ");
		request.setRequestTotalValue(sc.nextFloat());
		System.out.println("Insira o peso total do pedido: ");
		request.setRequestTotalWeight(sc.nextInt());
		System.out.println("Insira o Id do Status do Pedido: ");
		request.setRequestStatus(requestStatusDAL.findRequestStatusById(sc.nextLong()));
		System.out.println("Insira o Id do Destinátario: ");
		request.setRecipient(recipientDAL.findRecipientById(sc.nextLong()));
		System.out.println("Insira o Id do Remetente: ");
		request.setSender(senderDAL.findSenderById(sc.nextLong()));
		request.setRequestDate(new Date(new java.util.Date().getTime()));

		List<Product> productList = new ArrayList<>();

		System.out.println("Adicione o produto no pedido: ");
		boolean exit = false;
		while (!exit)
		{
			System.out.println("Selecione o Id do produto: ");
			productList.add(productDAL.findProductById(sc.nextLong()));
			System.out.println("Deseja adicionar mais produtos ? (1 - SIM | 0 - NÃO)");
			int opcao = sc.nextInt();
			if (opcao == 0)
			{
				exit = true;
			}
		}
		request.setProducts(productList);

		requestRepository.save(request);
	}

	private void insertProduct()
	{
		Product product = new Product();

		System.out.println("Insira o ID do produto: ");
		product.setProductId(sc.nextLong());
		sc.nextLine();
		System.out.println("Insira o nome do produto: ");
		product.setProductName(sc.nextLine());
		System.out.println("Insira o valor do produto: ");
		product.setProductValue(sc.nextFloat());
		System.out.println("Insira o peso do produto: ");
		product.setProductWeight(sc.nextInt());

		productRepository.save(product);
	}

	// Update Values
	private void updateRequest(long id)
	{
		Request request = new Request();

		System.out.println("Insira o valor total do pedido a ser alterado: ");
		request.setRequestTotalValue(sc.nextFloat());
		System.out.println("Insira o peso total do pedido a ser alterado: ");
		request.setRequestTotalWeight(sc.nextInt());
		System.out.println("Insira o Id do Status do Pedido  a ser alterado: ");
		request.setRequestStatus(requestStatusDAL.findRequestStatusById(sc.nextLong()));
		System.out.println("Insira o Id do Destinátario a ser alterado: ");
		request.setRecipient(recipientDAL.findRecipientById(sc.nextLong()));
		System.out.println("Insira o Id do Remetente aser alterado: ");
		request.setSender(senderDAL.findSenderById(sc.nextLong()));

		requestDAL.updateRequestById(request, id);
	}

	private void updateProduct(long id)
	{
		Product product = new Product();
		sc.nextLine();

		System.out.println("Insira o nome do produto a ser alterado: ");
		product.setProductName(sc.nextLine());
		System.out.println("Insira o valor do produto a ser alterado: ");
		product.setProductValue(sc.nextFloat());
		System.out.println("Insira o peso do produto a ser alterado: ");
		product.setProductWeight(sc.nextInt());

		productDAL.updateProductById(product, id);
	}

	// Find Values
	private void findAllAddress()
	{
		AtomicInteger index = new AtomicInteger();

		addressRepository.findAll().forEach((address)-> {
			index.getAndIncrement();
			System.out.print("\n");
			System.out.println("Endereço " + index);
			System.out.println("Id: " + address.getAddressId());
			System.out.println("Cidade: " + address.getCity());
			System.out.println("Rua: " + address.getRoad());
			System.out.println("Número: " + address.getNumber());
		});
	}

	private void findAllRecipeient()
	{
		AtomicInteger index = new AtomicInteger();

		recipientRepository.findAll().forEach((recipient)-> {
			index.getAndIncrement();
			System.out.print("\n");
			System.out.println("Destinatario " + index);
			System.out.println("Nome: " + recipient.getRecipientName());
			System.out.println("Cpf: " + recipient.getCpf());
			System.out.println("Rg: "+ recipient.getRg());
			System.out.println("Id: "+ recipient.getRecipientId());
			System.out.println("Data de Nascimento: "+ recipient.getRecipientBirthDate());
			System.out.println("Endereço : " + recipient.getAddressRecipient().getAddressId());
		});
	}

	private void findAllProduct()
	{
		AtomicInteger index = new AtomicInteger();

		productRepository.findAll().forEach((product)-> {
			index.getAndIncrement();
			System.out.print("\n");
			System.out.println("Produto " + index);
			System.out.println("Id: " + product.getProductId());
			System.out.println("Nome: " + product.getProductName());
			System.out.println("Valor: " + product.getProductValue());
			System.out.println("Peso: " + product.getProductWeight());
		});
	}

	private void findAllSender()
	{
		AtomicInteger index = new AtomicInteger();

		senderRepository.findAll().forEach((sender)-> {
			index.getAndIncrement();
			System.out.print("\n");
			System.out.println("Remetente " + index);
			System.out.println("Nome: " + sender.getSenderName());
			System.out.println("Cpf: " + sender.getCpf());
			System.out.println("Rg: "+ sender.getRg());
			System.out.println("Id: "+ sender.getSenderId());
			System.out.println("Data de Nascimento: "+ sender.getSenderBirthDate());
			System.out.println("Endereço : " + sender.getAddressSender().getAddressId());
		});
	}

	private void findAllRequestStatus()
	{
		AtomicInteger index = new AtomicInteger();

		requestStatusRepository.findAll().forEach((status)-> {
			index.getAndIncrement();
			System.out.print("\n");
			System.out.println("Status de Pedidos " + index);
			System.out.println("Id: " + status.getRequestStatusId());
			System.out.println("Descrição: " + status.getDescriptionStatus());
		});
	}

	private void findAllRequest()
	{
		AtomicInteger index = new AtomicInteger();
		AtomicInteger quanityProducts = new AtomicInteger();

		requestRepository.findAll().forEach((request)-> {
			index.getAndIncrement();
			quanityProducts.set(0);

			System.out.print("\n");
			System.out.println("Pedido " + index);
			System.out.println("Id: " + request.getRequestId());
			System.out.println("Data do Pedido: " + request.getRequestDate());
			System.out.println("Status do Pedido: " + request.getRequestStatus().getDescriptionStatus());
			System.out.println("Peso Total do Pedido: " + request.getRequestTotalWeight());
			System.out.println("Valor Total do Pedido: " + request.getRequestTotalValue());
			System.out.print("Produtos:  \n");

				request.getProducts()
				.forEach(product -> {
					if (product != null)
					{
						System.out.print("[");
						System.out.print("Id do Produto: " + product.getProductId());
						System.out.print(", Nome do Produto: " + product.getProductName());
						quanityProducts.getAndIncrement();
						System.out.println("]");

					}
					else {
						System.out.println("Produto não encontrado!");
					}
				});
			System.out.println("Quantidade de Produtos: " + quanityProducts.get());
			System.out.print("\n");
		});
	}
}

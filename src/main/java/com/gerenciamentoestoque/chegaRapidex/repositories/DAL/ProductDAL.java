package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.Product;
import java.util.List;

public interface ProductDAL
{
	List<Product> findAllProduct();

	Product findProductById(Long productId);

	void updateProductById(Product product, Long productId);

	void deleteProductById(Long productId);
}

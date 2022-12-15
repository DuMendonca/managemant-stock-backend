package com.gerenciamentoestoque.chegaRapidex.repositories.DAL;

import com.gerenciamentoestoque.chegaRapidex.entities.Address;
import java.util.List;

public interface AddressDAL
{
	List<Address> findAllAddress();

	Address findAddressById(Long addressId);

}

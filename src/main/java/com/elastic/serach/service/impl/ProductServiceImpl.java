package com.elastic.serach.service.impl;

import com.elastic.serach.entity.Product;
import com.elastic.serach.repo.ProductRepository;
import com.elastic.serach.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @abstract
 */

//在实现类而不是接口上添加注解
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepository;
	
	@Override
	public Product save(Product product) {
		return prodRepository.save(product);
	}

	@Override
	public void deleteByProductId(long id) {

		prodRepository.deleteById(id);
	}

	@Override
	public Product findByProductId(long id) {
		return prodRepository.findById(id).get();
	}

	@Override
	public Page<Product> findByProductName(String name,PageRequest pageRequest) {
		return prodRepository.findByProdName(name,pageRequest);
	}

	@Override
	public List<Product> findByProductCategory(String category) {
		return prodRepository.findByProdCategory(category);
	}

	@Override
	public void deleteAll() {
		prodRepository.deleteAll();
	}

	@Override
	public Iterable<Product> findAll() {
		return prodRepository.findAll();
	}

}

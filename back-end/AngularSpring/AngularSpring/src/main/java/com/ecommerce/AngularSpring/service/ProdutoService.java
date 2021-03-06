package com.ecommerce.AngularSpring.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.AngularSpring.model.Produto;
import com.ecommerce.AngularSpring.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void saveProduto(Produto prod) {
		LocalDate agora = LocalDate.now();
		prod.setDataCadastro(agora);
		produtoRepository.save(prod);
	}
	
	@Transactional(readOnly = true)
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	@Transactional
	public void delete(Produto prod) {
		produtoRepository.deleteById(prod.getId());
	}
	
}

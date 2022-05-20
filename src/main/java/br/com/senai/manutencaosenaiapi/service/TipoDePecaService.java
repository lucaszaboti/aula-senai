package br.com.senai.manutencaosenaiapi.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.senai.manutencaosenaiapi.entity.TipoDePeca;
import br.com.senai.manutencaosenaiapi.repository.TiposDePecasRepository;

@Service
@Validated
public class TipoDePecaService {
	
	@Autowired
	private TiposDePecasRepository repository;

	public TipoDePeca inserir(
			@Valid
			@NotNull(message = "O tipo da peça não pode ser nulo")
			TipoDePeca novoTipo) {
		TipoDePeca tipoSalvo = repository.save(novoTipo);
		return tipoSalvo;
	}
	
	public TipoDePeca alterar(
			@Valid 
			@NotNull(message = "O tipo da peça não pode ser nulo")
			TipoDePeca tipoSalvo) {
		TipoDePeca pecaAtualizada = repository.save(tipoSalvo);
		return pecaAtualizada;
	}
	
	public void removerPor(
			@NotNull(message = "O id do tipo da peça para remoção não pode ser nulo")
			@Min(value = 1, message = "O id do tipo da peça deve ser maior que zero")
			Integer id) {
		this.repository.deleteById(id);
	}
	
	public List<TipoDePeca> listarPor(
			@NotEmpty(message = "A descrição da busca é obrigatória")
			@NotBlank(message = "A descrição não pode conter espaço em branco")
			String descricao){
		return repository.listarPor("%" + descricao + "%");
	}
	
}

package br.com.tairoroberto.atributoimediate;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ChecagemEstoqueBean {
	
	private ItemEstoque itemEstoque = new ItemEstoque();
	private List<ItemEstoque> itensEstoque = new ArrayList<ItemEstoque>();
	
	public void incluir() {
		this.itensEstoque.add(this.itemEstoque);//add to list
		this.itemEstoque = new ItemEstoque();//clear  window
	}
	
	public void limpar() {
		this.itensEstoque.clear();
	}

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public List<ItemEstoque> getItensEstoque() {
		return itensEstoque;
	}	
}

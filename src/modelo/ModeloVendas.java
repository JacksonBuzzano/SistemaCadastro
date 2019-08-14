package modelo;

import java.util.Date;

public class ModeloVendas {

	int n1 = 1;
	int n2 = 2;
	int n3 = 3;
	int n4 = 4;

	private int id;
	private int qnt;
	private double valor;
	private String op;
	private String produto;
	private int pagt;
	private double total;
	private String pesquisa;
	private String data;
	

	




	//para divir os campos combobox e txtTotal
	public double calcula() {
		return (double) getTotal()/getPagt();
	}
	
	
	
	
	public String getData() {
		return data;
	}




	public void setData(String data) {
		this.data = data;
	}




	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public int getPagt() {
		return pagt;
	}

	public void setPagt(int pagt) {
		this.pagt = pagt;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getN3() {
		return n3;
	}

	public void setN3(int n3) {
		this.n3 = n3;
	}

	public int getN4() {
		return n4;
	}

	public void setN4(int n4) {
		this.n4 = n4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}

////////////////////////////////////////////////////////////////////
// [Davide] [Dinato] [1142198]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class MenuItem {
	
	public enum itemType{
		PRIMO, PIZZA
	}
	private itemType tipo;
	private String nome;
	private double prezzo;
	
	public MenuItem(itemType tipo, String nome, double prezzo) {
		this.tipo = tipo;
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	public itemType GetTipo(){
    	return tipo;
    }
    public String GetNome(){
    	return nome;
    }
    public double GetPrezzo(){
    	return prezzo;
    }
}

package Biblioteca;

public class Revista extends Item {
	public Revista(int id, String Title, String Author, int Year, int Quantity) {
		super(id, Title, Author, Year, "Revista", Quantity);
	}
}

package biblioteca;

public class Revista extends Item {
	public Revista(String Title, String Author, int Year, int Quantity, int categoria) {
		super(Title, Author, Year, "Revista", Quantity, categoria);
	}
}

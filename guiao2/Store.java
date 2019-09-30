package guiao2;

public class Store {
	private Catalog catalog;
	private LoansList loan;
	private ClientList cl;
	
	Store(ClientList cl, Catalog catalog, LoansList ll){
		this.catalog = catalog;
		this.loan = ll;
		this.cl = cl;
	}
}

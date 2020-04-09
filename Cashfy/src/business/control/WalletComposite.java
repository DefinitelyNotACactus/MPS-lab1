package business.control;

import java.util.ArrayList;
import java.util.List;

public class WalletComposite implements FinancialList{
	
	private List<FinancialList> options = new ArrayList<>();
	
	public void add(FinancialList finances) {
		options.add(finances);
	}
	
	public void remove(FinancialList finances) {
		options.remove(finances);
	}
	@Override
	public void listAll() {
		for(FinancialList op : options) {
			System.out.println(op);
		}
		
	}

}

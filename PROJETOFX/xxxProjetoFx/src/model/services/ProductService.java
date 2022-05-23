package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductService {
	
	private ProductDao dao = DaoFactory.createProductDao();
	
	

	public ProductService() {
				
	}

	
	public List<Product> findAll(){
		return dao.findAll();
		
	}
	
	public void saveOrUpdate(Product obj, int operation) {
			if(operation == 1) {
				dao.insert(obj);
			}
			if(operation == 2){
				dao.update(obj);
			}
			
	
	}
	

	public void remove(Product obj) {
			dao.deleteById(obj.getCod());
		
	}


}

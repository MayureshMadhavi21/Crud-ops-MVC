package productCrudAppMVC.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productCrudAppMVC.dao.ProductDao;
import productCrudAppMVC.model.Product;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplete;

	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplete.saveOrUpdate(product);
	}

	// getAllProducts
	public List<Product> getProducts() {
		List<Product> products = this.hibernateTemplete.loadAll(Product.class);
		return products;
	}

	// get single product
	public Product getProduct(int productId) {
		return this.hibernateTemplete.get(Product.class, productId);
	}

	// delete single product
	@Transactional
	public void deleteProduct(int productId) {
		Product product = this.hibernateTemplete.load(Product.class, productId);
		this.hibernateTemplete.delete(product);
	}
}

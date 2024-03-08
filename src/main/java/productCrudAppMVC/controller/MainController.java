package productCrudAppMVC.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productCrudAppMVC.dao.ProductDao;
import productCrudAppMVC.model.Product;

@Controller
public class MainController {
    
	@Autowired
	private ProductDao productDao;
	
   	@RequestMapping("/")
	public String home(Model model) {
   		List<Product> products = productDao.getProducts();
   		model.addAttribute("products", products);
		return "index";
	}
	
	//show add product form
	@RequestMapping("/add-product")
	public String addProduct(Model model) {
		model.addAttribute("title", "Add Product");
		return "add_product_form";
	}
	
	//handle add product form
		@RequestMapping(value="/handle-product", method=RequestMethod.POST)
		public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest httpServletRequest) {
			System.out.println(product);
			productDao.createProduct(product);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(httpServletRequest.getContextPath() + "/");
			return redirectView;
		}
		
	//delete handler
		@RequestMapping(value="/delete-product/productId/{productId}", method=RequestMethod.GET)
		public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest httpServletRequest) {
			productDao.deleteProduct(productId);
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(httpServletRequest.getContextPath() + "/");
			return redirectView;
		}
		
		//update form
		@RequestMapping("/update-product/productId/{productId}")
		public String updateForm(@PathVariable("productId") int productId, Model model ) {
			Product product = productDao.getProduct(productId);
			model.addAttribute("product", product);
			model.addAttribute("title", "Update Product");
			return "update_form";
		}
		//update handler > not using > using add only
				@RequestMapping(value="/update-product/productId/{productId}", method=RequestMethod.POST)
				public RedirectView updateProduct(@PathVariable("productId") int productId ,HttpServletRequest httpServletRequest) {
					RedirectView redirectView = new RedirectView();
					redirectView.setUrl(httpServletRequest.getContextPath() + "/");
					return redirectView;
				}
}

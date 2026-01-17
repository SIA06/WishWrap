package com.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Service.ProductExportService;
import com.entity.ProductEntity;
import com.repository.ProductRepo;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ProductController 
{

	@Autowired 
	ProductRepo productrepo;
	
	@Autowired
    private ProductExportService productExportService;
	
	
	@GetMapping("/product-view")
	public String product(Model model)
	{
		List<ProductEntity> products = productrepo.findAll();
	    model.addAttribute("products", products);
	    return "Product";
	}
	
	@GetMapping("/addproduct")
	public String add_product()
	{
		return "AddProduct";
	}
	
	@PostMapping("/addproduct")
	public String saveproduct(@RequestParam String productName,@RequestParam String description,@RequestParam String Price,@RequestParam String Stock,@RequestParam String Is_Customized)
	{
		ProductEntity productentity=new ProductEntity();
		
		productentity.setProduct_name(productName);
		productentity.setDescription(description);
		productentity.setPrice(new BigDecimal(Price));
		productentity.setStock(Integer.parseInt(Stock));
		boolean isCustomized = "yes".equalsIgnoreCase(Is_Customized) || "true".equalsIgnoreCase(Is_Customized);
	    productentity.setIsCustomized(isCustomized);

	    productrepo.save(productentity);
	    
		return "redirect:/product-view";
	}
	
	@PostMapping("/deleteproduct")
	public String deleteproduct(@RequestParam Integer product_id)
	{
		if (productrepo.existsById(product_id)) 
		{
	        productrepo.deleteById(product_id);
	    }
		return "redirect:/product-view";
	}
	
	@PostMapping("/editproduct")
	@ResponseBody
	public String editproduct(
	        @RequestParam Integer productId,
	        @RequestParam(required = false) String productName,
	        @RequestParam(required = false) String description,
	        @RequestParam(required = false) String Price,
	        @RequestParam(required = false) String Stock,
	        @RequestParam(required = false) String Is_Customized
	) 
	{
	    Optional<ProductEntity> op = productrepo.findById(productId);

	    if (op.isPresent() && productName != null) {   // Save only when data present
	        ProductEntity productentity = op.get();

	        productentity.setProduct_name(productName);
	        productentity.setDescription(description);
	        productentity.setPrice(new BigDecimal(Price));
	        productentity.setStock(Integer.parseInt(Stock));
	        productentity.setIsCustomized(Is_Customized != null &&Is_Customized.trim().equalsIgnoreCase("yes"));

	        productrepo.save(productentity);
	    }

	    return "OK";
	}
	
	@GetMapping("/exportfile")
	public void exportFile(@RequestParam String type,HttpServletResponse response) throws Exception
	{
		List<ProductEntity> products = productrepo.findAll();

        if ("csv".equalsIgnoreCase(type)) 
        {
            productExportService.exportToCSV(products, response);
        }
        else if ("excel".equalsIgnoreCase(type)) 
        {
            productExportService.exportToExcel(products, response);
        }
        else if ("pdf".equalsIgnoreCase(type)) 
        {
            productExportService.exportToPDF(products, response);
        } 
        else if ("word".equalsIgnoreCase(type)) 
        {
            productExportService.exportToWord(products, response);
        }
        else if ("xml".equalsIgnoreCase(type)) 
        {
            productExportService.exportToXML(products, response);
        }
	}
	
	@GetMapping("/product-filter")
	public String filterProducts(
	        @RequestParam(required = false) Boolean isCustomized,
	        @RequestParam(required = false) String sortField,
	        @RequestParam(required = false) String sortOrder,
	        Model model) {

	    List<ProductEntity> products;

	    boolean validSort = sortField != null && !sortField.trim().isEmpty()
	            && sortOrder != null && !sortOrder.trim().isEmpty();

	    if (validSort) {
	        Sort sort = sortOrder.equalsIgnoreCase("asc")
	                ? Sort.by(sortField).ascending()
	                : Sort.by(sortField).descending();

	        if (isCustomized != null) {
	            products = productrepo.findByIsCustomized(isCustomized, sort);
	        } else {
	            products = productrepo.findAll(sort);
	        }

	    } else {
	        if (isCustomized != null) {
	            products = productrepo.findByIsCustomized(isCustomized);
	        } else {
	            products = productrepo.findAll();
	        }
	    }

	    model.addAttribute("products", products);
	    return "Product";
	}


	
}

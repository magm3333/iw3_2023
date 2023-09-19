package ar.edu.iua.iw3.backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class BackendApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	/*
	@Autowired
	private IProductBusiness productBusiness;
	*/
	
	@Value("${spring.profiles.active:sinperfil}")
	private String profile;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Perfil activo {}",profile);
		/*
		try {
			Product p = productBusiness.load(1);
			log.debug("Producto {}",p);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		try {
			Product p = productBusiness.load("Arroz");
			log.debug("Producto {}",p);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		Product pNuevo1=new Product(0, "Leche", false, 789.67);
		try {
			productBusiness.add(pNuevo1);
		} catch (Exception e) {
		}
		
		
		List<Product> lista=productBusiness.list();
		for(Product p: lista)
			log.trace("{}",p);
		
		*/
	}

}

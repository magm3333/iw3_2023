package ar.edu.iua.iw3.backend;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;

@SecurityScheme(
		  name = "Bearer Authentication",
		  type = SecuritySchemeType.HTTP,
		  bearerFormat = "JWT",
		  scheme = "bearer",
		  paramName = "bearer"
		)

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
	
	//@Autowired
	//private ProductCli2Respository cli2DAO;
	
	@Value("${spring.jackson.time-zone:-}")
	private String backendTimezone;
	//@Autowired
	//private IProductCli2Business productCli2Business;

	//@Autowired
	//private ProductRepository productDAO;
	


	//@Autowired
	//private PasswordEncoder pEncoder;
	
	//@Autowired
	//private EmailBusiness emailBusiness;

	
	@Override
	public void run(String... args) throws Exception {
		
		//emailBusiness.sendSimpleMessage("magm@iua.edu.ar", "Mail de prueba", "Prueba perfil activo="+profile);
		
		String tzId = backendTimezone.equals("-") ?   TimeZone.getDefault().getID() : backendTimezone;
		TimeZone.setDefault(TimeZone.getTimeZone(tzId));
		
		log.info("-------------------------------------------------------------------------------------------------------------------");
		log.info("- Initial TimeZone: {} ({})", TimeZone.getDefault().getDisplayName(), TimeZone.getDefault().getID());
		log.info("- Perfil activo {}",profile);
		log.info("-------------------------------------------------------------------------------------------------------------------");
		
		//log.info("Cantidad de productos de la categoría id=1: {}", productDAO.countProductsByCategory(1));
		//log.info("Set stock=true producto id que no existe, resultado={}", productDAO.setStock(true, 333));

	
		//log.info("admin123={}",pEncoder.encode("admin123"));
		//log.info("user123={}",pEncoder.encode("user123"));
		
		/*
		log.info("Default -------------------------------------------------------------------------------------------------------");
		productCli2Business.listExpired(new Date());
		
		log.info("Customizada ---------------------------------------------------------------------------------------------------");
		productCli2Business.listSlim();
		*/
		
		//cli2DAO.findAll();
		//System.out.println("---------------------------------------------------");
		//cli2DAO.findByOrderByPriceDesc();
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

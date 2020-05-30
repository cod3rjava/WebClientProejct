package in.nit.config;

import org.springframework.context.annotation.Configuration;

import com.sun.xml.bind.v2.schemagen.xmlschema.Appinfo;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket configure() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("in.nit.controller"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(appinfo());
				
				
	}
	private ApiInfo appinfo(){
		
		return new ApiInfo("nit boot app","sample", "3.3", "http:/nit.in", "adminnit@gmail.com", "nit license", "http://nareshit.in");
		
	}
}

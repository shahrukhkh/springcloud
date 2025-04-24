package in.hcl.app.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.hcl.app.filter.CustomAuthFilter;

@Configuration
public class MyRouter {

	@Autowired
	private CustomAuthFilter customAuthFilter;

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				//.route("MS1",
					//	r -> r.path("/ms1/**").filters(f -> f.filter(customAuthFilter)).uri("http://localhost:8081"))
				 .route("UserPortfolio",r->r.path("/api/auth/**").uri("lb://UserPortfolio"))
				 .route("StockApi",r->r.path("/api/stock/**").filters(f -> f.filter(customAuthFilter)).uri("lb://StockApi"))
				 .route("StockApi",r->r.path("/api/reports/**").filters(f -> f.filter(customAuthFilter)).uri("lb://StockApi"))
				// .route("MS3",r->r.path("/ms3/**").uri("lb://MS3"))
				// .route("MS4",r->r.path("/ms4/**").uri("http://localhost:8089"))
				.build();
	}
}
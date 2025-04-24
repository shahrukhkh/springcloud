package in.hcl.app.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import in.hcl.app.utils.JwtUtil;
import reactor.core.publisher.Mono;
@Component
public class CustomAuthFilter implements GatewayFilter{

	@Autowired
	private JwtUtil jwtUtil;
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("===================================");
		String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ") || !jwtUtil.validateToken(authHeader.substring(7))) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

		return chain.filter(exchange);
	}

}

/**
 * @Author codeforsolution
 * Date: 19-05-2024
 **/
package com.codeforsolution.microservice.api.gateway.apigateway.config;


import com.codeforsolution.microservice.api.gateway.apigateway.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
class JwtAuthenticationFilter implements GlobalFilter {

    final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("My first pre-filter is excuted...");
        if(routeValidator.isSecured.test(exchange.getRequest())){
            //header contains token or not
            if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("missing authorization header");
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                authHeader = authHeader.substring(7);
            }

            try{
                jwtUtil.validateToken(authHeader);
            }catch (Exception e){
                System.out.println("invalid access...!");
                throw new RuntimeException("un authorized access to application");
            }
        }
        return chain.filter(exchange);
    }

}
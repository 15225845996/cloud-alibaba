package com.zs.apigateway.predicate;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Auther: zs
 * @Date: 2020/9/3 11:35
 * @Description:
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }
    //用于从配置文件中获取参数值赋值到配置类中的属性上
    @Override
    public List<String> shortcutFieldOrder() {
        //这里的顺序要跟配置文件中的参数顺序一致
        return Arrays.asList("minAge", "maxAge");
    }
    //断言
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {

        return exchange -> {
            boolean result = false;
            String ageStr = exchange.getRequest().getQueryParams().getFirst("age");
            if (StringUtils.isNotEmpty(ageStr)) {
                int age = Integer.parseInt(ageStr);
                if(age > config.getMinAge() && age < config.getMaxAge()){
                    result = true;
                }
            }
            System.out.println("AGE 校验==============="+result);
            return result;
        };
    }

    @Data
    public static class Config {
        private int minAge;
        private int maxAge;
    }

}

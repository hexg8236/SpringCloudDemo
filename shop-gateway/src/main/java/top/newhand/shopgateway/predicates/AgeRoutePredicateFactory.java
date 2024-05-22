package top.newhand.shopgateway.predicates;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author hexg8236
 * @className AgeRoutePredicateFactory
 * @Since 2024/5/22 21:58
 * @description 自定义年龄工厂
 **/

@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<Config> {
    public AgeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge", "maxAge");
    }


    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return serverWebExchange -> {
            // 从ServerWebExchange获取参数
            String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
            if (StringUtils.isNotEmpty(ageStr)) {
                int age = Integer.parseInt(ageStr);
                return age > config.getMinAge() && age < config.getMaxAge();
            }
            return true;
        };
    }

    //用于接收配置文件中断言的信息

}


class Config {

    public Config() {
    }
    public Config(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    private int minAge;
    private int maxAge;

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}




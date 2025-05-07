package com.web.flightManagementApplication.customactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomActuator  implements HealthIndicator {

    public final JdbcTemplate jdbcTemplate;

    public CustomActuator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Health health() {
        try {
            Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM flights", Integer.class);
            if(count!=0)
                return Health.up()
                        .withDetail("database", "Custom DB Check Passed")
                        .build();
        } catch (Exception e) {
            return Health.down(e)
                    .withDetail("database", "Custom DB Check Failed")
                    .build();
        }
        return null;
    }
}

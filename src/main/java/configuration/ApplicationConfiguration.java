package configuration;

import domain.User;
import dto.UserDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan({"service", "repository"})
public class ApplicationConfiguration {
    @Bean(name="user")
    @Scope("prototype")
    public User user() {
        return new User();
    }

    @Bean(name="user-dto")
    @Scope("prototype")
    public UserDTO userDTO() {
        return new UserDTO();
    }
}

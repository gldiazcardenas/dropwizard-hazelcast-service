package io.github.gldiazcardenas.dropwizard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.dropwizard.core.Configuration;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    private String greetingTemplate;

    @NotEmpty
    private String defaultVisitorName = "Stranger";

}

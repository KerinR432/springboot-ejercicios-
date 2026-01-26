package ConectarApiRest.D1_UD6.date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Value(Long id, String quate) {}

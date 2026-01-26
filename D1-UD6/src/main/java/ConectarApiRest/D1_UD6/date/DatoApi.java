package ConectarApiRest.D1_UD6.date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoApi(String type, Value value) {}

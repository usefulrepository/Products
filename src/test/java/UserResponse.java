import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {

    private Location location;

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Location {

        private Street street;
    }

    @Getter
    @ToString
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Street {

        private String name;
        private String number;
    }
}

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "countryName",
        "cityName",
        "stateName",
        "coords"
})
public class City {

    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("cityName")
    private String cityName;
    @JsonProperty("stateName")
    private String stateName;
    @JsonProperty("coords")
    private Coords coords;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("cityName")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("cityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("stateName")
    public String getStateName() {
        return stateName;
    }

    @JsonProperty("stateName")
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonProperty("coords")
    public Coords getCoords() {
        return coords;
    }

    @JsonProperty("coords")
    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "City{" +
                "countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", stateName='" + stateName + '\'' +
                ", coords=" + coords +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
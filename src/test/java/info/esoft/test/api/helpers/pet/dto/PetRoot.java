package info.esoft.test.api.helpers.pet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Value
public class PetRoot {
    @JsonProperty("id")
    Integer id;

    @JsonProperty("category")
    Category category;

    @JsonProperty("name")
    String name;

    @JsonProperty("photoUrls")
    @Singular("photoUrl")
    List<String> photoUrls;

    @JsonProperty("tags")
    @Singular("tags")
    List<Tag> tags;

    @JsonProperty("status")
    String status;
}

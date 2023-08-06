package com.growkeeper.dto.api.freePlantDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FreePlantDefaultImageDto {
    @JsonProperty("license")
    int license;
    @JsonProperty("license_name")
    String license_name;

    @JsonProperty("license_url")
    String license_url;

    @JsonProperty("original_url")
    String original_url;

    @JsonProperty("regular_url")
    String regular_url;

    @JsonProperty("medium_url")
    String medium_url;

    @JsonProperty("small_url")
    String small_url;

    @JsonProperty("thumbnail")
    String thumbnail;
}

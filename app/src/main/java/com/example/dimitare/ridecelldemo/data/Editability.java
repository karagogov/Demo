package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "cancomment",
    "canaddmeta"
})
public class Editability {
    @JsonProperty("cancomment")
    private Integer cancomment;
    @JsonProperty("canaddmeta")
    private Integer canaddmeta;

    @JsonProperty("cancomment")
    public Integer getCancomment() {
        return cancomment;
    }

    @JsonProperty("cancomment")
    public void setCancomment(Integer cancomment) {
        this.cancomment = cancomment;
    }

    @JsonProperty("canaddmeta")
    public Integer getCanaddmeta() {
        return canaddmeta;
    }

    @JsonProperty("canaddmeta")
    public void setCanaddmeta(Integer canaddmeta) {
        this.canaddmeta = canaddmeta;
    }
}

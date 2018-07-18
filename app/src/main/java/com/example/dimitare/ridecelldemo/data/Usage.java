
package com.example.dimitare.ridecelldemo.data;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "candownload",
    "canblog",
    "canprint",
    "canshare"
})
public class Usage {

    @JsonProperty("candownload")
    private Integer candownload;
    @JsonProperty("canblog")
    private Integer canblog;
    @JsonProperty("canprint")
    private Integer canprint;
    @JsonProperty("canshare")
    private Integer canshare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("candownload")
    public Integer getCandownload() {
        return candownload;
    }

    @JsonProperty("candownload")
    public void setCandownload(Integer candownload) {
        this.candownload = candownload;
    }

    @JsonProperty("canblog")
    public Integer getCanblog() {
        return canblog;
    }

    @JsonProperty("canblog")
    public void setCanblog(Integer canblog) {
        this.canblog = canblog;
    }

    @JsonProperty("canprint")
    public Integer getCanprint() {
        return canprint;
    }

    @JsonProperty("canprint")
    public void setCanprint(Integer canprint) {
        this.canprint = canprint;
    }

    @JsonProperty("canshare")
    public Integer getCanshare() {
        return canshare;
    }

    @JsonProperty("canshare")
    public void setCanshare(Integer canshare) {
        this.canshare = canshare;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

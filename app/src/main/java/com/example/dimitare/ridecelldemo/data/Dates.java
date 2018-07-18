package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "posted",
    "taken",
    "takengranularity",
    "takenunknown",
    "lastupdate"
})
public class Dates {
    @JsonProperty("posted")
    private String posted;
    @JsonProperty("taken")
    private String taken;
    @JsonProperty("takengranularity")
    private String takengranularity;
    @JsonProperty("takenunknown")
    private String takenunknown;
    @JsonProperty("lastupdate")
    private String lastupdate;

    @JsonProperty("posted")
    public String getPosted() {
        return posted;
    }

    @JsonProperty("posted")
    public void setPosted(String posted) {
        this.posted = posted;
    }

    @JsonProperty("taken")
    public String getTaken() {
        return taken;
    }

    @JsonProperty("taken")
    public void setTaken(String taken) {
        this.taken = taken;
    }

    @JsonProperty("takengranularity")
    public String getTakengranularity() {
        return takengranularity;
    }

    @JsonProperty("takengranularity")
    public void setTakengranularity(String takengranularity) {
        this.takengranularity = takengranularity;
    }

    @JsonProperty("takenunknown")
    public String getTakenunknown() {
        return takenunknown;
    }

    @JsonProperty("takenunknown")
    public void setTakenunknown(String takenunknown) {
        this.takenunknown = takenunknown;
    }

    @JsonProperty("lastupdate")
    public String getLastupdate() {
        return lastupdate;
    }

    @JsonProperty("lastupdate")
    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }
}

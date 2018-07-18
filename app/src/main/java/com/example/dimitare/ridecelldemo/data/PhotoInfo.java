package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
        "photo",
        "stat"
})
public class PhotoInfo {
    @JsonProperty("photo")
    private PhotoInfoPhoto photo;
    @JsonProperty("stat")
    private String stat;

    @JsonProperty("photo")
    public PhotoInfoPhoto getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(PhotoInfoPhoto photo) {
        this.photo = photo;
    }

    @JsonProperty("stat")
    public String getStat() {
        return stat;
    }

    @JsonProperty("stat")
    public void setStat(String stat) {
        this.stat = stat;
    }
}

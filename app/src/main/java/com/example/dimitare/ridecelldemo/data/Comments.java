package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "_content"
})
public class Comments {
    @JsonProperty("_content")
    private String content;

    @JsonProperty("_content")
    public String getContent() {
        return content;
    }

    @JsonProperty("_content")
    public void setContent(String content) {
        this.content = content;
    }
}

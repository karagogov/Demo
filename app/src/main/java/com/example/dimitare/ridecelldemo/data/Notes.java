package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "note"
})
public class Notes {
    @JsonProperty("note")
    private List<Object> note = null;

    @JsonProperty("note")
    public List<Object> getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(List<Object> note) {
        this.note = note;
    }
}

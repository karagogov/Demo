package com.example.dimitare.ridecelldemo.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder({
    "nsid",
    "username",
    "realname",
    "location",
    "iconserver",
    "iconfarm",
    "path_alias"
})
public class Owner {
    @JsonProperty("nsid")
    private String nsid;
    @JsonProperty("username")
    private String username;
    @JsonProperty("realname")
    private String realname;
    @JsonProperty("location")
    private String location;
    @JsonProperty("iconserver")
    private String iconserver;
    @JsonProperty("iconfarm")
    private Integer iconfarm;
    @JsonProperty("path_alias")
    private Object pathAlias;

    @JsonProperty("nsid")
    public String getNsid() {
        return nsid;
    }

    @JsonProperty("nsid")
    public void setNsid(String nsid) {
        this.nsid = nsid;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("realname")
    public String getRealname() {
        return realname;
    }

    @JsonProperty("realname")
    public void setRealname(String realname) {
        this.realname = realname;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("iconserver")
    public String getIconserver() {
        return iconserver;
    }

    @JsonProperty("iconserver")
    public void setIconserver(String iconserver) {
        this.iconserver = iconserver;
    }

    @JsonProperty("iconfarm")
    public Integer getIconfarm() {
        return iconfarm;
    }

    @JsonProperty("iconfarm")
    public void setIconfarm(Integer iconfarm) {
        this.iconfarm = iconfarm;
    }

    @JsonProperty("path_alias")
    public Object getPathAlias() {
        return pathAlias;
    }

    @JsonProperty("path_alias")
    public void setPathAlias(Object pathAlias) {
        this.pathAlias = pathAlias;
    }
}

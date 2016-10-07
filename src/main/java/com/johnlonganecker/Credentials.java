
package com.johnlonganecker;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Credentials {

    @SerializedName("http_api_uris")
    @Expose
    private List<String> httpApiUris = new ArrayList<String>();
    @SerializedName("ssl")
    @Expose
    private Boolean ssl;
    @SerializedName("dashboard_url")
    @Expose
    private String dashboardUrl;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("protocols")
    @Expose
    private Protocols protocols;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("hostnames")
    @Expose
    private List<String> hostnames = new ArrayList<String>();
    @SerializedName("vhost")
    @Expose
    private String vhost;
    @SerializedName("http_api_uri")
    @Expose
    private String httpApiUri;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("uris")
    @Expose
    private List<String> uris = new ArrayList<String>();

    /**
     * 
     * @return
     *     The httpApiUris
     */
    public List<String> getHttpApiUris() {
        return httpApiUris;
    }

    /**
     * 
     * @param httpApiUris
     *     The http_api_uris
     */
    public void setHttpApiUris(List<String> httpApiUris) {
        this.httpApiUris = httpApiUris;
    }

    /**
     * 
     * @return
     *     The ssl
     */
    public Boolean getSsl() {
        return ssl;
    }

    /**
     * 
     * @param ssl
     *     The ssl
     */
    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    /**
     * 
     * @return
     *     The dashboardUrl
     */
    public String getDashboardUrl() {
        return dashboardUrl;
    }

    /**
     * 
     * @param dashboardUrl
     *     The dashboard_url
     */
    public void setDashboardUrl(String dashboardUrl) {
        this.dashboardUrl = dashboardUrl;
    }

    /**
     * 
     * @return
     *     The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 
     * @return
     *     The protocols
     */
    public Protocols getProtocols() {
        return protocols;
    }

    /**
     * 
     * @param protocols
     *     The protocols
     */
    public void setProtocols(Protocols protocols) {
        this.protocols = protocols;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 
     * @param hostname
     *     The hostname
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * 
     * @return
     *     The hostnames
     */
    public List<String> getHostnames() {
        return hostnames;
    }

    /**
     * 
     * @param hostnames
     *     The hostnames
     */
    public void setHostnames(List<String> hostnames) {
        this.hostnames = hostnames;
    }

    /**
     * 
     * @return
     *     The vhost
     */
    public String getVhost() {
        return vhost;
    }

    /**
     * 
     * @param vhost
     *     The vhost
     */
    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    /**
     * 
     * @return
     *     The httpApiUri
     */
    public String getHttpApiUri() {
        return httpApiUri;
    }

    /**
     * 
     * @param httpApiUri
     *     The http_api_uri
     */
    public void setHttpApiUri(String httpApiUri) {
        this.httpApiUri = httpApiUri;
    }

    /**
     * 
     * @return
     *     The uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 
     * @param uri
     *     The uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 
     * @return
     *     The uris
     */
    public List<String> getUris() {
        return uris;
    }

    /**
     * 
     * @param uris
     *     The uris
     */
    public void setUris(List<String> uris) {
        this.uris = uris;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

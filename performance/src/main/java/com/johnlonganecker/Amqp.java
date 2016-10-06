
package com.johnlonganecker;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Amqp {

    @SerializedName("vhost")
    @Expose
    private String vhost;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("port")
    @Expose
    private Integer port;
    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("hosts")
    @Expose
    private List<String> hosts = new ArrayList<String>();
    @SerializedName("ssl")
    @Expose
    private Boolean ssl;
    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("uris")
    @Expose
    private List<String> uris = new ArrayList<String>();

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
     *     The port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 
     * @param port
     *     The port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 
     * @return
     *     The host
     */
    public String getHost() {
        return host;
    }

    /**
     * 
     * @param host
     *     The host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * 
     * @return
     *     The hosts
     */
    public List<String> getHosts() {
        return hosts;
    }

    /**
     * 
     * @param hosts
     *     The hosts
     */
    public void setHosts(List<String> hosts) {
        this.hosts = hosts;
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

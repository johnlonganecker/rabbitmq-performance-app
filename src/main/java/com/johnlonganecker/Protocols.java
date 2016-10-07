
package com.johnlonganecker;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Protocols {

    @SerializedName("management")
    @Expose
    private Management management;
    @SerializedName("amqp")
    @Expose
    private Amqp amqp;
    @SerializedName("stomp")
    @Expose
    private Stomp stomp;

    /**
     * 
     * @return
     *     The management
     */
    public Management getManagement() {
        return management;
    }

    /**
     * 
     * @param management
     *     The management
     */
    public void setManagement(Management management) {
        this.management = management;
    }

    /**
     * 
     * @return
     *     The amqp
     */
    public Amqp getAmqp() {
        return amqp;
    }

    /**
     * 
     * @param amqp
     *     The amqp
     */
    public void setAmqp(Amqp amqp) {
        this.amqp = amqp;
    }

    /**
     * 
     * @return
     *     The stomp
     */
    public Stomp getStomp() {
        return stomp;
    }

    /**
     * 
     * @param stomp
     *     The stomp
     */
    public void setStomp(Stomp stomp) {
        this.stomp = stomp;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

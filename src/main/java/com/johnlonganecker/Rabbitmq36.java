
package com.johnlonganecker;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Rabbitmq36 {

    @SerializedName("rabbitmq-36")
    @Expose
    private List<Rabbitmq36_> rabbitmq36 = new ArrayList<Rabbitmq36_>();

    /**
     * 
     * @return
     *     The rabbitmq36
     */
    public List<Rabbitmq36_> getRabbitmq36() {
        return rabbitmq36;
    }

    /**
     * 
     * @param rabbitmq36
     *     The rabbitmq-36
     */
    public void setRabbitmq36(List<Rabbitmq36_> rabbitmq36) {
        this.rabbitmq36 = rabbitmq36;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

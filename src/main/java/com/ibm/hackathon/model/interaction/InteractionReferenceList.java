
package com.ibm.hackathon.model.interaction;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "referenceId",
    "citation"
})
public class InteractionReferenceList {

    @JsonProperty("referenceId")
    private Integer referenceId;
    @JsonProperty("citation")
    private String citation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The referenceId
     */
    @JsonProperty("referenceId")
    public Integer getReferenceId() {
        return referenceId;
    }

    /**
     * 
     * @param referenceId
     *     The referenceId
     */
    @JsonProperty("referenceId")
    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    /**
     * 
     * @return
     *     The citation
     */
    @JsonProperty("citation")
    public String getCitation() {
        return citation;
    }

    /**
     * 
     * @param citation
     *     The citation
     */
    @JsonProperty("citation")
    public void setCitation(String citation) {
        this.citation = citation;
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

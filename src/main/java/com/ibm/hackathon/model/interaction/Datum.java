
package com.ibm.hackathon.model.interaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "severity",
    "sourceRanking",
    "consumerNotes",
    "professionalNotes",
    "interactionSetBName",
    "clinicalManagementStatements",
    "interactionSetAName",
    "interactionSetADrugList",
    "interactionSetBDrugList",
    "interactionReferenceList"
})
public class Datum {

    @JsonProperty("severity")
    private Integer severity;
    @JsonProperty("sourceRanking")
    private Integer sourceRanking;
    @JsonProperty("consumerNotes")
    private String consumerNotes;
    @JsonProperty("professionalNotes")
    private String professionalNotes;
    @JsonProperty("interactionSetBName")
    private String interactionSetBName;
    @JsonProperty("clinicalManagementStatements")
    private List<String> clinicalManagementStatements = new ArrayList<String>();
    @JsonProperty("interactionSetAName")
    private String interactionSetAName;
    @JsonProperty("interactionSetADrugList")
    private List<String> interactionSetADrugList = new ArrayList<String>();
    @JsonProperty("interactionSetBDrugList")
    private List<String> interactionSetBDrugList = new ArrayList<String>();
    @JsonProperty("interactionReferenceList")
    private List<InteractionReferenceList> interactionReferenceList = new ArrayList<InteractionReferenceList>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The severity
     */
    @JsonProperty("severity")
    public Integer getSeverity() {
        return severity;
    }

    /**
     * 
     * @param severity
     *     The severity
     */
    @JsonProperty("severity")
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    /**
     * 
     * @return
     *     The sourceRanking
     */
    @JsonProperty("sourceRanking")
    public Integer getSourceRanking() {
        return sourceRanking;
    }

    /**
     * 
     * @param sourceRanking
     *     The sourceRanking
     */
    @JsonProperty("sourceRanking")
    public void setSourceRanking(Integer sourceRanking) {
        this.sourceRanking = sourceRanking;
    }

    /**
     * 
     * @return
     *     The consumerNotes
     */
    @JsonProperty("consumerNotes")
    public String getConsumerNotes() {
        return consumerNotes;
    }

    /**
     * 
     * @param consumerNotes
     *     The consumerNotes
     */
    @JsonProperty("consumerNotes")
    public void setConsumerNotes(String consumerNotes) {
        this.consumerNotes = consumerNotes;
    }

    /**
     * 
     * @return
     *     The professionalNotes
     */
    @JsonProperty("professionalNotes")
    public String getProfessionalNotes() {
        return professionalNotes;
    }

    /**
     * 
     * @param professionalNotes
     *     The professionalNotes
     */
    @JsonProperty("professionalNotes")
    public void setProfessionalNotes(String professionalNotes) {
        this.professionalNotes = professionalNotes;
    }

    /**
     * 
     * @return
     *     The interactionSetBName
     */
    @JsonProperty("interactionSetBName")
    public String getInteractionSetBName() {
        return interactionSetBName;
    }

    /**
     * 
     * @param interactionSetBName
     *     The interactionSetBName
     */
    @JsonProperty("interactionSetBName")
    public void setInteractionSetBName(String interactionSetBName) {
        this.interactionSetBName = interactionSetBName;
    }

    /**
     * 
     * @return
     *     The clinicalManagementStatements
     */
    @JsonProperty("clinicalManagementStatements")
    public List<String> getClinicalManagementStatements() {
        return clinicalManagementStatements;
    }

    /**
     * 
     * @param clinicalManagementStatements
     *     The clinicalManagementStatements
     */
    @JsonProperty("clinicalManagementStatements")
    public void setClinicalManagementStatements(List<String> clinicalManagementStatements) {
        this.clinicalManagementStatements = clinicalManagementStatements;
    }

    /**
     * 
     * @return
     *     The interactionSetAName
     */
    @JsonProperty("interactionSetAName")
    public String getInteractionSetAName() {
        return interactionSetAName;
    }

    /**
     * 
     * @param interactionSetAName
     *     The interactionSetAName
     */
    @JsonProperty("interactionSetAName")
    public void setInteractionSetAName(String interactionSetAName) {
        this.interactionSetAName = interactionSetAName;
    }

    /**
     * 
     * @return
     *     The interactionSetADrugList
     */
    @JsonProperty("interactionSetADrugList")
    public List<String> getInteractionSetADrugList() {
        return interactionSetADrugList;
    }

    /**
     * 
     * @param interactionSetADrugList
     *     The interactionSetADrugList
     */
    @JsonProperty("interactionSetADrugList")
    public void setInteractionSetADrugList(List<String> interactionSetADrugList) {
        this.interactionSetADrugList = interactionSetADrugList;
    }

    /**
     * 
     * @return
     *     The interactionSetBDrugList
     */
    @JsonProperty("interactionSetBDrugList")
    public List<String> getInteractionSetBDrugList() {
        return interactionSetBDrugList;
    }

    /**
     * 
     * @param interactionSetBDrugList
     *     The interactionSetBDrugList
     */
    @JsonProperty("interactionSetBDrugList")
    public void setInteractionSetBDrugList(List<String> interactionSetBDrugList) {
        this.interactionSetBDrugList = interactionSetBDrugList;
    }

    /**
     * 
     * @return
     *     The interactionReferenceList
     */
    @JsonProperty("interactionReferenceList")
    public List<InteractionReferenceList> getInteractionReferenceList() {
        return interactionReferenceList;
    }

    /**
     * 
     * @param interactionReferenceList
     *     The interactionReferenceList
     */
    @JsonProperty("interactionReferenceList")
    public void setInteractionReferenceList(List<InteractionReferenceList> interactionReferenceList) {
        this.interactionReferenceList = interactionReferenceList;
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

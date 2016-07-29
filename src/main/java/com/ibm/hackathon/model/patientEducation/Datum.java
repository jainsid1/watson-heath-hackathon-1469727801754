package com.ibm.hackathon.model.patientEducation;

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
    "languageId",
    "language",
    "sheetTitleId",
    "sheetName",
    "tradeNames",
    "descriptionHeader",
    "description",
    "descriptionFooter",
    "contraindicationsHeader",
    "contraindications",
    "contraindicationsFooter",
    "administrationHeader",
    "administration",
    "administrationFooter",
    "missedDoseHeader",
    "missedDose",
    "missedDoseFooter",
    "interactionsHeader",
    "interactions",
    "interactionsFooter",
    "monitoringHeader",
    "monitoring",
    "monitoringFooter",
    "sideEffectsHeader",
    "sideEffects",
    "sideEffectsFooter",
    "storageHeader",
    "storage",
    "storageFooter",
    "lastUpdated",
    "copyright"
})
public class Datum {

    @JsonProperty("languageId")
    private Integer languageId;
    @JsonProperty("language")
    private String language;
    @JsonProperty("sheetTitleId")
    private Integer sheetTitleId;
    @JsonProperty("sheetName")
    private String sheetName;
    @JsonProperty("tradeNames")
    private List<String> tradeNames = new ArrayList<String>();
    @JsonProperty("descriptionHeader")
    private String descriptionHeader;
    @JsonProperty("description")
    private String description;
    @JsonProperty("descriptionFooter")
    private String descriptionFooter;
    @JsonProperty("contraindicationsHeader")
    private String contraindicationsHeader;
    @JsonProperty("contraindications")
    private String contraindications;
    @JsonProperty("contraindicationsFooter")
    private String contraindicationsFooter;
    @JsonProperty("administrationHeader")
    private String administrationHeader;
    @JsonProperty("administration")
    private String administration;
    @JsonProperty("administrationFooter")
    private String administrationFooter;
    @JsonProperty("missedDoseHeader")
    private String missedDoseHeader;
    @JsonProperty("missedDose")
    private String missedDose;
    @JsonProperty("missedDoseFooter")
    private String missedDoseFooter;
    @JsonProperty("interactionsHeader")
    private String interactionsHeader;
    @JsonProperty("interactions")
    private String interactions;
    @JsonProperty("interactionsFooter")
    private String interactionsFooter;
    @JsonProperty("monitoringHeader")
    private String monitoringHeader;
    @JsonProperty("monitoring")
    private String monitoring;
    @JsonProperty("monitoringFooter")
    private String monitoringFooter;
    @JsonProperty("sideEffectsHeader")
    private String sideEffectsHeader;
    @JsonProperty("sideEffects")
    private String sideEffects;
    @JsonProperty("sideEffectsFooter")
    private String sideEffectsFooter;
    @JsonProperty("storageHeader")
    private String storageHeader;
    @JsonProperty("storage")
    private String storage;
    @JsonProperty("storageFooter")
    private String storageFooter;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("copyright")
    private String copyright;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The languageId
     */
    @JsonProperty("languageId")
    public Integer getLanguageId() {
        return languageId;
    }

    /**
     * 
     * @param languageId
     *     The languageId
     */
    @JsonProperty("languageId")
    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    /**
     * 
     * @return
     *     The language
     */
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The sheetTitleId
     */
    @JsonProperty("sheetTitleId")
    public Integer getSheetTitleId() {
        return sheetTitleId;
    }

    /**
     * 
     * @param sheetTitleId
     *     The sheetTitleId
     */
    @JsonProperty("sheetTitleId")
    public void setSheetTitleId(Integer sheetTitleId) {
        this.sheetTitleId = sheetTitleId;
    }

    /**
     * 
     * @return
     *     The sheetName
     */
    @JsonProperty("sheetName")
    public String getSheetName() {
        return sheetName;
    }

    /**
     * 
     * @param sheetName
     *     The sheetName
     */
    @JsonProperty("sheetName")
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * 
     * @return
     *     The tradeNames
     */
    @JsonProperty("tradeNames")
    public List<String> getTradeNames() {
        return tradeNames;
    }

    /**
     * 
     * @param tradeNames
     *     The tradeNames
     */
    @JsonProperty("tradeNames")
    public void setTradeNames(List<String> tradeNames) {
        this.tradeNames = tradeNames;
    }

    /**
     * 
     * @return
     *     The descriptionHeader
     */
    @JsonProperty("descriptionHeader")
    public String getDescriptionHeader() {
        return descriptionHeader;
    }

    /**
     * 
     * @param descriptionHeader
     *     The descriptionHeader
     */
    @JsonProperty("descriptionHeader")
    public void setDescriptionHeader(String descriptionHeader) {
        this.descriptionHeader = descriptionHeader;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The descriptionFooter
     */
    @JsonProperty("descriptionFooter")
    public String getDescriptionFooter() {
        return descriptionFooter;
    }

    /**
     * 
     * @param descriptionFooter
     *     The descriptionFooter
     */
    @JsonProperty("descriptionFooter")
    public void setDescriptionFooter(String descriptionFooter) {
        this.descriptionFooter = descriptionFooter;
    }

    /**
     * 
     * @return
     *     The contraindicationsHeader
     */
    @JsonProperty("contraindicationsHeader")
    public String getContraindicationsHeader() {
        return contraindicationsHeader;
    }

    /**
     * 
     * @param contraindicationsHeader
     *     The contraindicationsHeader
     */
    @JsonProperty("contraindicationsHeader")
    public void setContraindicationsHeader(String contraindicationsHeader) {
        this.contraindicationsHeader = contraindicationsHeader;
    }

    /**
     * 
     * @return
     *     The contraindications
     */
    @JsonProperty("contraindications")
    public String getContraindications() {
        return contraindications;
    }

    /**
     * 
     * @param contraindications
     *     The contraindications
     */
    @JsonProperty("contraindications")
    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    /**
     * 
     * @return
     *     The contraindicationsFooter
     */
    @JsonProperty("contraindicationsFooter")
    public String getContraindicationsFooter() {
        return contraindicationsFooter;
    }

    /**
     * 
     * @param contraindicationsFooter
     *     The contraindicationsFooter
     */
    @JsonProperty("contraindicationsFooter")
    public void setContraindicationsFooter(String contraindicationsFooter) {
        this.contraindicationsFooter = contraindicationsFooter;
    }

    /**
     * 
     * @return
     *     The administrationHeader
     */
    @JsonProperty("administrationHeader")
    public String getAdministrationHeader() {
        return administrationHeader;
    }

    /**
     * 
     * @param administrationHeader
     *     The administrationHeader
     */
    @JsonProperty("administrationHeader")
    public void setAdministrationHeader(String administrationHeader) {
        this.administrationHeader = administrationHeader;
    }

    /**
     * 
     * @return
     *     The administration
     */
    @JsonProperty("administration")
    public String getAdministration() {
        return administration;
    }

    /**
     * 
     * @param administration
     *     The administration
     */
    @JsonProperty("administration")
    public void setAdministration(String administration) {
        this.administration = administration;
    }

    /**
     * 
     * @return
     *     The administrationFooter
     */
    @JsonProperty("administrationFooter")
    public String getAdministrationFooter() {
        return administrationFooter;
    }

    /**
     * 
     * @param administrationFooter
     *     The administrationFooter
     */
    @JsonProperty("administrationFooter")
    public void setAdministrationFooter(String administrationFooter) {
        this.administrationFooter = administrationFooter;
    }

    /**
     * 
     * @return
     *     The missedDoseHeader
     */
    @JsonProperty("missedDoseHeader")
    public String getMissedDoseHeader() {
        return missedDoseHeader;
    }

    /**
     * 
     * @param missedDoseHeader
     *     The missedDoseHeader
     */
    @JsonProperty("missedDoseHeader")
    public void setMissedDoseHeader(String missedDoseHeader) {
        this.missedDoseHeader = missedDoseHeader;
    }

    /**
     * 
     * @return
     *     The missedDose
     */
    @JsonProperty("missedDose")
    public String getMissedDose() {
        return missedDose;
    }

    /**
     * 
     * @param missedDose
     *     The missedDose
     */
    @JsonProperty("missedDose")
    public void setMissedDose(String missedDose) {
        this.missedDose = missedDose;
    }

    /**
     * 
     * @return
     *     The missedDoseFooter
     */
    @JsonProperty("missedDoseFooter")
    public String getMissedDoseFooter() {
        return missedDoseFooter;
    }

    /**
     * 
     * @param missedDoseFooter
     *     The missedDoseFooter
     */
    @JsonProperty("missedDoseFooter")
    public void setMissedDoseFooter(String missedDoseFooter) {
        this.missedDoseFooter = missedDoseFooter;
    }

    /**
     * 
     * @return
     *     The interactionsHeader
     */
    @JsonProperty("interactionsHeader")
    public String getInteractionsHeader() {
        return interactionsHeader;
    }

    /**
     * 
     * @param interactionsHeader
     *     The interactionsHeader
     */
    @JsonProperty("interactionsHeader")
    public void setInteractionsHeader(String interactionsHeader) {
        this.interactionsHeader = interactionsHeader;
    }

    /**
     * 
     * @return
     *     The interactions
     */
    @JsonProperty("interactions")
    public String getInteractions() {
        return interactions;
    }

    /**
     * 
     * @param interactions
     *     The interactions
     */
    @JsonProperty("interactions")
    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    /**
     * 
     * @return
     *     The interactionsFooter
     */
    @JsonProperty("interactionsFooter")
    public String getInteractionsFooter() {
        return interactionsFooter;
    }

    /**
     * 
     * @param interactionsFooter
     *     The interactionsFooter
     */
    @JsonProperty("interactionsFooter")
    public void setInteractionsFooter(String interactionsFooter) {
        this.interactionsFooter = interactionsFooter;
    }

    /**
     * 
     * @return
     *     The monitoringHeader
     */
    @JsonProperty("monitoringHeader")
    public String getMonitoringHeader() {
        return monitoringHeader;
    }

    /**
     * 
     * @param monitoringHeader
     *     The monitoringHeader
     */
    @JsonProperty("monitoringHeader")
    public void setMonitoringHeader(String monitoringHeader) {
        this.monitoringHeader = monitoringHeader;
    }

    /**
     * 
     * @return
     *     The monitoring
     */
    @JsonProperty("monitoring")
    public String getMonitoring() {
        return monitoring;
    }

    /**
     * 
     * @param monitoring
     *     The monitoring
     */
    @JsonProperty("monitoring")
    public void setMonitoring(String monitoring) {
        this.monitoring = monitoring;
    }

    /**
     * 
     * @return
     *     The monitoringFooter
     */
    @JsonProperty("monitoringFooter")
    public String getMonitoringFooter() {
        return monitoringFooter;
    }

    /**
     * 
     * @param monitoringFooter
     *     The monitoringFooter
     */
    @JsonProperty("monitoringFooter")
    public void setMonitoringFooter(String monitoringFooter) {
        this.monitoringFooter = monitoringFooter;
    }

    /**
     * 
     * @return
     *     The sideEffectsHeader
     */
    @JsonProperty("sideEffectsHeader")
    public String getSideEffectsHeader() {
        return sideEffectsHeader;
    }

    /**
     * 
     * @param sideEffectsHeader
     *     The sideEffectsHeader
     */
    @JsonProperty("sideEffectsHeader")
    public void setSideEffectsHeader(String sideEffectsHeader) {
        this.sideEffectsHeader = sideEffectsHeader;
    }

    /**
     * 
     * @return
     *     The sideEffects
     */
    @JsonProperty("sideEffects")
    public String getSideEffects() {
        return sideEffects;
    }

    /**
     * 
     * @param sideEffects
     *     The sideEffects
     */
    @JsonProperty("sideEffects")
    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    /**
     * 
     * @return
     *     The sideEffectsFooter
     */
    @JsonProperty("sideEffectsFooter")
    public String getSideEffectsFooter() {
        return sideEffectsFooter;
    }

    /**
     * 
     * @param sideEffectsFooter
     *     The sideEffectsFooter
     */
    @JsonProperty("sideEffectsFooter")
    public void setSideEffectsFooter(String sideEffectsFooter) {
        this.sideEffectsFooter = sideEffectsFooter;
    }

    /**
     * 
     * @return
     *     The storageHeader
     */
    @JsonProperty("storageHeader")
    public String getStorageHeader() {
        return storageHeader;
    }

    /**
     * 
     * @param storageHeader
     *     The storageHeader
     */
    @JsonProperty("storageHeader")
    public void setStorageHeader(String storageHeader) {
        this.storageHeader = storageHeader;
    }

    /**
     * 
     * @return
     *     The storage
     */
    @JsonProperty("storage")
    public String getStorage() {
        return storage;
    }

    /**
     * 
     * @param storage
     *     The storage
     */
    @JsonProperty("storage")
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**
     * 
     * @return
     *     The storageFooter
     */
    @JsonProperty("storageFooter")
    public String getStorageFooter() {
        return storageFooter;
    }

    /**
     * 
     * @param storageFooter
     *     The storageFooter
     */
    @JsonProperty("storageFooter")
    public void setStorageFooter(String storageFooter) {
        this.storageFooter = storageFooter;
    }

    /**
     * 
     * @return
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    /**
     * 
     * @param lastUpdated
     *     The lastUpdated
     */
    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * 
     * @return
     *     The copyright
     */
    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    /**
     * 
     * @param copyright
     *     The copyright
     */
    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
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

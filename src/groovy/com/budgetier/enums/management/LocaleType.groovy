package com.budgetier.enums.management

/**
 * Created by vbledar on 10/4/14.
 *
 * This enumeration defines the different locale types the
 * application can support.
 */
public enum LocaleType {

    ENGLISH ("English", "locale.type.english", "en_US"),
    GREEK ("Greek", "locale.type.greek", "el"),
    FRENCH ("French", "locale.type.french", "fr")

    private String descriptive                              // default human readable representation
    private String i18nDescriptive                          // i18n representation
    private String localeIsoValue                                // the local iso value, eg. gr for greek and en_US for english

    /**
     * Enumeration instance constructor. This constructor
     * will initialize the enumeration instance descriptive
     * value.
     *
     * @param descriptive, the value to set.
     */
    public LocaleType(String descriptive, String i18nDescriptive, String localeIsoValue) {
        this.descriptive = descriptive
        this.i18nDescriptive = i18nDescriptive
        this.localeIsoValue = localeIsoValue
    }

    /**
     * Retrieve the descriptive information of this enumeration
     * instance.
     *
     * @return <code>String</code> the descriptive value of the
     * enumeration instance.
     */
    public String getDescriptive() {
        return this.descriptive
    }

    /**
     * Retrieve the i18n descriptive information of this enumeration
     * instance.
     *
     * @return <code>String</code> the i18n descriptive value of the
     * enumeration instance.
     */
    public String getI18nDescriptive() {
        return this.i18nDescriptive
    }

    /**
     * Return the locale value as described by the iso standard.
     *
     * @return <code>String</code> the locale iso value of the
     * enumeration instance.
     */
    public String getLocalIsoValue() {
        return this.localeIsoValue
    }


}
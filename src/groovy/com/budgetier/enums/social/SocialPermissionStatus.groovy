package com.budgetier.enums.social

/**
 * Created by vbledar on 10/10/14.
 *
 * This enumeration lists all allowed social network permission statuses.
 */
public enum SocialPermissionStatus {

    GRANTED ('Granted', 'social.permission.status.granted'),    // defines granted permission status
    DECLINED ('Declined', 'social.permission.status.granted'),  // defines declined permission status

    private String descriptive                              // default human readable representation
    private String i18nDescriptive                          // i18n representation

    /**
     * Enumeration instance constructor. This constructor
     * will initialize the enumeration instance descriptive
     * value.
     *
     * @param descriptive, the value to set.
     */
    public SocialNetworkType(String descriptive, String i18nDescriptive) {
        this.descriptive = descriptive
        this.i18nDescriptive = i18nDescriptive
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

}
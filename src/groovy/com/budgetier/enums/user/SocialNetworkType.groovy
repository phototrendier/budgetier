package com.budgetier.enums.user

/**
 * Created by vbledar on 10/2/14.
 *
 * This enumeration lists the social networks a user can login
 * with.
 */
public enum SocialNetworkType {

    FACEBOOK ('Facebook', 'social.network.type.facebook'),  // defines a facebook user
    TWITTER ('Twitter', 'social.network.type.twitter'),     // defines a twitter user
    GOOGLE_PLUS ('Google+', 'social')                                 // defines a google plus user

    private String descriptive                              // default human readable representation
    private String i18nDescriptive                          // i18n representation

    /**
     * Enumeration instance constructor. This constructor
     * will initialize the enumeration instance descriptive
     * value.
     *
     * @param descriptive, the value to set.
     */
    public SocialNetworkType(String descriptive) {
        this.descriptive = descriptive
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
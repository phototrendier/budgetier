package com.budgetier.enums.user

/**
 * Created by vbledar on 10/5/14.
 */
public enum UserGenderType {

    MALE ("Male", "user.gender.male"),
    FEMALE ("Female", "user.gender.female"),
    OTHER ("Other", "user.gender.other")

    private String descriptive                              // default human readable representation
    private String i18nDescriptive                          // i18n representation

    /**
     * Enumeration instance constructor. This constructor
     * will initialize the enumeration instance descriptive
     * value.
     *
     * @param descriptive, the value to set.
     */
    public UserGenderType(String descriptive, String i18nDescriptive) {
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
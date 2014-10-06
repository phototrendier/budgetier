package com.budgetier.utilities

/**
 * Created by vbledar on 10/4/14.
 */
class EnumUtilityMethods {

    public static getEnumFromString(String value, enumeration) {
        for (e in enumeration.values()) {
            if (e.toString().equalsIgnoreCase(value)) {
                return e;
            }
        }
    }

}

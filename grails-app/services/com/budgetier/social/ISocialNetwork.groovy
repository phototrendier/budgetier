package com.budgetier.social

/**
 * Created by vbledar on 10/5/14.
 */
abstract class ISocialNetwork {

    abstract def getUserInformation(String accessToken)

    abstract def getUserFriendsList(String accessToken)

}

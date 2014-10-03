package untitled

import com.budgetier.domain.user.Person
import com.budgetier.enums.user.SocialNetworkType
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    def person

    def setup() {
        person = new Person()
        person.username = "test@test.com"
        person.firstName = "test"
        person.lastName = null
        person.email = person.username
        person.receiveNotifications = Boolean.FALSE
        person.socialNetworkType = SocialNetworkType.FACEBOOK
    }

    def cleanup() {
        person = null
    }

    void "person creation"() {
        setup:
        log.info "Nothing to setup here..."

        when:
        log.info "Persisting person instance in database..."
        person.save()

        then:
        log.info "Persisted person id is: " + person.id
        assertNotNull person.id
    }

    void "person creation failure"() {
        setup:
        log.info "Setting invalid value for person's email field..."
        person.email = "wrong email value"

        when:
        log.info "Persisting person instance in database..."
        person.save()

        then:
        boolean outcome = 0 == person.errors.getErrorCount()
        assert !outcome
    }
}

package io.x99.service

import io.x99.error.NotFoundException
import io.x99.model.UserEntity
import io.x99.repository.UserRepository
import org.assertj.core.util.Lists
import spock.lang.Specification

class PublisherSpec extends Specification {
    def userRepo = Mock(UserRepository)
    def userService = new UserService(userRepository: userRepo)

    def "userService.getAllUsers() must be invoked findAll()"() {
        when:
        def users = userService.getAllUsers()

        then:
        1 * userRepo.findAll() >> [new UserEntity()]
        users.size() == 1
    }

    def "userService.getUserById() must be invoked findById()"() {
        when:
        def user = userService.getUserById(1)

        then:
        1 * userRepo.findById(_) >> Optional.of(new UserEntity())
        user != null
    }

    def "userService must throw NotFoundException when is doesn't exist"() {
        when:
        userService.getUserById(1)

        then:
        1 * userRepo.findById(_) >> Optional.empty()
        thrown NotFoundException
    }


}

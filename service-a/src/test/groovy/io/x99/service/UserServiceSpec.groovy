package io.x99.service

import io.x99.error.NotFoundException
import io.x99.model.UserEntity
import io.x99.repository.UserRepository
import spock.lang.Specification

class UserServiceSpec extends Specification {
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

    def "userService.getUserById() must throw NotFoundException when the id doesn't exist"() {
        when:
        userService.getUserById(1)

        then:
        1 * userRepo.findById(_) >> Optional.empty()
        thrown NotFoundException
    }

    def "userService.addUser() must be invoked save()"() {
        given:
        String name = "NewUser"
        String country = "LK"

        when:
        def user = userService.addUser(name, country)

        then:
        1 * userRepo.save(_ as UserEntity) >> { args ->
            assert args[0].name == name && args[0].country == country
            return args[0]
        }
        user != null
        user.name == name
        user.country == country
    }

    def "userService.deleteUser() must be invoked deleteById()"() {
        when:
        def user = userService.deleteUser(1)

        then:
        1 * userRepo.deleteById(_) >> Optional.of(new UserEntity())
        user != null
    }

    def "userService.deleteUser() must throw NotFoundException when the id doesn't exist"() {
        when:
        userService.deleteUser(1)

        then:
        1 * userRepo.deleteById(_) >> Optional.empty()
        thrown NotFoundException
    }

}

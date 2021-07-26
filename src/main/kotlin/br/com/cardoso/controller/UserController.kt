package br.com.cardoso.controller

import br.com.cardoso.entity.User
import br.com.cardoso.model.FinalUser
import br.com.cardoso.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(val userRepository: UserRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun addUser(@RequestBody user: User) = userRepository.save(user).id

    @GetMapping
    fun getAllUsers(): MutableList<FinalUser> {
        val allUsers = userRepository.findAll()
        val finalUsers = mutableListOf<FinalUser>()
        for (user in allUsers) {
            finalUsers.add(FinalUser(user.name, user.age, (allUsers as Collection<*>).size))
        }
        return finalUsers
    }
}
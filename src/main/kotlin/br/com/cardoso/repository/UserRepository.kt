package br.com.cardoso.repository

import br.com.cardoso.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
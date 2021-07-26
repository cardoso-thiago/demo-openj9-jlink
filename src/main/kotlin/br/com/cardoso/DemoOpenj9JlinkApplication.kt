package br.com.cardoso

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoOpenj9JlinkApplication

fun main(args: Array<String>) {
	runApplication<DemoOpenj9JlinkApplication>(*args)
}

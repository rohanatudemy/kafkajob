package com.example.kafkajob

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkajobApplication

fun main(args: Array<String>) {
	runApplication<KafkajobApplication>(*args)
}

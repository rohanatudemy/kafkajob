package com.example.kafkajob.jobs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
@ConditionalOnProperty("kafka.producer.enabled", matchIfMissing = false)
class Publisher: CommandLineRunner {
    companion object {
        private val logger = org.slf4j.LoggerFactory.getLogger(Publisher::class.java)
    }

    @Autowired
    lateinit var kafkaTemplate: KafkaTemplate<String, String>

    override fun run(vararg args: String?) {
        val message = "Hello, Kafka!".repeat(100)
        for (i in 1..100000) {
            // logger.info("Sending message $i: $message")
            kafkaTemplate.send("kafka-debug", "key-$i....$message")
        }
    }
}
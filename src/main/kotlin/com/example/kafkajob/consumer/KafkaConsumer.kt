package com.example.kafkajob.consumer

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("kafka.consumer.enabled", matchIfMissing = false)
class KafkaConsumer {
    @KafkaListener(topics = ["kafka-debug"], groupId = "group-1")
    fun listen(message: String) {
        println("Received Message : $message")
    }
}
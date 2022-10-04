package io.vels.kafka.basic.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
@Slf4j
public class KafkaBasicConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBasicConsumerApplication.class, args);
	}

	@Bean
	public Consumer<Integer> numberConsumer() {
		return incomingNumber -> log.info("Incoming Number : {}", incomingNumber);
	}

	@Bean
	public Function<Integer, Double> consumeAndProcessSqrt() {
		return Math::sqrt;
	}

	@Bean
	public Function<Integer, Double> consumeAndProcessCube() {
		return incomingNumber -> Math.pow(incomingNumber, 3);
	}

}

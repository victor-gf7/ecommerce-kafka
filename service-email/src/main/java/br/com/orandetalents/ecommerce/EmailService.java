package br.com.orandetalents.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.HashMap;

public class EmailService {
    public static void main(String[] args) {
        var emailService = new EmailService();
        try(var service = new KafkaService(EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL", emailService::parse,
                Email.class, new HashMap<>())){
            service.run();
        }
    }

    private void parse(ConsumerRecord<String, Email> record) {
        System.out.println("___________________________________________");
        System.out.println("Send email");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //ignoring
            e.printStackTrace();
        }
        System.out.println("Email sent");
    }
}

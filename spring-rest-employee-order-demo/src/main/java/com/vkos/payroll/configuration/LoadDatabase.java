package com.vkos.payroll.configuration;

import com.vkos.payroll.enums.Status;
import com.vkos.payroll.entity.Employee;
import com.vkos.payroll.entity.Order;
import com.vkos.payroll.repository.EmployeeRepository;
import com.vkos.payroll.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("person", "one", "role1"));
            employeeRepository.save(new Employee("person", "two", "role2"));
            employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("order1", Status.COMPLETED));
            orderRepository.save(new Order("order2", Status.IN_PROGRESS));
            orderRepository.findAll().forEach(order -> log.info("Preloaded " + order));
        };
    }
}

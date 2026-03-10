package au.nsw.revenue.revenue_case_api;

import org.springframework.boot.SpringApplication;

public class TestRevenueCaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(RevenueCaseApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

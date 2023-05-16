package CinemaBookingsFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing

@SpringBootApplication
public class CinemaBookingsFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaBookingsFinalApplication.class, args);
	}
	public int findIndex(int[] arr, int number){
		int index = -1;
		for (int i=0;i<arr.length;i++){
			if(arr[i]==number)
				return i;
		}
		return -1;
	}
}

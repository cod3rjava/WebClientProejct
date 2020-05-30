package in.nit.RestController;


import javax.annotation.PostConstruct;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import ch.qos.logback.core.util.Duration;
import in.nit.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class WebClientRestController {
	private WebClient webClient;
@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl("http://localhost:9898/rest")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	@PostMapping("/saveStudent")
	public Mono<String> saveStudent(@RequestBody Student student) {
		return webClient.post().uri("/save").syncBody(student).retrieve().bodyToMono(String.class);
	}

	@GetMapping("/getStudent")
	public Flux<Student> getAllStudent() {
		return webClient.get().uri("/all").retrieve()
				.bodyToFlux(Student.class).timeout(java.time.Duration.ofMillis(10000));
		

	}

	@GetMapping("/one/{id}")
	public Mono<Student> getOneStudent(@PathVariable Integer id) {
		return webClient.get().uri("/one/" + id).retrieve()
				.bodyToMono(Student.class).timeout(Duration.(10_000));
	}

	public Mono<String> detletStudentById(@PathVariable Integer id) {
		return webClient.delete().uri("/remove/" + id).retrieve().bodyToMono(String.class);
	}
	/*
	 * public Mono<String> detletStudentById(@PathVariable Integer id){ return
	 * webClient.put().uri("/update").retrieve().bodyToMono(String.class); }
	 */
}

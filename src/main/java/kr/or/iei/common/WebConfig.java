package kr.or.iei.common;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;

// 스프링 IoC 컨테이너가 초기화될 때 실행
@Configuration
public class WebConfig implements WebMvcConfigurer {
	/*
	 * WebMvcConfigurer : Spring MVC 설정을 사용자 정의할 수 있음. 인터페이스 내부에 메서드는 접근제어지시자가
	 * default 로 작성되어 있기 때문에, 원하는 메서드만 선택적으로 오버라이딩. URL 매핑 View, Filter, WebSocket,
	 * Interceptor 등등 원하는 설정에 따라 다양한 인터페이스의 메소드를 오버라이딩.
	 */

	// 필터 설정
	// Bean(객쳬)으로 등록
	@Bean
	public FilterRegistrationBean<Filter> EncodingFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new kr.or.iei.common.filter.EncodingFilter()); // 등록할 필터 클래스
		filterRegistrationBean.setOrder(1); // 수행 순서 (필터 여러개 생성 가능하니)
		filterRegistrationBean.addUrlPatterns("/*"); // 적용 URL 패턴

		return filterRegistrationBean;
	}

	// 웹 소켓 설정
	// 클래스 상단에 @EnableWebSocket 추가 및 WebSocketConfigurer implements

//	@Autowired
	// 이 클래스는 핸들러 클래스! 채팅 기능 만들어서 줬었던 파일 (SocketHandler.java)
//	private SocketHandler chatSocketHandler;
//
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		// 특정 URL 패턴에 동작할 핸들러 등록
//		registry.addHandler(chatSocketHandler, "/chat/*");
//	}

	// 요청 URL 에 따른, View 설정
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
////	   예시) 루트로 요청 시 index.jsp 반환할 수 있도록.
////	   로직 처리 없이, 단순 페이지 이동 시 유용하게 사용 가능
//
//       registry.addViewController("/").setViewName("index");
//	}

}

package com.fivegirls.burger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestRestController {
	
	@GetMapping("/test")
	public String test() { 
		return ".............test";
	}
	
	 // POST 요청 처리
    @PostMapping("/submit")
    public String submit(@RequestBody InputRequest inputRequest) {
        // 콘솔에 입력된 값을 출력
        System.out.println("Received input: " + inputRequest.getInput());
        return "Input received: " + inputRequest.getInput();
    }

    // 요청 데이터 형식을 위한 DTO 클래스
    public static class InputRequest {
        private String input;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }
    }
}

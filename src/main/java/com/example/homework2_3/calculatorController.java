package com.example.homework2_3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class calculatorController {

private final calculatorService calculator;

public calculatorController(calculatorService calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/")
    public String greating() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " + " + num2 + " = " + calculator.plus(num1, num2);
    }
    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " - " + num2 + " = " + calculator.minus(num1, num2);
    }
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return num1 + " * " + num2 + " = " + calculator.multiply(num1, num2);
    }
    @GetMapping("/calculator/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0){
            return  "Делить на 0 НЕЛЬЗЯ!";
        }
        return num1 + " / " + num2 + " = " + calculator.divide(num1, num2);
    }

}

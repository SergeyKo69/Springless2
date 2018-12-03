package ru.kogut.components;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ru.kogut.components","ru.kogut.components.lifecycle"})
public class AppConfig {
}

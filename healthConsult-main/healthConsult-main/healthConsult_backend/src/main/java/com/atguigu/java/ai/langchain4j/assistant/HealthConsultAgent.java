package com.atguigu.java.ai.langchain4j.assistant;
import dev.langchain4j.service.*;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;
@AiService(
    wiringMode = EXPLICIT,
    streamingChatModel = "qwenStreamingChatModel",
    chatMemoryProvider = "chatMemoryProviderHealthConsult",
    tools = "appointmentTools",
    contentRetriever = "contentRetrieverHealthConsultPincone" //配置向量存储
)
public interface HealthConsultAgent {
    @SystemMessage(fromResource = "xhaozhi-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage);
}

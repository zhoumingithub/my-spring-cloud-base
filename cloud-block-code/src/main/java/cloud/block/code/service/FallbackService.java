package cloud.block.code.service;

import org.springframework.stereotype.Component;

@Component
public class FallbackService implements GetAuthorService {

    @Override
    public String getAuthorInfo(String authorId) {
        return "服务被熔断"+authorId;
    }
}

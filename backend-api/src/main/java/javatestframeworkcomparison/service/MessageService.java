package javatestframeworkcomparison.service;

public interface MessageService {
    void sendMessage(String to, String subject, String content, boolean isHtmlContent);
}

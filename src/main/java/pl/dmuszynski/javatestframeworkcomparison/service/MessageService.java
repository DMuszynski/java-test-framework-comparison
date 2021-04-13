package pl.dmuszynski.javatestframeworkcomparison.service;

public interface MessageService {
    void sendMessage(String to, String subject, String content, boolean isHtmlContent);
}

package co.edu.taller.creational;

public class NotificationFactory {

    public interface Notifier {
        String send(String recipient, String message);
    }

    public enum Channel {
        EMAIL,
        SMS
    }

    public Notifier create(Channel channel) {

        if (channel == null) {
            throw new IllegalArgumentException("Channel is required");
        }

        switch (channel) {

            case EMAIL:
                return (recipient, message) ->
                        "EMAIL:" + recipient + ":" + message;

            case SMS:
                return (recipient, message) ->
                        "SMS:" + recipient + ":" + message;

            default:
                throw new IllegalArgumentException("Unsupported channel");
        }
    }
}
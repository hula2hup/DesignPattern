interface Participant {
    void sendMessage(String message);
    void receiveMessage(String message, String sender);
    String getName();
}

class VideoConferenceMediator {
    private java.util.HashMap<String, Participant> participants = new java.util.HashMap<>();

    public void addParticipant(Participant participant) {
        participants.put(participant.getName(), participant);
        System.out.println(participant.getName() + " has joined the conference.");
    }

    public void sendMessage(String message, Participant sender) {
        for (Participant participant : participants.values()) {
            if (!participant.getName().equals(sender.getName())) {
                participant.receiveMessage(message, sender.getName());
            }
        }
    }
}

class ConferenceUser implements Participant {
    private String name;
    private VideoConferenceMediator mediator;

    public ConferenceUser(String name, VideoConferenceMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public void sendMessage(String message) {
        System.out.println(name + " is sending: " + message);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message, String sender) {
        System.out.println(name + " received from " + sender + ": " + message);
    }

    public String getName() {
        return name;
    }
}

public class MediatorVideoConference {
    public static void main(String[] args) {
        VideoConferenceMediator mediator = new VideoConferenceMediator();
        Participant user1 = new ConferenceUser("User1", mediator);
        Participant user2 = new ConferenceUser("User2", mediator);
        mediator.addParticipant(user1);
        mediator.addParticipant(user2);
        user1.sendMessage("Starting meeting now!");
    }
}
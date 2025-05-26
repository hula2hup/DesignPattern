class SessionManager {
    private static SessionManager instance;
    private String userId;
    private boolean isActive;
    private SessionManager() { this.userId = "default"; this.isActive = false; }
    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    public void login(String userId) {
        this.userId = userId;
        this.isActive = true;
        System.out.println("User " + userId + " logged in");
    }
    public void logout() {
        this.isActive = false;
        System.out.println("Session for " + userId + " logged out");
    }
    public String getUserId() { return userId; }
}

public class SingletonSessionManager {
    public static void main(String[] args) {
        SessionManager session1 = SessionManager.getInstance();
        SessionManager session2 = SessionManager.getInstance();
        session1.login("user123");
        session2.logout();
        System.out.println("Same instance: " + (session1 == session2)); // true
    }
}
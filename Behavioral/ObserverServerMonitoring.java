interface ServerObserver {
    void updateStatus(String serverId, String status, double load);
}

class ServerMonitor {
    private java.util.HashMap<String, ServerObserver> observers = new java.util.HashMap<>();
    public void addObserver(String serverId, ServerObserver observer) {
        observers.put(serverId, observer);
    }
    public void notifyStatus(String serverId, String status, double load) {
        ServerObserver observer = observers.get(serverId);
        if (observer != null) observer.updateStatus(serverId, status, load);
    }
}

class AdminDashboard implements ServerObserver {
    private String adminName;
    public AdminDashboard(String adminName) { this.adminName = adminName; }
    public void updateStatus(String serverId, String status, double load) {
        System.out.println(adminName + " notified: Server " + serverId + " is " + status + " with load " + load + "%");
    }
}

public class ObserverServerMonitoring {
    public static void main(String[] args) {
        ServerMonitor monitor = new ServerMonitor();
        AdminDashboard admin1 = new AdminDashboard("Admin1");
        monitor.addObserver("Server01", admin1);
        monitor.notifyStatus("Server01", "Overloaded", 85.5);
    }
}
import java.io.Serializable;

class Task implements Serializable {  // Serializable allows saving the task to a file
    private static final long serialVersionUID = 1L;
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // Mark task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Get description of task
    public String getDescription() {
        return description;
    }

    // Check if task is completed
    public boolean isCompleted() {
        return isCompleted;
    }

    // Convert task to string format for display
    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description;
    }
}


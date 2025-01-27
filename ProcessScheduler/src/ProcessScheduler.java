//LILY DELLER
class ProcessScheduler {
    private LLQueue<Process> processes;
    private Process currentProcess;

    // our constructor
    ProcessScheduler() {
        processes = new LLQueue<>();
        currentProcess = null;
    }

    // getter
    public Process getCurrentProcess() {
        return currentProcess;
    }

    // this method will add a process
    public void addProcess(Process process) {
        if (currentProcess == null) {
            currentProcess = process;
        } else {
            processes.enqueue(process);
        }
    }

    // this method will run next process
    public void runNextProcess() {
        currentProcess = processes.dequeue();
    }

    // this method will cancel current process
    public void cancelCurrentProcess() {
        if (currentProcess != null) {
            currentProcess = processes.dequeue();
        }
    }

    // this method will print process queue
    public void printProcessQueue() {
        processes.print();
    }
}
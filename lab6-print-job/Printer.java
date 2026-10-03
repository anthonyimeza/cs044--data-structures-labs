

public class Printer {
    private Queue<PrintJob> jobQueue;

    public Printer() {
        //Initialize queue
        jobQueue = new LinkedQueue<PrintJob>();
    }
    //Adds job to rear of queue
    public void addJob(PrintJob job) {
        System.out.println("Adding to queue: " + job);
        jobQueue.enqueue(job);
    }

    /**
     * Processes the job at the front of the queue.
     */
    public void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("No print jobs in queue.");
        } else {
            PrintJob jobToPrint = jobQueue.dequeue();
            System.out.println("Processing: " + jobToPrint);
        }
    }


    public static void main(String[] args) {
        Printer officePrinter = new Printer();

        officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
        officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
        officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

        System.out.println("\n--- Starting to Print ---");
        officePrinter.processNextJob(); // Should print Annual_Report.pdf
        officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

        System.out.println("\nNew high-priority job arrives...");
        officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

        officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
        officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
        officePrinter.processNextJob(); // Should say the queue is empty
    }
}

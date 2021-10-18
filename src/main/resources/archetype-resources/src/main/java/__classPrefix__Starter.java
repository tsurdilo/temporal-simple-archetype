package $package;

import io.temporal.client.WorkflowOptions;

public class ${classPrefix}Starter {
    public static void main(String[] args) {

        // Create the workflow stub
        ${classPrefix}Workflow workflow =
                ${classPrefix}Worker.client.newWorkflowStub(
                        ${classPrefix}Workflow.class,
                        WorkflowOptions.newBuilder()
                                .setTaskQueue(${classPrefix}Worker.TASK_QUEUE)
                                .build());

        // Start workflow execution and wait for it to complete
        String greeting = workflow.getGreeting("World");

        System.out.println("Greeting: " + greeting);
        System.exit(0);
    }
}

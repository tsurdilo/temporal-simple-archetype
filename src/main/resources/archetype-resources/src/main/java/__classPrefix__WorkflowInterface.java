package $package;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ${classPrefix}WorkflowInterface {

    /**
     * WorkflowMethod is executed when the workflow execution is started.
     * Workflow execution completes when this method finishes execution.
     */
    @WorkflowMethod
    String getGreeting(String name);
}

package $package;

import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class ${classPrefix}WorkflowTest {

    @Rule
    public TestWorkflowRule testWorkflowRule =
            TestWorkflowRule.newBuilder()
                    .setWorkflowTypes(${classPrefix}Workflow.class)
                    .setDoNotStart(true)
                    .build();

    @Test
    public void testActivity() {

        testWorkflowRule.getWorker().registerActivitiesImplementations(new ${classPrefix}Activity());
        testWorkflowRule.getTestEnvironment().start();

        // Get a workflow stub using the same task queue the worker uses.
        ${classPrefix}WorkflowInterface workflow =
                testWorkflowRule
                        .getWorkflowClient()
                        .newWorkflowStub(
                                ${classPrefix}WorkflowInterface.class,
                                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build());
        // Execute a workflow waiting for it to complete.
        String greeting = workflow.getGreeting("World");
        assertEquals("Hello World!", greeting);

        testWorkflowRule.getTestEnvironment().shutdown();
    }

    @Test
    public void testMockedActivity() {
        // withoutAnnotations() is required to stop Mockito from copying
        // method-level annotations from the GreetingActivities interface
        ${classPrefix}ActivityInterface activities =
                mock(${classPrefix}ActivityInterface.class, withSettings().withoutAnnotations());
        when(activities.greet("Hello", "World")).thenReturn("Hello World!");
        testWorkflowRule.getWorker().registerActivitiesImplementations(activities);
        testWorkflowRule.getTestEnvironment().start();

        // Get a workflow stub using the same task queue the worker uses.
        ${classPrefix}WorkflowInterface workflow =
                testWorkflowRule
                        .getWorkflowClient()
                        .newWorkflowStub(
                                ${classPrefix}WorkflowInterface.class,
                                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build());
        // Execute a workflow waiting for it to complete.
        String greeting = workflow.getGreeting("World");
        assertEquals("Hello World!", greeting);

        testWorkflowRule.getTestEnvironment().shutdown();
    }
}
package $package;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface ${classPrefix}ActivityInterface {

    // Activity method which can be called during workflow execution
    @ActivityMethod
    String greet(String greeting, String name);
}

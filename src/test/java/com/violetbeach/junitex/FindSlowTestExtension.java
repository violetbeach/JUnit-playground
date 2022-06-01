package com.violetbeach.junitex;

import jdk.jfr.Threshold;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import javax.xml.stream.events.Namespace;
import java.lang.reflect.Method;

public class FindSlowTestExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final long Threshold = 1000L;

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        ExtensionContext.Store store = getStore(extensionContext);
        store.put("START_TIME", System.currentTimeMillis());
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
        String testClassName = extensionContext.getRequiredTestClass().getName();
        String testMethodName = extensionContext.getRequiredTestMethod().getName();
        ExtensionContext.Store store = extensionContext.getStore(ExtensionContext.Namespace.create(testClassName, testMethodName));
        return store;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        Method requiredTestMethod = extensionContext.getRequiredTestMethod();
        SlowTest annotation = requiredTestMethod.getAnnotation(SlowTest.class);
        String testMethodName = extensionContext.getRequiredTestMethod().getName();
        ExtensionContext.Store store = getStore(extensionContext);
        Long startTime = store.remove("START_TIME", long.class);
        long duration = System.currentTimeMillis() - startTime;
        if (duration > Threshold && annotation == null) {
            System.out.printf("Please consider mark method [%s] with @SlowTest. \n", testMethodName);
        }
    }
}

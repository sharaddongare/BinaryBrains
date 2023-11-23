package com.generalUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class is used to store test case or scenario level data. If you want to share data across different steps, then this class can be used.
 * This class contains methods such as get/set context , get/set property etc.
 *
 * @param <T>
 */
public class TestContext<T> extends HashMap<String, T> {

    private static ThreadLocal<TestContext> contextThreadLocal = ThreadLocal.withInitial(TestContext::new);

    /**
     * private constructor to prevent instantiation in other class.
     */
    private TestContext() {
        super();
    }

    /**
     * This method is used to get the current context instance local to the thread
     *
     * @param contextThreadLocal
     */
    private static void setContextThreadLocal(TestContext contextThreadLocal) {
        TestContext.contextThreadLocal.set(contextThreadLocal);
    }

    /**
     * This method is used to get context object
     *
     * @return
     */
    private static TestContext getContextThreadLocal() {
        return contextThreadLocal.get();
    }

    /**
     * This method is used to get instance of this class
     *
     * @return - TextContext
     */
    public static TestContext getInstance() {
        return getContextThreadLocal();
    }

    /**
     * Used to cleanup the thread local instance
     */
    public void unload() {
        contextThreadLocal.remove();
    }

    /**
     * This method is used to set value of property
     *
     * @param property - property key param name to set value in to property
     * @param value    - Actual value of property key param
     */
    public void setProperty(String property, T value) {
        this.put(property, value);
    }

    /**
     * This method is used to get value of the property.
     *
     * @param property
     * @return
     */
    public T getProperty(String property) {
        var propertyValue = this.get(property);
        if (!Objects.isNull(propertyValue)) {
            return propertyValue;
        } else {
            return null;
        }
    }

    /**
     * This method is used to get the set of all properties.
     *
     * @return keySet of properties
     */
    public Set<String> getPropertiesSet() {
        return this.keySet();
    }

    /**
     * This method is used to get properties of map
     *
     * @return Map - properties
     */
    public Map<String, T> getPropertiesMap() {
        return this;
    }

    /**
     * This method is used to check if the property exists in the context
     *
     * @param propertyName
     * @return boolean
     */
    public boolean isPropertiesPresent(String propertyName) {
        return this.get(propertyName) != null;
    }
}

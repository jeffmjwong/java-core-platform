package com.pluralsight.javacoreplatform;

public class MyClass {
    private String label;
    private String value;

    public String getLabel() {
        return this.label;
    }
    public String getValue() {
        return this.value;
    }

    public MyClass(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return label + " | " + value;
    }

    @Override
    public boolean equals(Object obj) {
        MyClass other = (MyClass) obj;
        return this.getValue().equalsIgnoreCase(other.getValue());
    }
}

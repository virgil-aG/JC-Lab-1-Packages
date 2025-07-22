package org.example.packageone;

import org.example.packagethree.ClassThree;
import org.example.packagetwo.ClassTwo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClassOneTest {
    private ClassOne classOne;
    private ClassTwo classTwo;
    private ClassThree classThree;

    private static final String CSV_FILE = "test-results.csv";
    private static boolean headerWritten = false;

    @BeforeEach
    void setup() {
        classOne = new ClassOne();
        classTwo = new ClassTwo();
        classThree = new ClassThree();
    }

    @BeforeAll
    static void initializeCSV() {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            writer.append("Test Name,Expected Output,Actual Output,Status,Timestamp\n");
            headerWritten = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldReturnHelloFromClassOne() {
        String testName = "shouldReturnHelloFromClassOne";
        String expected = "Hello from Class one";
        String actual = classOne.greet();
        logToCSV(testName, expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnHelloFromClassTwo() {
        String testName = "shouldReturnHelloFromClassTwo";
        String expected = "Hello from Class two";
        String actual = classTwo.greet();
        logToCSV(testName, expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnHelloFromClassThree() {
        String testName = "shouldReturnHelloFromClassThree";
        String expected = "Hello from Class three";
        String actual = classThree.greet();
        logToCSV(testName, expected, actual);
        assertEquals(expected, actual);
    }

    private void logToCSV(String testName, String expected, String actual) {
        String status = expected.equals(actual) ? "PASS" : "FAIL";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(String.format("%s,%s,%s,%s,%s\n",
                    testName,
                    expected,
                    actual,
                    status,
                    timestamp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
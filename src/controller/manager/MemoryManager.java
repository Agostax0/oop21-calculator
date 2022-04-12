package controller.manager;

import java.util.List;

/**
 * Interface for the memory manager.
 */
public interface MemoryManager {
    /**
     * Appends a given string to the input buffer.
     * @param s Input string to be read
     */
    void read(String s);

    /**
     * Appends all the strings in the given list to the input buffer.
     * @param list List of strings to append
     */
    void readAll(List<String> list);

    /**
     * Returns the current state of the input buffer. After a calculation it returns the result.
     * @return List containing the strings given as inputs.
     */
    List<String> getCurrentState();

    /**
     * Sets a string as the only element of the input buffer.
     * @param s String to set the current state to.
     */
    void setCurrentState(String s);

    /**
     * Removes all elements from input buffer.
     */
    void clear();

    /**
     * Removes last element in the input buffer.
     */
    void deleteLast();

    /**
     * Clears the input buffers and reads each character individually. 
     * @param s
     */
    void splitAndSetCurrentState(String s);
}
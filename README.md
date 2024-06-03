# Thread Synchronization Example

This repository contains an example of thread synchronization in Java. The example demonstrates how to handle critical sections, mutual exclusion, and progress using `synchronized` blocks and semaphores. This application is prepared for learning how to use Thread in Java.

## Overview

In this example, we have two threads: a producer and a consumer. The producer increments a shared variable, and the consumer decrements it. To ensure that these operations do not interfere with each other and cause race conditions, we use synchronization techniques.

### Files

- `osThread.java`: The main class that initializes and starts the producer and consumer threads.
- `Producers.java`: The producer thread class that increments the shared variable.
- `Consumer.java`: The consumer thread class that decrements the shared variable.
- `Data.java`: A class that holds the shared variable and a semaphore flag for synchronization.

## How to Run

1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/thread-synchronization-example.git
    ```

2. Navigate to the project directory:
    ```bash
    cd thread-synchronization-example
    ```

3. Compile the Java files:
    ```bash
    javac osThread.java Producers.java Consumer.java Data.java
    ```

4. Run the main class:
    ```bash
    java osThread
    ```

## Explanation

### Synchronization

- `synchronized(d) { ... }`: Ensures that only one thread can execute the block at a time.
- `semaphore`: A boolean flag used to manage the order of execution between the producer and consumer.

### Critical Section Problem

The code solves the critical section problem using the following techniques:
- **Mutual Exclusion**: Achieved using the `synchronized` block.
- **Progress**: Managed using the `semaphore` flag to ensure the correct order of operations.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

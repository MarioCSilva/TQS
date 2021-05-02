### 1. e/ Has your project passed the defined quality gate? Elaborate your answer

##### The project passed the quality gate, however this is because the default quality gate from Sonar Qube follows the rule Clean as you Code, which means that the overall code isn't evaluated and only the newly added code is actually evaluated by the quality gate. In the overall code there were many improvements to be made.

### 1. f/ Explore the analysis results and complete with a few sample issues, as applicable.

| ISSUE              | PROBLEM DESCRIPTION                                          | HOW TO SOLVE                                                 |
| ------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| BUG                | "Random" objects should be reused. Creating a new `Random` object each time a random value is needed is inefficient and may produce numbers which are not random depending on the JDK. For better efficiency and randomness, create a single `Random`, then store, and reuse it. | Save and re-use the "Random" object created.                 |
| VULNERABILITY      | Weak Cryptography. "Random" pseudorandom number generator might not be safe. | Use "SecureRandom" instead.                                  |
| CODE SMELL (major) | The loop counter is assigned at the body of the loop. "for" loop stop conditions should be invariant. A `for` loop stop condition should test the loop counter against an invariant value. Ideally, this means that the stop condition is set to a local variable just before the loop begins. | Assign the loop counter at the begining.                     |
| CODE SMELL (major) | Standard outputs should not be used directly to log anything. If a program directly writes to the standard outputs, there is absolutely no way to comply with those requirements. That's why defining and using a dedicated logger is highly recommended. | Replace  System.out or System.err by a logger.               |
| CODE SMELL (major) | "Preconditions" and logging arguments should not require evaluation. | Structure your code to pass static or pre-computed values into `Preconditions` conditions check and logging calls. Invoke method(s) only conditionally. |
| CODE SMELL (major) | JUnit assertTrue/assertFalse should be simplified to the corresponding dedicated assertion. The code was assertTrue and then checked if equals inside. | Use assertEquals instead.                                    |



### 2. a/ Take note of the technical debt found. Explain what this value means.

##### The techincal debt found was of 2 hours. **Technical debt** is an estimation of the time it will cost to fix and refactor the code to make it completely clean and with better approaches.

### 2. d/Run the static analysis and observe/explore the coverage values on the SonarQube dashboard. How many lines are “uncovered”? And how many conditions?

##### 237 lines of code, 69.5% coverage, 4 minor code smells and 14 info code smells. CuponEuromillians had the less coverage since it lacked a few tests to format function, the Dip and EuromillionsDraw also missed a few small tests.

### 3.

##### After running the Sonar Qube on the IES project, it passes the default quality gate:

![geanihouse_overview](/Users/mario/Desktop/TQS/lab6/images/geanihouse_overview.png)

##### It had 281 Code Smells with around 4 days of debt:

![geanihouse_code_smells](/Users/mario/Desktop/TQS/lab6/images/geanihouse_code_smells.png)

##### Also had 14 Vulnerabilities:

![geanihouse_vulnerabilities](/Users/mario/Desktop/TQS/lab6/images/geanihouse_vulnerabilities.png)

##### And also 13 Security Hotspots:

![geanihouse_security_hotspot](/Users/mario/Desktop/TQS/lab6/images/geanihouse_security_hotspot.png)

3. ### a/

##### We defined the following quality gate:

![geanihouse_quality_gate](/Users/mario/Desktop/TQS/lab6/images/geanihouse_quality_gate.png)

##### This quality gate will check on the overall code if the number of bugs are greater than 0, code smells more than 200, coverage less than 80%, duplicated blocks above 10 and vulnerabilities more than 0. If any of these conditions are true then it will fail. Has we can see from the above pictures it will obviously fail on some of them.

![geanihouse_failed_quality_gate](/Users/mario/Desktop/TQS/lab6/images/geanihouse_failed_quality_gate.png)

##### As expected it failed on 4 of the 5 conditions, having only passed by having less than 11 duplicated blocks.
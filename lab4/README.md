# Lab4

## **1/**

### **a)** Identify a couple of examples on the use of AssertJ expressive methods chaining.

Chaining methods in class *EmployeeRepositoryTest*:

```
assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
```

### **b)** Identify an example in which you mock the behavior of the repository (and avoid involving a database).

Mock the behaviour of the repository in class *EmployeeService_UnitTest*:

```
Mockito.when(employeeRepository.findByName(john.getName())).thenReturn(john);    Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex);        Mockito.when(employeeRepository.findByName("wrong_name")).thenReturn(null);        Mockito.when(employeeRepository.findById(john.getId())).thenReturn(Optional.of(john));
Mockito.when(employeeRepository.findAll()).thenReturn(allEmployees);        Mockito.when(employeeRepository.findById(-99L)).thenReturn(Optional.empty());
```

### **c)** What is the difference between standard @Mock and @MockBean?

The standard @Mock anotation is used in test classes to mock the behaviour of a certain class or interface, it allows to return values and verify if methods were called. It is mostly used in unit tests since it is fast and favours the isolation of the tested component.

The @MockBean anotation is used by Spring Boot to add mock objects to the application context (dependency injection), it replaces any existing bean of the same type in the application context. It is mostly used in integration tests that rely on the Spring Boot Container where a container bean needs to be mocked, for example, interaction with services.

### **d)** What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

In some tests it’s necessary to set some configuration properties to a value that’s different from the value in a production settings, such as database settings (username, password, ...). This settings are loaded into the application context with the help of the annotation `@TestPropertySource` that configures the locations of properties files that need to be loaded to the application context. 

## **3/**

### Docker command to run a mysql DB instance

```
docker run --name mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=tqscardemo -e MYSQL_USER=admin -e MYSQL_PASSWORD=password -p 33060:3306 -d mysql/mysql-server:8.0.22
```


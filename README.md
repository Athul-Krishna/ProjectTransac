# ProjectTransac
Distributed event-driven microservices based on CQRS, Event Sourcing, SAGA and Transactions

The project follows the spring boot microservices architecture.
This allows multiple instances of the microservice behind an **API Gateway** and make them discoverable. 
This will help scale the microservice up and down as needed.

The project also cover **Transactions** across multiple distributed microservices and to roll back changes if an error took place.
The project uses a modern and very popular framework for building event-based microservices called Axon. 
**Axon Framework** is based on design principles such as **CQRS(Command Query Responsibility Segregation)** and **DDD(Domain Driven Design)**.

The project also implements the **Saga design pattern** to group multiple operations into a single transaction. 
This will help build business logic that spans multiple distributed microservices and roll back changes if one operation fails.

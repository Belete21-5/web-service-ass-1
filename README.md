# ShapeTool SOAP Web Service

## Project Overview
A Spring Boot-based SOAP Web Service that calculates the area of various geometric shapes: such as:-
Circle, Square, Rectangle, Parallelogram, and Triangle.

## Technologies Used
* Java 21
* Spring Boot 4.0.5
* Spring Web Services
* JAXB (for XSD to Java mapping)
* Maven

## Mathematical Formulas
* **Circle**: $\pi \times radius^2$
* **Square**: $side^2$
* **Rectangle**: $length \times width$
* **Parallelogram**: $base \times height$
* **Triangle**: $0.5 \times base \times height$

## Input Validation
The service implements a **Contract-First** approach. Input validation is handled at the XSD level using `xs:minInclusive value="0"` to prevent negative input values. A `PayloadValidatingInterceptor` is configured to intercept invalid requests and return a SOAP Fault.

## How to Run
1. Clone the repository.
2. Run `./mvnw spring-boot:run` or start `ShapeApplication.java` in IntelliJ.
3. Access the WSDL at: `http://localhost:8080/ws/shapetool.wsdl`

## Sample Request (Circle Area)
```xml
<soapenv:Envelope xmlns:soapenv="[http://schemas.xmlsoap.org/soap/envelope/](http://schemas.xmlsoap.org/soap/envelope/)" xmlns:gs="[http://woldia.edu/shapetool](http://woldia.edu/shapetool)">
   <soapenv:Body>
      <gs:CircleAreaRequest>
         <gs:radius>10.0</gs:radius>
      </gs:CircleAreaRequest>
   </soapenv:Body>
</soapenv:Envelope>

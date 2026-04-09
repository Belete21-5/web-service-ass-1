# ShapeTool SOAP Web Service

## Project Overview
This project is a **SOAP Web Service** developed as part of a Web Services assignment. It provides a set of tools to calculate the surface area of various geometric shapes. The project follows a **Contract-First** development approach, utilizing an XSD schema to define the data structures and validation rules.

## Technologies Used
* **Java 21**
* **Spring Boot 4.0.5**
* **Spring Web Services**
* **JAXB** (for XML-to-Java binding)
* **Maven** (for dependency management and build automation)

## Mathematical Formulas Implemented
The service calculates the area for the following shapes:

| Shape | Mathematical Formula |
| :--- | :--- |
| **Circle** | $Area = \pi \times r^2$ |
| **Square** | $Area = side^2$ |
| **Rectangle** | $Area = length \times width$ |
| **Parallelogram** | $Area = base \times height$ |
| **Triangle** | $Area = 0.5 \times base \times height$ |

## Input Validation & Error Handling
To ensure data integrity, the service implements strict validation:
* **XSD Restrictions**: A custom type `nonNegativeDouble` is defined in the XSD with an `xs:minInclusive` value of **0**.
* **Payload Interceptor**: A `PayloadValidatingInterceptor` is configured in `WebServiceConfig.java` to check every incoming request against the schema.
* **SOAP Faults**: Any request containing negative dimensions (e.g., a radius of -5) is automatically rejected. The service returns a **SOAP Fault** message instead of processing the invalid data.

## Project Structure
* `src/main/resources/schemas/shapes.xsd` — The service contract and validation rules.
* `src/main/java/com/ShapeTool/shape/config/` — Web Service and Interceptor configuration.
* `src/main/java/com/ShapeTool/shape/endpoint/` — Endpoint logic and area calculations.
* `src/test/java/requests.http` — Pre-configured SOAP requests for all shapes.

## How to Test the Service

### 1. View the WSDL
Once the application is running, the generated WSDL can be viewed at:
`http://localhost:8080/ws/shapetool.wsdl`

### 2. Run Sample Requests
Sample requests are provided in the IntelliJ HTTP Client format.
* **File Location**: `src/test/java/requests.http`
* **Instructions**: 
    1. Open the file in IntelliJ IDEA.
    2. Click the **Green Play Icon** next to a request block.
    3. The response will be displayed in the IntelliJ console, showing either the calculated area or a **Validation Error** (for negative numbers).

---
**Submitted by:** Belete Siyum  
**Submitted To:** Mr Demeke G.

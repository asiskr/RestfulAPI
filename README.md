# RestfulAPI with Jersey and MySQL

A simple RESTful API built using Java, Jersey (JAX-RS), and MySQL.  
It supports both JSON and XML formats for input and output.

## Features

- Retrieve all aliens
- Get an alien by ID
- Add a new alien (POST)
- Supports input in **JSON**
- Supports output in **XML** (can also be configured for JSON)

## Tech Stack

- Java 8
- Jersey 1.19.4
- MySQL 8
- Maven
- Apache Tomcat (or GlassFish)
- Postman (for testing)

## Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/your-username/your-repo-name.git


**CREATE THE DATABASE**
CREATE DATABASE restdb;

USE restdb;

CREATE TABLE alien (
  id INT PRIMARY KEY,
  name VARCHAR(20),
  points INT
);


**Get all aliens**
bash
Copy
Edit
GET /webresources/aliens
Returns: XML

**Get alien by ID**
bash
Copy
Edit
GET /webresources/aliens/alien/{id}
Returns: XML or JSON (based on Accept header)

**Add a new alien**
bash
Copy
Edit
POST /webresources/aliens/alien
Content-Type: application/json
Accept: application/xml


**Sample Body:**
json
Copy
Edit
{
  "id": 101,
  "name": "John",
  "point": 85
}

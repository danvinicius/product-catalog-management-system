## About
API built using Java, Java Spring, AWS SQS, AWS SNS and AWS S3 services for the [Anotaai Backend Challenge](https://github.com/githubanotaai/new-test-backend-nodejs/blob/master/README.md).<br/>
The aim of this project is to practice Java and Spring Framework with message-queueing concepets. 

<div style="display: inline_block">
    <img align="center" alt="Java" title="Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
    <img align="center" alt="Spring" title="Spring" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
    <img align="center" alt="AWS" title="AWS" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/amazonwebservices/amazonwebservices-original-wordmark.svg">
</div>
<br/>

## Product Catalog Management System
<h4> 
    ✅ Finished ✅
</h4>
<br/>

## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/danvinicius/product-catalog-management-system.git
```

2. Install dependencies with Maven

## Configuration

1. Create a configuration with your runtime environment variables with your AWS Credentials that are used in `application.properties`

```yaml
aws.region=us-east-1
aws.accessKeyId=111111
aws.secretKey=111111
```

2. Run MongoDB with Docker

```bash
docker run -p 27017:27017 -d mongo
```

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080

## API Endpoints
The API provides the following endpoints:

**API product**
```markdown
POST /api/product - Create a new product
GET /api/product - Retrieve all products
PUT /api/product/{id} - Updates a product
DELETE /api/product/{id} - Delete a product
```

**Body**
```json
{
  "title": "Produto para postar no tópico",
  "description": "",
  "ownerId": "4444444",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 10000
}
```

**API category**
```markdown
POST /api/category - Create a new category
GET /api/category - Retrieve all categories
PUT /api/category/{id} - Updates a category
DELETE /api/category/{id} - Delete a category
```

**Body**
```json
{
  "id": "393948882828",
  "title": "Teste",
  "description": "",
  "ownerId": "4444444"
}
```

<br/>
Install <a href="https://git-scm.com/">GIT</a> and <a href="https://www.java.com/pt-BR/">Java</a> on your computer.

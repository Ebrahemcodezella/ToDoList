echo "# 📝 ToDoList Application  
The **ToDoList** project is a task management application built with **Spring Boot**. It provides **CRUD** operations (Create, Read, Update, Delete) to manage tasks easily.

## 🚀 Features  
- Add new tasks.  
- View task list.  
- Update tasks.  
- Delete tasks.  

## 🛠️ Technologies Used  
- **Spring Boot** - Main framework.  
- **Spring Data JPA** - For database management.  
- **PostgreSQL** - Database used.  
- **Docker** (optional) - For easy deployment.  
- **Swagger** - Interactive API documentation.  

## ⚙️ Setup Guide  
### 1️⃣ **Clone the Repository**  
\`\`\`bash
git clone https://github.com/Ebrahemcodezella/ToDoList.git
cd ToDoList
\`\`\`

### 2️⃣ **Configure the Environment**  
- Ensure **Java 17+** and **Maven** are installed.  
- Modify **\`application.properties\`** to set up the database.  

### 3️⃣ **Run the Application**  
\`\`\`bash
mvn spring-boot:run
\`\`\`

## 📖 API Endpoints  
| Method  | Endpoint         | Description      |  
|---------|-----------------|-----------------|  
| \`POST\`  | \`/tasks\`        | Add a new task  |  
| \`GET\`   | \`/tasks\`        | Retrieve all tasks |  
| \`GET\`   | \`/tasks/{id}\`   | Retrieve a specific task |  
| \`PUT\`   | \`/tasks/{id}\`   | Update a task |  
| \`DELETE\`| \`/tasks/{id}\`   | Delete a task |  

## 🏗️ Build & Run with Docker  
\`\`\`bash
docker build -t todolist-app .
docker run -p 8080:8080 todolist-app
\`\`\`

## 📜 License  
This project is open-source under the **MIT License**.  

## ✨ Author  
**Ebrahem Hany** - [GitHub](https://github.com/Ebrahemcodezella)" > README.md

# 🍽️ Recipeee

Recipeee is the ultimate personalized recipe app where you can explore, create, and share culinary masterpieces tailored just for you! Discover a vast collection of recipes from around the world. Plus, with CRUD functionality, managing your recipes has never been easier - add, edit, or delete recipes with just a few clicks. Whether you're a seasoned chef or a beginner in the kitchen, Recipeee is your go-to app for cooking inspiration and organization. Start your culinary journey today and bring the joy of cooking to life!

## 🛠️ Technologies Used

 ![React](https://img.shields.io/badge/-React-61DAFB?style=flat-square&logo=react&logoColor=white)
 ![Tailwind CSS](https://img.shields.io/badge/-Tailwind_CSS-38B2AC?style=flat-square&logo=tailwind-css&logoColor=white)
 ![Spring Boot](https://img.shields.io/badge/-Spring_Boot-6DB33F?style=flat-square&logo=spring-boot&logoColor=white)
 ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
 ![JWT](https://img.shields.io/badge/-JWT-000000?style=flat-square&logo=json-web-tokens)
 ![Context API](https://img.shields.io/badge/-Context_API-3178C6?style=flat-square&logo=react&logoColor=white)


## 🖼️ Screenshots

![image1](https://github.com/manik-18/Recipeee/assets/102967918/588e94f5-451b-44d2-84c0-698eee8e3956)

![image2](https://github.com/manik-18/Recipeee/assets/102967918/068ef1bb-9a5e-4d09-8b15-c81b9d954089)

![image3](https://github.com/manik-18/Recipeee/assets/102967918/9dce7cb2-2b82-4d81-b54d-62cd44a69acd)

![image4](https://github.com/manik-18/Recipeee/assets/102967918/ac07d69c-102c-43c3-be85-00216cd748a9)

![image5](https://github.com/manik-18/Recipeee/assets/102967918/ac677b8c-b867-408b-b710-156e07e6dba8)

![image6](https://github.com/manik-18/Recipeee/assets/102967918/da72e26a-967e-478d-bead-27e0efd4e508)

![image7](https://github.com/manik-18/Recipeee/assets/102967918/3ca183fb-8124-4081-a0d8-39bafc6df8c3)


## 🔧 Setup

### Frontend

1. Navigate to the frontend folder.

```bash
cd frontend
```

2. Create a `.env` file and add the following line:

```plaintext
VITE_BACKEND_URL=http://localhost:8080
```

### Backend

1. Navigate to the `recipeee/src/main/resources` folder.

```bash
cd recipeee/src/main/resources
```

2. Open `application.properties` and replace `${DATABASE_USERNAME}` and `${DATABASE_PASSWORD}` with your database credentials.

```properties
spring.application.name=recipeee
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/recipeee
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## 🚀 API Endpoints

### Recipes

- **GET /api/recipes**: Retrieve all recipes.
- **POST /api/recipes**: Add a new recipe.
- **PUT /api/recipes/{id}**: Update a recipe.
- **DELETE /api/recipes/{id}**: Delete a recipe.

### User Profile

- **GET /api/users/profile**: Fetch user profile data.

### Authentication

- **POST /auth/signin**: Sign in user.
- **POST /auth/signup**: Sign up user.

## ▶️ How to Run

1. Start the backend server.

```bash
cd recipeee
./mvnw spring-boot:run
```

2. Start the frontend server.

```bash
cd frontend
npm run dev
```

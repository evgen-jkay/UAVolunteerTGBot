## UAVolunteerTGBot

#### Бот для прийому заявок на волонтерську допомогу.

### Демо

[@DemoUAVolunteerTGBot](https://t.me/DemoUAVolunteerTGBot)

### Створено за допомогою:
- Maven
- Java 11
- Spring Boot
- [Telegram Bot Library for Java](https://github.com/rubenlagus/TelegramBots)

### Функціонал бота:
- Дозволяє надсилати запити на допомогу від користувачів

### Запуск:
1. Створити бота через BotFather (`t.me/BotFather`)
2. Перейменуйте файл `application_example.yml` на `application.yml`
3. Вкажіть `token` та `username` в `application.yml`
4. Запустити `Application.main()`
5. Бот буде автоматично зареєстрований, оскільки містить
   `telegrambots-spring-boot-starter`
6. Тепер перейдіть до свого бота та спробуйте надіслати йому текст

### Налаштування бази даних:
1. В файлі `application.yml` внесіть параметри для підключення до бази даних.
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database_name
    username: your_username
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```
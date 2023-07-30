

# Дипломный проект по профессии «Тестировщик»

Дипломный проект представляет собой автоматизацию тестирования веб-сервиса, который взаимодействует с СУБД и API банка.

## Документация

#### [Дипломное задание](docs/TechnicalTask.md)

#### [План автоматизации тестирования](docs/Plan.md)

#### [Отчётные документы по итогам тестирования](docs/Report.md)

#### [Отчётные документы по итогам автоматизации](docs/interval estimation.md)

### Процедура запуска авто-тестов для *MySQL*
1. Для запуска авто-тестов нужно заранее установить и запустить Docker Desktop на локальной машине

2. Запустить *IntelliJ IDEA*

3. Воспользоваться интерфейсом *IntelliJ IDEA:* клонировать репозиторий  
   >`git clone https://github.com/cptHenryMorgan/diplom_project.git`

4. Запустить контейнеры Docker командой в терминале №1:
   >`docker-compose up`

5. Запустить приложение командой в терминале №2:

   >`java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar`

6. Запустить авто-тесты командой в терминале №3:

   >`./gradlew clean test "-Ddb.url=jdbc:mysql://localhost:3306/app" "-Ddb.username=app" "-Ddb.password=pass"`

7. Создание *Allure* отчёта командой в терминале №3:
   >`./gradlew allureReport` - формирование отчёта

   >`./gradlew allureServe` - отображение отчёта в браузере

   После просмотра отчета в браузере
 
   > `Ctrl+C` + Y + Enter - остановить отображение отчёта в браузере

8. После выполнения всех тестов и генерации отчета командой в терминале №2:

- остановить работу приложения: 
  `Ctrl+C`
9. После выполнения всех тестов и генерации отчета командой в терминале №3:
- остановить работу контейнеров Docker:
    `Ctrl+C`
  `docker-compose down`

### Процедура запуска авто-тестов для *PostgreSQL*:
1. Для запуска авто-тестов нужно заранее установить и запустить Docker Desktop на локальной машине

2. Запустить *IntelliJ IDEA*

3. Воспользоваться интерфейсом *IntelliJ IDEA:* клонировать репозиторий  
   `git clone https://github.com/cptHenryMorgan/diplom_project.git`

4. Запустить контейнеры Docker командой в терминале №1:
   >`docker-compose up`

5. Запустить приложение командой в терминале №2:

   >`java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" "-Dspring.datasource.username=app" "-Dspring.datasource.password=pass" -jar artifacts/aqa-shop.jar`

6. Запустить авто-тесты командой в терминале №3:

   >`./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app" "-Ddb.username=app" "-Ddb.password=pass"`

7. Создание *Allure* отчёта командой в терминале №2:

   >`./gradlew allureReport` - формирование отчёта

   >`./gradlew allureServe` - отображение отчёта в браузере
   
   > `Ctrl+C` + Y + Enter - остановить отображение отчёта в браузере

8. После выполнения всех тестов и генерации отчета командой в терминале №2:

- остановить работу приложения: 
  `Ctrl+C`
9. После выполнения всех тестов и генерации отчета командой в терминале №3:
- остановить работу контейнеров Docker:
    `Ctrl+C`
  `docker-compose down`
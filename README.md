Необходимо разработать REST сервис-адаптер к SOAP веб-сервису.

Сервис источник: http://www.dneonline.com/calculator.asmx

Выходной частью сервиса-адаптера должен быть REST-интерфейс, который принимает значения для передачи в SOAP веб-сервис.

Необходимо предусмотреть валидацию запросов к REST-сервису на предмет их наличия, корректности формата и т.п.

Будет плюсом, если у реализованного сервиса будет спецификация в формате OpenAPI (SWAGGER), которая генерируется автоматически из кода.

Код должен работать с системой контроля версий GIT.

Фреймворки и инструменты, которые помогут реализовать задачу:

Spring, Spring Boot, Apache CXF, Apache Axis, Jackson, GSON, Apache Camel

Минимальный решение - синхронно работающий рест сервис, преобразующий SOAP в REST запросы.

Максимальный решение - запросы кешируются в распределенном кеше, т.е. сначала ищется есть ли в кеше уже аналогичный запрос на расчет с результатом,

и если нет, то идет обращение в SOAP калькулятор, и результат отдается потребителю, а также складывается в кеш для последующих запросов.

Swagger: http://localhost:8081/swagger-ui.html#/ 

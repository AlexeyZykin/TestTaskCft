## Курс Java SHIFT. Тестовое задание. Инструкция
### Стек технологий
- Java 21
- Сборщик: Gradle 8.5
- Сторонние библиотеки: 
  - slf4j-api, версия 2.0.17 - 'org.slf4j:slf4j-api:2.0.17'
  - logback-classic, версия 1.5.24 - 'ch.qos.logback:logback-classic:1.5.24'

### Как запустить
Для запуска проекта выполните следующие шаги:
1. Клонируйте репозиторий:
```bash
git clone https://github.com/AlexeyZykin/TestTaskCft.git
```
2. Перейдите в директорию проекта:
```bash
cd TestTaskCft
```
3. Соберите проект с помощью Gradle:
```bash
./gradlew build
```
4. Запустите jar file с аргументами (аргументы описаны ниже):
```bash
java -jar build/libs/data-filter-util.jar [ОПЦИИ] [ВХОДНЫЕ ФАЙЛЫ]
```

### Опции
- -o дает возможность задавать путь для результатов. `-o ./output`
- -p задает префикс имен выходных файлов. `-p result_`
- -a Если файл существует, данные добавляются в конец, а не перезаписываются.
- -s дает краткую статистику.
- -f дает полную статистику.

### Пример запуска
```bash
java -jar build/libs/data-filter-util.jar -s -a -p sample- in1.txt in2.txt
```


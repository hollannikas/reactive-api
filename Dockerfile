FROM openjdk:8-jdk

# copy files into working directory
COPY . .

# build Kotlin
RUN ./gradlew clean build -x test
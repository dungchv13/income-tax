FROM openjdk:8
COPY ./target/income_tax_caculator-0.0.1-SNAPSHOT.jar income_tax-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","income_tax-0.0.1-SNAPSHOT.jar"]

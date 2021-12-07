# Currency Converter App

> Currency converter app is used for convert different currencies between each other. 
<p align="center">
  <a href="">
    <img src="https://img.shields.io/travis/dbader/node-datadog-metrics/master.svg?style=flat-square" />
  </a>
  <a href="https://github.com/113-GittiGidiyor-Java-Spring-Bootcamp/gittigidiyor-graduation-project-mGungorr/blob/main/LICENSE">
    <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-yellow.svg" target="_blank" />
  </a>
  <a href="">
    <img src="https://codecov.io/gh/kefranabg/readme-md-generator/branch/master/graph/badge.svg" />
  </a>
</p>

- [✨ Preview](#demo-preview)
- [📥 Installation](#installation)
- [🚀 Usage](#usage)
- [⚙️ API Example](#contribute)
- [⚙️ Tech Stack](#contribute)

- [🤝 Contributing](#license)
- [⌨️ Author](#footer)
- [📝 License](#license)

[(Back to top)](#table-of-contents)
## ✨ Preview



https://user-images.githubusercontent.com/80898514/145052242-9e44c0e9-0f80-427c-a35b-b07d2c623573.mp4







## 📥 Installation
- You should install Redis on your computer.

[Redis Download](https://redis.io/download)

- Clone the repo

```
git clone https://github.com/Nevzatcs/currency-converter-app.git
```

- On a separate terminal and since this is a maven project you just need to go to the root of the project and perform the
command:

```
mvn clean install
```

- or if you don't have installed maven on your OS

```
mvnw clan install
```

- This will run the unit tests of the project and create the jar file.

[(Back to top)](#table-of-contents)
## 🚀 Usage
- After having the jar file you can simply run:

```
java -jar target/currency-converter-0.0.1-SNAPSHOT.jar
```

- Since this is a Spring Boot project, you can also run the project with below command;

```
mvn spring-boot:run
```

- or if you don't have installed maven on your OS

```
mvnw spring-boot:run
```
[(Back to top)](#table-of-contents)
## ⚙️ API Example
- The project will run on port 8080 (configured as default).



- Main application URL for local: `http://localhost:8080`



* POST Currency Convert :

```  
{
  from:"TRY",
  to:"usd",
  value:"100"
} 
  ```

* Currencies

 There ara 170 currencies all around the world.
```
     CAD
     CHF
     EUR
     GBP
     TRY
     USD and more...
```
[(Back to top)](#table-of-contents)
## ⚙️ Tech Stack
- Java 8
- Spring Boot
- Spring Web
- Lombok
- JUnit
- Maven
- JPA / Hibernate
- Redis
- Mockito
- Thymeleaf

[(Back to top)](#table-of-contents)





## 🤝 Contributing
1. Fork it (<https://github.com/Nevzatcs/currency-converter-app/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request

[(Back to top)](#table-of-contents)
## ⌨️ Author


👤 **Nevzat Can Samur**

- Github: [@Nevzatcs](https://github.com/Nevzatcs)
- Linkedin: [@nevzatcansamur](https://www.linkedin.com/in/nevzatcansamur/)
  
[(Back to top)](#table-of-contents)
## 📝 License


Copyright © 2021.

This project is [MIT](https://github.com/Nevzatcs/player-app/blob/main/LICENSE) licensed.


---
[(Back to top)](#table-of-contents)

This README was generated with ❤️ 

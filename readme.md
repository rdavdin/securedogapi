##### Some changes for security configuration

- This is an example of changing security configuration appropriately after class ```WebSecurityConfigurerAdapter``` deprecated.

- Some guide written on official blog [here - Spring Security without the WebSecurityConfigurerAdapter](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter/)

- I changed the files ```pom.xml``` to ```pom.xmlold```, and ```SpringSecurityConfig.java``` to ```SpringSecurityConfig.javaold```. This is convenient for comparing to the new ones.

- You can have a look at [this file](https://github.com/rdavdin/CloudStorage/blob/main/src/main/java/com/udacity/jwdnd/course1/cloudstorage/security/SecurityConfig.java).
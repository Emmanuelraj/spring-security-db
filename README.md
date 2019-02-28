# spring-security-db
Spring Security &amp; Register Using sql Authorization & Authentication using UserDetailsService in a Spring Boot App (register,login,logout)


# This example covers 
             
            1)  Register user and role (one to many mapping)
            2)  Authentication using Sql DB Connectivity using custom user details service.
            3)  Authorization using GrantedAuthority roles for method level security
            4)  how to use the interface of an UserDetailsService 
            
# Url Mapping :
            
            http://localhost:4000/register                ----> register (role : either USER (OR) ADMIN) still validation remaining 
            http://localhost:4000/secured/loginUser       ----> for User Role Login
            http://localhost:4000/secured/login           ----> for Admin Role Login  
            
            Note: Register first and then use other urls
               

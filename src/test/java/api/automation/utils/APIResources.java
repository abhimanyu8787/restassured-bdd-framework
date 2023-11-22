package api.automation.utils;

public enum APIResources {
    
    ListUsersAPI("/api/users"),
    RegisterUserAPI("/api/register"),
    LoginAPI("/api/login"),
    CreateUserAPI("/api/users"),
    ListUsers200ResponseSchema("src\\test\\resources\\jsonschema\\ListUsers200ResponseSchema.json"),
    RegisterUser200ResponseSchema("src\\test\\resources\\jsonschema\\RegisterUser200ResponseSchema.json"),
    LoginUser200ResponseSchema("src\\test\\resources\\jsonschema\\LoginUser200ResponseSchema.json"),
    CreateUser200ResponseSchema("src\\test\\resources\\jsonschema\\CreateUser200ResponseSchema.json"),
    PGSignup200ResponseSchema("src\\test\\resources\\jsonschema\\PGSignup200ResponseSchema.json"),
    PgSignupAPI("/api/auth/signup"),
    PgSignupAPIUSers("/api/users"),
    PgSigninAPI("/api/auth"),
    PgLandingPage("/api/cluster/landing-page"),
    PgLandingPageSettings("/api/cluster/landing-page/1692");
    
    private String resource;
    
    APIResources(String resource){
        this.resource = resource;
    }
    
    public String getResource() {
        return resource;
    }

}

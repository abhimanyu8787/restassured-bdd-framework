package api.automation.utils;

public enum APIResources {
    
    ListUsersAPI("/api/users"),
    RegisterUserAPI("/api/register"),
    LoginAPI("/api/login"),
    ListUsers200ResponseSchema("src\\test\\resources\\jsonschema\\ListUsers200ResponseSchema.json"),
    CreateUser200ResponseSchema("src\\test\\resources\\jsonschema\\CreateUser200ResponseSchema.json"),
    LoginUser200ResponseSchema("src\\test\\resources\\jsonschema\\LoginUser200ResponseSchema.json");
    
    private String resource;
    
    APIResources(String resource){
        this.resource = resource;
    }
    
    public String getResource() {
        return resource;
    }

}
